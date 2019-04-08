package com.amtrust.crmz.productapi.domain.device.models;

import com.amtrust.crmz.productapi.common.BaseModel;
import com.amtrust.crmz.productapi.domain.product.models.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "devices")
@Data
public class Device extends BaseModel {
    @NotNull
    @Size(min = 2)
    private String name;

    @NotNull
    private Product product;

    @NotNull
    @Size(min = 2)
    private String deviceCode;
}
