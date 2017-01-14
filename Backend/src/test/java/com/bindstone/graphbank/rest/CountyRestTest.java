package com.bindstone.graphbank.rest;

import com.bindstone.graphbank.domain.Country;
import com.bindstone.graphbank.provider.CountryProvider;
import com.bindstone.graphbank.service.CountryService;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.jayway.restassured.module.mockmvc.response.MockMvcResponse;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


@Transactional
public class CountyRestTest extends AbstractRestTest {
    @Autowired
    protected WebApplicationContext wac;
    //TOOO Fix Test error in allocating POrt ?!?
    @Autowired
    private CountryService countryService;

    @Before
    public void setup() {
        System.out.println("Test execution port:" + port);
        RestAssured.port = port;
        RestAssuredMockMvc.webAppContextSetup(wac);
        //RestAssuredMockMvc.standaloneSetup(CountryController.class);

    }

    @Test
    public void getCountry() throws Exception {
        countryService.save(CountryProvider.ICELAND());
        countryService.save(CountryProvider.LUXEMBOURG());
        MockMvcResponse mockMvcResponse = RestAssuredMockMvc.get("/country");
        RestAssuredMockMvc.get("/country");
    }

    @Test
    public void getByIdCountry() throws Exception {
        Country save = countryService.save(CountryProvider.LUXEMBOURG());
        MockMvcResponse mockMvcResponse = RestAssuredMockMvc.get("/country/" + save.getId());
        RestAssuredMockMvc.get("/country");
    }

    @Test
    public void createCountry() throws Exception {
        Country country = CountryProvider.LUXEMBOURG();
        RestAssuredMockMvc
                .given().param("name", "Luxembourg")
                .when()
                .put("/country");
    }

    @Test
    public void updateCountry() throws Exception {
        Country country = CountryProvider.LUXEMBOURG();
        RestAssuredMockMvc
                .given().param("name", "Grand Duchy of Luxembourg")
                .param("id", country.getId())
                .when()
                .post("/country");
    }

    @Test
    public void deleteCountry() throws Exception {
        Country save = countryService.save(CountryProvider.ICELAND());
        RestAssuredMockMvc
                .delete("/country/" + save.getId())
                .then().statusCode(200);
    }

}
