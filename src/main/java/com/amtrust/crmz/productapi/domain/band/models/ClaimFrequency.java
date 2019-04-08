package com.amtrust.crmz.productapi.domain.band.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import javax.validation.constraints.NotNull;


@Data
public class ClaimFrequency {
    @NotNull
    private double repairRate;

    @NotNull
    private double berRate;

    @NotNull
    private double theftRate;

    @Transient
    @JsonGetter(value = "claimFrequencyTotalRate")
    public double getClaimFrequencyTotalRate() {
        return this.getRepairRate() + this.getBerRate() + this.getTheftRate();
    }
}
