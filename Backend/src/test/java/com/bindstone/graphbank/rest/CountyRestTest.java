package com.bindstone.graphbank.rest;

import com.bindstone.graphbank.domain.Country;
import com.bindstone.graphbank.provider.CountryProvider;
import com.bindstone.graphbank.service.CountryService;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


@Transactional
public class CountyRestTest extends AbstractRestTest {
    private static final String ROOT = "/country/";
    @Autowired
    protected WebApplicationContext wac;
    @Autowired
    private CountryService countryService;

    @Before
    public void setup() {
        System.out.println("Test execution port:" + port);
        RestAssured.port = port;
        RestAssuredMockMvc.webAppContextSetup(wac);

    }

    @Test
    public void getCountry() throws Exception {
        countryService.save(CountryProvider.ICELAND());
        countryService.save(CountryProvider.LUXEMBOURG());
        RestAssuredMockMvc
                .get(ROOT)
                .then().statusCode(200);
    }

    @Test
    public void getByIdCountry() throws Exception {
        Country save = countryService.save(CountryProvider.LUXEMBOURG());
        RestAssuredMockMvc
                .get(ROOT + save.getId())
                .then().statusCode(200);
    }

    @Test
    public void createCountry() throws Exception {
        Country country = CountryProvider.LUXEMBOURG();
        RestAssuredMockMvc
                .given().contentType(ContentType.JSON).body(country)
                .when()
                .put(ROOT)
                .then().statusCode(200);
    }

    @Test
    public void updateCountry() throws Exception {
        Country country = CountryProvider.LUXEMBOURG();
        countryService.save(country);
        RestAssuredMockMvc
                .given().contentType(ContentType.JSON).body(country)
                .when()
                .post(ROOT)
                .then().statusCode(200);
    }

    @Test
    public void deleteCountry() throws Exception {
        Country save = countryService.save(CountryProvider.ICELAND());
        RestAssuredMockMvc
                .delete(ROOT + save.getId())
                .then().statusCode(200);
    }

}
