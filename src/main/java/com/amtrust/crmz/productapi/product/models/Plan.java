package com.amtrust.crmz.productapi.product.models;

import com.amtrust.crmz.productapi.common.BaseModel;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "plans")
@Data
public class Plan extends BaseModel {
    private int productStatus;
    private String name;
    private String planCode;
    private String description;

    private Coverage coverage;
    private Product product;
    private Band band;
}
