package com.amtrust.crmz.productapi.domain.band.models;

import com.amtrust.crmz.productapi.common.BaseModel;
import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Document(collection = "bands")
@Data
public class Band extends BaseModel {

    @NotNull
    private int bandNumber;

    @NotNull
    private BigDecimal devicePriceStartingRange;

    @NotNull
    private BigDecimal devicePriceEndingRange;

    @NotNull
    private double salesMixRate;

    @NotNull
    private ClaimFrequency claimFrequency;

    @NotNull
    private ClaimSeverity claimSeverity;

    @NotNull
    private ExcessFee excessFee;

    @NotNull
    private Cost cost;

    @NotNull
    private Price price;

    @NotNull
    private double claimRiskUnderwritingRate;

    public double getClaimRiskUnderwritingRate() {
        return this.claimRiskUnderwritingRate / 100;
    }

    @Transient
    @JsonGetter(value = "averageDevicePrice")
    public BigDecimal getAverageDevicePrice() {
        return this.getDevicePriceEndingRange().add(this.getDevicePriceEndingRange());
    }

    public double getSalesMixRate() {
        return this.salesMixRate / 100;
    }

    @Transient
    @JsonGetter(value = "weightedAverage")
    public BigDecimal getWeightedAverage() {
        return this.getAverageDevicePrice().multiply(new BigDecimal(this.getSalesMixRate()));
    }

    @Transient
    @JsonGetter(value = "claimSeverityRepairValue")
    public BigDecimal getClaimSeverityRepairValue() {
        return this.getAverageDevicePrice().multiply(new BigDecimal(this.getClaimSeverity().getRepairRate()));
    }

    @Transient
    @JsonGetter(value = "claimSeverityBerValue")
    public BigDecimal getClaimSeverityBerValue() {
        return this.getAverageDevicePrice().multiply(new BigDecimal(this.getClaimSeverity().getBerRate()));
    }

    @Transient
    @JsonGetter(value = "claimSeverityTheftValue")
    public BigDecimal getClaimSeverityTheftValue() {
        return this.getAverageDevicePrice().multiply(new BigDecimal(this.getClaimSeverity().getTheftRate()));
    }

    @Transient
    @JsonGetter(value = "excessFeeRepairValue")
    public BigDecimal getExcessFeeRepairValue() {
        return this.getAverageDevicePrice().multiply(new BigDecimal(this.getExcessFee().getRepairRate()));
    }

    @Transient
    @JsonGetter(value = "excessFeeBerValue")
    public BigDecimal getExcessFeeBerValue() {
        return this.getAverageDevicePrice().multiply(new BigDecimal(this.getExcessFee().getBerRate()));
    }

    @Transient
    @JsonGetter(value = "excessFeeBerValue")
    public BigDecimal getExcessFeeTheftValue() {
        return this.getAverageDevicePrice().multiply(new BigDecimal(this.getExcessFee().getTheftRate()));
    }

    @Transient
    @JsonGetter(value = "claimRiskRepairValue")
    public BigDecimal getClaimRiskRepairValue() {
        BigDecimal initialValue = this.getClaimSeverityRepairValue().subtract(this.getExcessFeeRepairValue());
        return initialValue.multiply(new BigDecimal(this.getClaimFrequency().getRepairRate()));
    }

    @Transient
    @JsonGetter(value = "claimRiskBerValue")
    public BigDecimal getClaimRiskBerValue() {
        BigDecimal initialValue = this.getClaimSeverityBerValue().subtract(this.getExcessFeeBerValue());
        return initialValue.multiply(new BigDecimal(this.getClaimFrequency().getBerRate()));
    }

    @Transient
    @JsonGetter(value = "claimRiskTheftValue")
    public BigDecimal getClaimRiskTheftValue() {
        BigDecimal initialValue = this.getClaimSeverityTheftValue().subtract(this.getExcessFeeTheftValue());
        return initialValue.multiply(new BigDecimal(this.getClaimFrequency().getTheftRate()));
    }

    @Transient
    @JsonGetter(value = "claimRiskSubTotalValue")
    public BigDecimal getClaimRiskSubTotalValue() {
        return this.getClaimRiskRepairValue().add(this.getClaimRiskBerValue()).add(this.getClaimRiskTheftValue());
    }

    @Transient
    @JsonGetter(value = "claimRiskUnderwritingValue")
    public BigDecimal getClaimRiskUnderwritingValue() {
        double initialValue = 1 - this.getClaimRiskUnderwritingRate();
        BigDecimal updatedClaimRiskSubTotalValue = new BigDecimal(initialValue).subtract(this.getClaimRiskSubTotalValue());
        return this.getClaimRiskSubTotalValue().divide(updatedClaimRiskSubTotalValue);
    }

    @Transient
    @JsonGetter(value = "claimRiskTechnicalRatingValue")
    public BigDecimal getClaimRiskTechnicalRatingValue() {
        return this.getClaimRiskSubTotalValue().add(this.getClaimRiskUnderwritingValue());
    }

    @Transient
    @JsonGetter(value = "claimRiskTechnicalRatingRate")
    public BigDecimal getClaimRiskTechnicalRatingRate() {
        return this.getClaimRiskTechnicalRatingValue().divide(this.getAverageDevicePrice());
    }

    @Transient
    @JsonGetter(value = "costInsuranceValue")
    public BigDecimal getCostInsuranceValue() {
        return new BigDecimal(this.getCost().getInsuranceAverageRate()).multiply(this.getAverageDevicePrice());
    }

    @Transient
    @JsonGetter(value = "costContingencyAverageRate")
    public BigDecimal getCostContingencyAverageRate() {
        if (this.getClaimRiskTechnicalRatingRate().compareTo(new BigDecimal(this.getCost().getInsuranceAverageRate())) < 0){
            return new BigDecimal(0);
        } else {
            return this.getClaimRiskTechnicalRatingRate().subtract(new BigDecimal(this.getCost().getInsuranceAverageRate()));
        }
    }

    @Transient
    @JsonGetter(value = "costContingencyValue")
    public BigDecimal getCostContingencyValue() {
        return this.getCostContingencyAverageRate().multiply(this.getAverageDevicePrice());
    }

    @Transient
    @JsonGetter(value = "costContingencyValue")
    public BigDecimal getCostContingencyValue() {
    }
}
