package com.amtrust.crmz.productapi.product.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Cost {
    private double insuranceRate;
    private BigDecimal excessFeeWaiverForTheft;
    private BigDecimal excessFeeWaiverForRepair;
    private BigDecimal excessFeeWaiverForBer;
}
