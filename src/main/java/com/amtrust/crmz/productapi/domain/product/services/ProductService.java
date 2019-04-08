package com.amtrust.crmz.productapi.domain.product.services;

import com.amtrust.crmz.productapi.domain.product.models.Product;
import com.amtrust.crmz.productapi.domain.product.repository.ProductRepository;
import com.amtrust.crmz.productapi.exceptions.InvalidProductException;
import com.amtrust.crmz.productapi.exceptions.ProductExceptionType;
import com.amtrust.crmz.productapi.metric.service.MetricsService;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
@Log4j2
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private static String TIMER_NAME = "service.product.duration";
    private static String COUNTER_NAME = "service.product.counter";
    private static String ERROR_COUNTER_NAME = "service.product.error.counter";

    public ProductService(PrometheusMeterRegistry prometheusMeterRegistry) {
        Metrics.addRegistry(prometheusMeterRegistry);
    }

    public List<Product> getAllProducts() {
        long start = System.currentTimeMillis();

        List<Product> products = productRepository.findAll();

        MetricsService.observeTime(TIMER_NAME, System.currentTimeMillis() - start, "method", "get.all");
        MetricsService.incrementCounter(COUNTER_NAME, "method", "get.all");

        return products;
    }

    public Product getProductByProductCode(String productCode) {
        long start = System.currentTimeMillis();

        Product product = productRepository.findByProductCode(productCode);

        MetricsService.observeTime(TIMER_NAME, System.currentTimeMillis() - start, "method", "get.by.productCode");
        if (product == null) {
            MetricsService.incrementCounter(ERROR_COUNTER_NAME, "method", "get.by.productCode", "error", "nonexistent.product", "validation.error", "na");
        }
        MetricsService.incrementCounter(COUNTER_NAME, "method", "get.by.productCode");

        return product;
    }

    public void createProduct(Product product) throws InvalidProductException {
        long start = System.currentTimeMillis();

        try {
            if (Product.validate(product)) {
                if (productExists(product.getProductCode())) {
                    log.warn("Duplicate product code detected: {}", product.getProductCode());
                    throw new InvalidProductException(ProductExceptionType.PRODUCT_CODE_EXISTS.getMessage());
                } else {
                    productRepository.save(product);
                }
            }
        } catch (InvalidProductException ex) {
            if (CollectionUtils.isEmpty(ex.getValidationErrors())) {
                MetricsService.incrementCounter(ERROR_COUNTER_NAME, "method", "add", "error", ex.getMessage(), "validation.error", "na");
            } else {
                ex.getValidationErrors().forEach(apiValidationError -> MetricsService.incrementCounter(ERROR_COUNTER_NAME, "method", "add", "error", ex.getMessage(), "validation.error", "na"));
            }
            throw ex;
        } finally {
            MetricsService.observeTime(TIMER_NAME, System.currentTimeMillis() - start, "method", "add");
            MetricsService.incrementCounter(COUNTER_NAME, "method", "add");
        }
    }

    public void updateProduct(String productCode, Product product) throws InvalidProductException {
        long start = System.currentTimeMillis();

        Product targetProduct = getProductByProductCode(productCode);

        try {
            if (Product.validate(targetProduct)) {
                if (!StringUtils.isEmpty(product.getName())) {
                    targetProduct.setName(product.getName());
                }

                if (!StringUtils.isEmpty(product.getProductCode())) {
                    targetProduct.setProductCode(product.getProductCode());
                }

                productRepository.update(productCode, targetProduct);
            }

        } catch (InvalidProductException ex) {
            if (CollectionUtils.isEmpty(ex.getValidationErrors())) {
                MetricsService.incrementCounter(ERROR_COUNTER_NAME, "method", "update", "error", ex.getMessage(), "validation.error", "na");
            } else {
                ex.getValidationErrors().forEach(apiValidationError -> MetricsService.incrementCounter(ERROR_COUNTER_NAME, "method", "update", "error", ex.getMessage(), "validation.error", apiValidationError.getMessage()));
            }

            throw ex;

        } finally {
            MetricsService.observeTime(TIMER_NAME, System.currentTimeMillis() - start, "method", "update");
            MetricsService.incrementCounter(COUNTER_NAME, "method", "update");
        }
    }

    private boolean productExists(String productCode) {
        return getProductByProductCode(productCode) != null;
    }

}
