package com.bindstone.graphbank;

import com.bindstone.graphbank.service.CountryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GraphbankApplicationTests {

    @Autowired
    private CountryService countryService;

    @Test
    public void contextLoads() {
        Assert.assertNotNull("Country service is null", countryService);
    }

}
