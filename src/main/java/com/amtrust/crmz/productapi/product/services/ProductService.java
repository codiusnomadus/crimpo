package com.amtrust.crmz.productapi.product.services;

import com.amtrust.crmz.productapi.product.models.Product;
import com.amtrust.crmz.productapi.product.repository.ProductRepository;
import com.amtrust.crmz.productapi.validations.Validations;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    Validations validations = new Validations();

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public void createProduct(Product product) {


        if (validations.validate(product) == null) {
            productRepository.save(product);
        }

    }

    public Product getProduct(String productCode) {
        Product product = productRepository.findByProductCode(productCode);
        return product;
    }
}
