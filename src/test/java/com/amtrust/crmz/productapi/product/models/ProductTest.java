package com.amtrust.crmz.productapi.product.models;

import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.Null;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {
    Product product;

    @Before
    public void setUp() {
//        set_product();

    }

    @Test
    public void productHasProductCode() throws Exception {
        product.setProductCode(null);
//        assert
        //roduct.setProductCode(productCode);
        //assertThat(product.getProductCode()).isBlank();
    }

//    private void set_product() {
//        product = new Product();
//
//        product.setName();
//        product.setProductCode();
//        product.setDescription();
//        product.setTerms();
//        product.setProductStatus();
//        product.setClient();
//        product.setInsurer();
//        product.setClientProductName();
//        product.setClientProductDescription();
//        product.setStartDateForSales();
//        product.setEndDateForSales();
//        product.setMonthlySubscription();
//        product.setVoluntarySubsription();
//        product.setTenureInMonths();
//        product.setForPostpaidPlan();
//        product.setIsExpiring();
//    }
}
