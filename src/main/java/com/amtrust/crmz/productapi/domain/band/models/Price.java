package com.amtrust.crmz.productapi.domain.band.models;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class Price {
    @NotNull
    private BigDecimal retailPriceValue;

    @NotNull
    private double taxRate;

    @NotNull
    private BigDecimal partnerProfitShareValue;

    @NotNull
    private double partnerProfitShareRate;

    @NotNull
    private double clientMarginRate;
}
