package com.amtrust.crmz.productapi.exceptions;

public enum ProductExceptionType {
    PRODUCT_DOESNT_EXIST("Invalid product"),
    NAME_EXISTS("Name already exists"),
    PRODUCT_CODE_EXISTS("Product code already exists"),
    NAME_MISSING("Name is missing"),
    NAME_MIN_LENGTH("Name should be at least 2 characters");

    String message;
    ProductExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
