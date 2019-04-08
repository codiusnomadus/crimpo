package com.amtrust.crmz.productapi.exceptions;

import com.amtrust.crmz.productapi.common.models.validations.ApiValidationError;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class InvalidProductException extends Exception{
    List<ApiValidationError> validationErrors = new ArrayList<>();

    public InvalidProductException(String message) {
        super(message);
    }

    public InvalidProductException(ProductExceptionType productExceptionType) {
        super(productExceptionType.getMessage());
    }

    public InvalidProductException(List<ApiValidationError> validationErrors) {
        super("Invalid product");
        this.validationErrors = validationErrors;
    }

    public InvalidProductException(ProductExceptionType productExceptionType, List<ApiValidationError> validationErrors) {
        super(productExceptionType.getMessage());
        this.validationErrors = validationErrors;
    }

}
