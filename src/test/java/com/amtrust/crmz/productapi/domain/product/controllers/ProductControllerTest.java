package com.amtrust.crmz.productapi.domain.product.controllers;

import com.amtrust.crmz.productapi.domain.product.services.ProductService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ProductService productService;

//    @Test
//    public void index() throws Exception{
//
//        when(productService.getAllProducts()).thenReturn();
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .get("/products/")
//                .accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().json("[{\"_id\":\"5ca33508ce04cb1a71bdc438\",\"deleted\":0,\"createdOn\":\"2019-04-04T07:45:50.517+0000\",\"updatedOn\":null,\"name\":\"Tecprotec ALDD\",\"productCode\":\"DIGI_VN_ADLD\",\"description\":\"This is a description\",\"terms\":null,\"productStatus\":0,\"client\":null,\"insurer\":null,\"devices\":[],\"clientProductName\":null,\"clientProductDescription\":null,\"startDateForSales\":null,\"endDateForSales\":null,\"monthlySubscription\":null,\"voluntarySubsription\":null,\"tenureInMonths\":0,\"isOnPostpaidTelcoPlan\":null,\"isExpiring\":null,\"rules\":null},{\"_id\":\"5ca4648dd9ad254fcba223e9\",\"deleted\":0,\"createdOn\":\"2019-04-03T07:45:17.051+0000\",\"updatedOn\":null,\"name\":\"Tecprotec EW\",\"productCode\":\"DIGI_VN_EW\",\"description\":\"Something\",\"terms\":\"Something\",\"productStatus\":0,\"client\":null,\"insurer\":null,\"devices\":[],\"clientProductName\":\"James\",\"clientProductDescription\":\"Something\",\"startDateForSales\":null,\"endDateForSales\":null,\"monthlySubscription\":null,\"voluntarySubsription\":null,\"tenureInMonths\":0,\"isOnPostpaidTelcoPlan\":null,\"isExpiring\":null,\"rules\":{\"claimLimitValue\":2000,\"claimCountConfig\":\"UPTO_INSURED_SUM\",\"subsequentClaimConfig\":null,\"excessFeeConfig\":null,\"excessFeeRepairVariableValue\":null,\"excessFeeReplacementVariableValue\":null,\"excessFeeTimeLimitInDays\":0,\"logisticsConfig\":0,\"serviceLevelPromiseInDays\":0,\"salvageValue\":null,\"internalSalvageRate\":0.0,\"settlementConfig\":null,\"waitingPeriodForClaimInDays\":0,\"reinsuranceRate\":0.0}}]"))
//                .andReturn();
//
//    }
}