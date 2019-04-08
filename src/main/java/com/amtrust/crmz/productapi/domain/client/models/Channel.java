package com.amtrust.crmz.productapi.domain.client.models;

public enum Channel {
    OEM ("OEM"),
    TELCO ("Telco"),
    RETAILER ("Retailer");

    private final String name;

    Channel(String name) {
        this.name = name;
    }
}
