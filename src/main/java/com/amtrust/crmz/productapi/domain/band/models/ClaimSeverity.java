package com.amtrust.crmz.productapi.domain.band.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import javax.validation.constraints.NotNull;

@Data
class ClaimSeverity {
    @NotNull
    private double repairRate;

    @NotNull
    private double berRate;

    @NotNull
    private double theftRate;

    double getRepairRate() {
        return this.repairRate / 100;
    }

    double getBerRate() {
        return this.berRate / 100;
    }

    double getTheftRate() {
        return this.theftRate / 100;
    }
}
