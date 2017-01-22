package com.bindstone.graphbank;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@Configuration
@MapperScan(basePackages = "com.bindstone.graphbank.repository")
public class GraphbankApplication {
    static Logger log = LoggerFactory.getLogger(GraphbankApplication.class);

    public GraphbankApplication() {
        super();
    }

    public static void main(String[] args) {
        SpringApplication.run(GraphbankApplication.class, args);
    }
}
