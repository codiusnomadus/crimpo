package com.amtrust.crmz.productapi.validations;

import com.amtrust.crmz.productapi.product.models.Product;
import com.amtrust.crmz.productapi.product.services.ProductService;

import java.util.List;

public class Validations {
    private ProductService productService;



    public String validate(Product product) {

        return productNameCannotBeEmpty(product);
    }

    public String productNameCannotBeEmpty(Product product) {
        if (product.getName() == "John") {
            return "Product name cannot be John";
        } else {
            return null;
        }
    }
}
