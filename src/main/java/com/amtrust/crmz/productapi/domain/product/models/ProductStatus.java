package com.amtrust.crmz.productapi.domain.product.models;

public enum ProductStatus {
    ACTIVE ("Active"),
    INACTIVE ("Inactive"),
    PRE_LAUNCH ("Pre-launch");

    private final String name;

    ProductStatus(String name) {
        this.name = name;
    }
}
