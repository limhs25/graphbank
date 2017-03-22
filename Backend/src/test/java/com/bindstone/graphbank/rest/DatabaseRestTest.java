package com.bindstone.graphbank.rest;

import com.bindstone.graphbank.service.DatabaseService;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


@Transactional
public class DatabaseRestTest extends AbstractRestTest {
    private static final String ROOT = "/database/";
    @Autowired
    protected WebApplicationContext wac;
    @Autowired
    private DatabaseService databaseService;

    @Before
    public void tearDown() {
        System.out.println("Test execution port:" + port);
        RestAssured.port = port;
        RestAssuredMockMvc.webAppContextSetup(wac);
    }


    @Test
    public void clear() throws Exception {
        Assert.assertNotNull("Service validation", databaseService);
        RestAssuredMockMvc
                .delete(ROOT + "action/clear")
                .then().statusCode(200);
    }
}
