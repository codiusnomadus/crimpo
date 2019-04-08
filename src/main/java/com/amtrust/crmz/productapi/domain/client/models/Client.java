package com.amtrust.crmz.productapi.domain.client.models;

import com.amtrust.crmz.productapi.common.BaseModel;
import com.amtrust.crmz.productapi.domain.country.models.Country;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "clients")
@Data
public class Client extends BaseModel {
    @NotNull
    @Size(min = 2)
    private String name;

    @NotNull
    private Channel channel;

    @NotNull
    private Country country;
}
