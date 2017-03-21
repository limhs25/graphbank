package com.bindstone.graphbank.rest;

import com.bindstone.graphbank.GraphbankApplication;
import com.bindstone.graphbank.config.initializer.ServletInitializer;
import com.bindstone.graphbank.service.DatabaseService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {GraphbankApplication.class, ServletInitializer.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public abstract class AbstractRestTest {

    @Value("${local.server.port}")
    protected int port;

    @Autowired
    private DatabaseService databaseService;

    @Before
    public void clearDB() {
        databaseService.clear();
    }

}
