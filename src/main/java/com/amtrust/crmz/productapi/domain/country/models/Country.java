package com.amtrust.crmz.productapi.domain.country.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document(collection = "countries")
@Data
public class Country {
    @NotNull
    private String name;

    @NotNull
    @Size(min = 2, max = 2)
    private String isoCode;
}
