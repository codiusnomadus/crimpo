package com.amtrust.crmz.productapi.domain.band.models;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
class Cost {
    @NotNull
    private double insuranceAverageRate;

    @NotNull
    private BigDecimal excessFeeWaiverForTheft;

    @NotNull
    private BigDecimal excessFeeWaiverForRepair;

    @NotNull
    private BigDecimal excessFeeWaiverForBer;

    double getInsuranceAverageRate() {
        return this.insuranceAverageRate;
    }
}
