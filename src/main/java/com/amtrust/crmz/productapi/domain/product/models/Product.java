package com.amtrust.crmz.productapi.domain.product.models;

import com.amtrust.crmz.productapi.common.BaseModel;
import com.amtrust.crmz.productapi.common.models.validations.ApiValidationError;
import com.amtrust.crmz.productapi.domain.client.models.Client;
import com.amtrust.crmz.productapi.domain.device.models.Device;
import com.amtrust.crmz.productapi.domain.insurer.models.Insurer;
import com.amtrust.crmz.productapi.exceptions.InvalidProductException;
import com.amtrust.crmz.productapi.exceptions.ProductExceptionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;


@Document(collection = "products")
@Log4j2
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product extends BaseModel {

    @NotNull
    @Size(min=2)
    private String name;

    @NotNull
    @Size(min=2)
    private String productCode;

    @NotNull
    @Size(min=2)
    private String description;

    private String terms;

    private ProductStatus productStatus;

    @NotNull
    private Client client;

    @NotNull
    private Insurer insurer;

    private Set<Device> devices = new HashSet<>();

    @NotNull
    private String clientProductName;

    @NotNull
    private String clientProductDescription;

    @NotNull
    private Date startDateForSales;

    @NotNull
    private Date endDateForSales;

    @NotNull
    private SubscriptionType subscriptionType;

    @NotNull
    private Boolean voluntarySubsription;

    @NotNull
    private int tenureInMonths;

    @NotNull
    private Boolean forPostpaidPlan;

    @NotNull
    private Boolean isExpiring;

    private Rules rules;

    public Product addDevice(Device device) {
        this.devices.add(device);
        return this;
    }

    public static List<ApiValidationError> validationErrors = new ArrayList<>();

    public static boolean validate(Product product) throws InvalidProductException {

        if (product == null) {
            log.warn("Attempted to validate null product object.");
            throw new InvalidProductException(ProductExceptionType.PRODUCT_DOESNT_EXIST.getMessage());
        } else {
            product.validatePresenceOfName();
        }

        if (!CollectionUtils.isEmpty(validationErrors)) {
            throw new InvalidProductException(validationErrors);
        } else {
            return true;
        }
    }

    private void validatePresenceOfName() {
        if (StringUtils.isEmpty(this.getName())) {
            validationErrors.add(new ApiValidationError("Name", ProductExceptionType.NAME_MISSING.getMessage()));
        } else if (this.getName().trim().length() < MIN_NAME_LENGTH) {
            log.debug("Invalid name length [value: {}, length: {}, min_length: {}", this.getName(), this.getName().length(), MIN_NAME_LENGTH);
        }
    }
}
