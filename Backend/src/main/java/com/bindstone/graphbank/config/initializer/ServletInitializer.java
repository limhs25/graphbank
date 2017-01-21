package com.bindstone.graphbank.config.initializer;

import com.bindstone.graphbank.GraphbankApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GraphbankApplication.class);
    }

}
