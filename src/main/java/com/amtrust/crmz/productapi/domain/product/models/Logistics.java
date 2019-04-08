package com.amtrust.crmz.productapi.domain.product.models;

public enum Logistics {
    PICKUP_AND_DROP ("Pickup & Drop"),
    PICKUP_ONLY ("Pickup only"),
    DROP_ONLY ("Drop only"),
    NONE ("None");

    private final String name;

    Logistics(String name) {
        this.name = name;
    }
}
