package com.amtrust.crmz.productapi.domain.insurer.models;

import com.amtrust.crmz.productapi.common.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "insurers")
@Data
public class Insurer extends BaseModel {
    @NotNull
    @Size(min = 2)
    private String name;

    @NotNull
    @Size(min = 2)
    private String insurerCode;
}
