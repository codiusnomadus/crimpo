package com.amtrust.crmz.productapi.domain.band.models;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
class ExcessFee {
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
