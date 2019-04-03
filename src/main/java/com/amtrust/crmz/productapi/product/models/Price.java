package com.amtrust.crmz.productapi.product.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Price {
    private BigDecimal retailPriceValue;
    private double taxRate;
    private BigDecimal partnerProfitShareValue;
    private double partnerProfitShareRate;
    private double clientMarginRate;
}
