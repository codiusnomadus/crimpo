package com.amtrust.crmz.productapi.product.models;

import com.amtrust.crmz.productapi.common.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Document(collection = "products")
@Data
@Log4j2
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel {
    private String name;

    private String productCode;
    private String description;
    private String terms;

    private int productStatus;

    private Client client;
    private Insurer insurer;

    private Set<Device> devices = new HashSet<>(); // should be an array

    private String clientProductName;
    private String clientProductDescription;
    private Date startDateForSales;
    private Date endDateForSales;

    private Boolean monthlySubscription;
    private Boolean voluntarySubsription;

    private int tenureInMonths;

    private Boolean isOnPostpaidTelcoPlan;
    private Boolean isExpiring;

    private Rules rules;

    private enum productStatus {ACTIVE, INACTIVE, PRE_LAUNCH}

    public String getProductCode() {
        return productCode;
    }

    public Product addDevice(Device device) {
        device.setProduct(this);
        this.devices.add(device);
        return this;
    }
}
