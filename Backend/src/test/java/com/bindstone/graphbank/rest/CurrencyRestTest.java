package com.bindstone.graphbank.rest;

import com.bindstone.graphbank.domain.Currency;
import com.bindstone.graphbank.provider.CurrencyProvider;
import com.bindstone.graphbank.service.CurrencyService;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.jayway.restassured.module.mockmvc.response.MockMvcResponse;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


@Transactional
public class CurrencyRestTest extends AbstractRestTest {
    @Autowired
    protected WebApplicationContext wac;
    //TOOO Fix Test error in allocating POrt ?!?
    @Autowired
    private CurrencyService currencyService;

    @Before
    public void setup() {
        System.out.println("Test execution port:" + port);
        RestAssured.port = port;
        RestAssuredMockMvc.webAppContextSetup(wac);
        //RestAssuredMockMvc.standaloneSetup(CurrencyController.class);

    }

    @Test
    public void getCurrency() throws Exception {
        currencyService.save(CurrencyProvider.EURO());
        currencyService.save(CurrencyProvider.DOLLAR());
        MockMvcResponse mockMvcResponse = RestAssuredMockMvc.get("/currency");
        RestAssuredMockMvc.get("/currency");
    }

    @Test
    public void getByIdCurrency() throws Exception {
        Currency save = currencyService.save(CurrencyProvider.EURO());
        MockMvcResponse mockMvcResponse = RestAssuredMockMvc.get("/currency/" + save.getId());
        RestAssuredMockMvc.get("/currency");
    }

    @Test
    public void createCurrency() throws Exception {
        Currency currency = CurrencyProvider.EURO();
        RestAssuredMockMvc
                .given().param("name", "Luxembourg")
                .when()
                .put("/currency");
    }

    @Test
    public void updateCurrency() throws Exception {
        Currency currency = CurrencyProvider.EURO();
        RestAssuredMockMvc
                .given().param("name", "Grand Duchy of Luxembourg")
                .param("id", currency.getId())
                .when()
                .post("/currency");
    }

    @Test
    public void deleteCurrency() throws Exception {
        Currency save = currencyService.save(CurrencyProvider.DOLLAR());
        RestAssuredMockMvc
                .delete("/currency/" + save.getId())
                .then().statusCode(200);
    }

}
