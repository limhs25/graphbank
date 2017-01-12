package com.bindstone.graphbank.rest;

import com.bindstone.graphbank.domain.Country;
import com.bindstone.graphbank.provider.CountryProvider;
import com.bindstone.graphbank.service.CountryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@Transactional
public class CountyRestTest extends AbstractRestTest {

    @Autowired
    private CountryService countryService;

    @Test
    public void getCountry() throws Exception {
        mvc.perform(get("/country"))
                .andReturn();

    }


    @Test
    public void createCountry() throws Exception {
        Country country = CountryProvider.LUXEMBOURG();

        MvcResult mvcResult = mvc
                .perform(post("/country")
                        .content(""))
                .andReturn();
        mvcResult.getResponse().getContentAsString();
    }


}
