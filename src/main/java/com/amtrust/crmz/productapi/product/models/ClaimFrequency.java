package com.amtrust.crmz.productapi.product.models;

import lombok.Data;

@Data
public class ClaimFrequency {
    private double repairRate;
    private double berRate;
    private double theftRate;
}
