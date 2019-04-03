package com.amtrust.crmz.productapi.product.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
public class Rules {
    private BigDecimal claimLimitValue;
    private String claimCountConfig;
    private String subsequentClaimConfig;
    private String excessFeeConfig;
    private BigDecimal excessFeeRepairVariableValue;
    private BigDecimal excessFeeReplacementVariableValue;
    private int excessFeeTimeLimitInDays;
    private int logisticsConfig;
    private int serviceLevelPromiseInDays;
    private BigDecimal salvageValue;
    private double internalSalvageRate;
    private String settlementConfig;
    private int waitingPeriodForClaimInDays;
    private double reinsuranceRate;

    private enum logistics {PICKUP_AND_DROP};
}
