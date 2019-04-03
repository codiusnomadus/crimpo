package com.amtrust.crmz.productapi.product.models;

import com.amtrust.crmz.productapi.common.BaseModel;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "coverages")
@Data
public class Coverage extends BaseModel {

    private String name;
}
