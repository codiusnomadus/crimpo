package com.amtrust.crmz.productapi.product.repository;

import com.amtrust.crmz.productapi.product.models.Product;

public interface CustomProductRepository {
    Product findByProductCode(String productCode);
}
