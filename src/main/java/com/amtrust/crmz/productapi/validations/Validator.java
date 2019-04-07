package com.amtrust.crmz.productapi.validations;

import com.amtrust.crmz.productapi.product.models.Product;
import com.amtrust.crmz.productapi.product.services.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private ProductService productService;

    List<String> validationErrors = new ArrayList<String>();

    public List<String> validate(Product product) {
        if (product.getName() == "John") {
            productNameCannotBeEmpty(product);
        }

        return validationErrors;
    }

    private void productNameCannotBeEmpty(Product product) {
        validationErrors.add("Name cannot be John");
    }


}
