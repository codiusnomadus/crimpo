package com.amtrust.crmz.productapi.advicer;

import com.amtrust.crmz.productapi.common.models.validations.ApiError;
import com.amtrust.crmz.productapi.exceptions.InvalidProductException;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Log4j2
public class ProductExceptionHandler {
    @ExceptionHandler(InvalidProductException.class)
    protected ResponseEntity<Object> handleInvalidProduct(InvalidProductException ex) {
        log.warn("Received invalid product data [Validation errors: {}]",
                ex.getValidationErrors().stream().map(apiValidationError ->
                        apiValidationError.getField() + "-" + apiValidationError.getMessage())
                        .collect(Collectors.toList()));

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);

        if (!CollectionUtils.isEmpty(ex.getValidationErrors())) {
            apiError.setValidationErrors(ex.getValidationErrors());
        }
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}