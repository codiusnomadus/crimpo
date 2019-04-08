package com.amtrust.crmz.productapi.domain.product.repository;

import com.amtrust.crmz.productapi.domain.product.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String>, CustomProductRepository {

    Product findByProductCode(String productCode);

}
