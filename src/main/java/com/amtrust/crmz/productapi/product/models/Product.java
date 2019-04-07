package com.amtrust.crmz.productapi.product.models;

import com.amtrust.crmz.productapi.common.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Document(collection = "products")
@Log4j2
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product extends BaseModel {
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String productCode;

    private String description;
    private String terms;

    private int productStatus;

    private Client client;
    private Insurer insurer;

    private Set<Device> devices = new HashSet<>();
    private String clientProductName;
    private String clientProductDescription;
    private Date startDateForSales;
    private Date endDateForSales;

    private Boolean monthlySubscription;
    private Boolean voluntarySubsription;

    private int tenureInMonths;

    private Boolean forPostpaidPlan;
    private Boolean isExpiring;

    private Rules rules;

    private enum productStatus {ACTIVE, INACTIVE, PRE_LAUNCH}

    public Product addDevice(Device device) {
        this.devices.add(device);
        return this;
    }
}
