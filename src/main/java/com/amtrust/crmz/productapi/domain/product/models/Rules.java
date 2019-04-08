package com.amtrust.crmz.productapi.domain.product.models;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class Rules {
    @NotNull
    private BigDecimal claimLimitValue;

    @NotNull
    private String claimCountConfig;

    @NotNull
    private String subsequentClaimConfig;

    @NotNull
    private String excessFeeConfig;

    private BigDecimal excessFeeRepairVariableValue;

    private BigDecimal excessFeeReplacementVariableValue;

    private int excessFeeTimeLimitInDays;

    private Logistics logistics;

    @NotNull
    private int serviceLevelPromiseInDays;

    private BigDecimal salvageValue;

    private double internalSalvageRate;

    @NotNull
    private String settlementConfig;

    @NotNull
    private int waitingPeriodForClaimInDays;

    @NotNull
    private double reinsuranceRate;

}
