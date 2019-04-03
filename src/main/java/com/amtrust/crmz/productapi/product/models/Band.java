package com.amtrust.crmz.productapi.product.models;

import com.amtrust.crmz.productapi.common.BaseModel;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "bands")
@Data
public class Band extends BaseModel {

    private int bandNumber;
    private BigDecimal startRange;
    private BigDecimal endRange;
    private BigDecimal averageDevicePrice;
    private double salesMix;
    private BigDecimal weightedAverage;
    private ClaimFrequency claimFrequency;
    private ClaimSeverity claimSeverity;
    private ExcessFee excessFee;
    private Cost cost;
    private Price price;
}
