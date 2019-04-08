package com.amtrust.crmz.productapi.domain.plan.models;

import com.amtrust.crmz.productapi.common.BaseModel;
import com.amtrust.crmz.productapi.domain.band.models.Band;
import com.amtrust.crmz.productapi.domain.coverage.models.Coverage;
import com.amtrust.crmz.productapi.domain.product.models.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "plans")
@Data
public class Plan extends BaseModel {
    @NotNull
    private String name;

    @NotNull
    private String planCode;

    @NotNull
    private String description;

    @NotNull
    private Coverage coverage;

    @NotNull
    private Product product;

    @NotNull
    private Band band;
}
