package com.amtrust.crmz.productapi.domain.product.repository;

import com.amtrust.crmz.productapi.domain.product.models.Product;

public interface CustomProductRepository {
    long update(String productCode, Product product);

    Product findByProductCode(String productCode);
}
