package com.bindstone.graphbank.rest;

import com.bindstone.graphbank.domain.Currency;
import com.bindstone.graphbank.provider.CurrencyProvider;
import com.bindstone.graphbank.service.CurrencyService;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


@Transactional
public class CurrencyRestTest extends AbstractRestTest {
    private static final String ROOT = "/currency/";
    @Autowired
    protected WebApplicationContext wac;
    @Autowired
    private CurrencyService currencyService;

    @Before
    public void tearDown() {
        System.out.println("Test execution port:" + port);
        RestAssured.port = port;
        RestAssuredMockMvc.webAppContextSetup(wac);
    }

    @Test
    public void getCurrency() throws Exception {
        Assert.assertNotNull("Service validation", currencyService);
        currencyService.save(CurrencyProvider.EURO());
        currencyService.save(CurrencyProvider.DOLLAR());
        RestAssuredMockMvc
                .get(ROOT)
                .then().statusCode(200);
    }

    @Test
    public void getByIdCurrency() throws Exception {
        Assert.assertNotNull("Service validation", currencyService);
        Currency save = currencyService.save(CurrencyProvider.EURO());
        RestAssuredMockMvc
                .get(ROOT + save.getId())
                .then().statusCode(200);
    }

    @Test
    public void createCurrency() throws Exception {
        Assert.assertNotNull("Service validation", currencyService);
        Currency currency = CurrencyProvider.EURO();
        RestAssuredMockMvc
                .given().contentType(ContentType.JSON).body(currency)
                .when()
                .put(ROOT)
                .then().statusCode(200);
    }

    @Test
    public void updateCurrency() throws Exception {
        Assert.assertNotNull("Service validation", currencyService);
        Currency currency = CurrencyProvider.EURO();
        currencyService.save(currency);
        RestAssuredMockMvc
                .given().contentType(ContentType.JSON).body(currency)
                .when()
                .post(ROOT)
                .then().statusCode(200);
    }

    @Test
    public void deleteCurrency() throws Exception {
        Assert.assertNotNull("Service validation", currencyService);
        Currency save = currencyService.save(CurrencyProvider.DOLLAR());
        RestAssuredMockMvc
                .delete(ROOT + save.getId())
                .then().statusCode(200);
    }

}
