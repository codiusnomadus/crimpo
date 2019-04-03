package com.amtrust.crmz.productapi.product.models;

import com.amtrust.crmz.productapi.common.BaseModel;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "devices")
@Data
public class Device extends BaseModel {

    private String name;
    private Product product;

    public void setProduct(Product product) {
        this.product = product;
    }
}
