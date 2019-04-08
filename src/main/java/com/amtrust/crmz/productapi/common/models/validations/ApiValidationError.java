package com.amtrust.crmz.productapi.common.models.validations;

import lombok.Data;

@Data
public class ApiValidationError {
    private String field;
    private Object rejectedValue;
    private String message;

    public ApiValidationError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public ApiValidationError(String field, String rejectedValue, String message) {
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.message = message;
    }
}