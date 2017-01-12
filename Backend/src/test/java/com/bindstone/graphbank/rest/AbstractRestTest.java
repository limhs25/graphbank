package com.bindstone.graphbank.rest;

import com.bindstone.graphbank.GraphbankApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@SpringApplicationConfiguration(classes = GraphbankApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
public abstract class AbstractRestTest {

    protected MockMvc mvc;

    @Autowired
    protected WebApplicationContext context;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                //.apply(springSecurity())
                .build();
    }
}
