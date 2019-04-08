package com.amtrust.crmz.productapi.domain.product.models;

public enum SubscriptionType {
    MONTHLY ("Monthly"),
    ANNUAL ("Annual");

    private final String name;

    SubscriptionType(String name) {
        this.name = name;
    }
}
