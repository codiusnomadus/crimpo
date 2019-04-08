package com.amtrust.crmz.productapi.domain.product.repository;

import com.amtrust.crmz.productapi.domain.product.models.Product;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Date;

public class CustomProductRepositoryImpl implements CustomProductRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Product findByProductCode(String productCode) {
        Query query = new Query(Criteria.where("productCode").is(productCode));
        return mongoTemplate.findOne(query, Product.class);
    }

    @Override
    public long update(String productCode, Product product) {
        Query query = new Query(Criteria.where("productCode").is(productCode));

        Update update = new Update();

        update.set("name", product.getName());
        update.set("productCode", product.getProductCode());
        update.set("updatedOn", new Date());

        UpdateResult result = mongoTemplate.updateFirst(query, update, Product.class);

        if (result != null) {
            return result.getModifiedCount();
        } else {
            return 0;
        }
    }
}
