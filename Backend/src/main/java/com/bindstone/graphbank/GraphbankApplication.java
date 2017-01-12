package com.bindstone.graphbank;

import org.mybatis.spring.annotation.MapperScan;
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

    public static void main(String[] args) {
        SpringApplication.run(GraphbankApplication.class, args);
    }

}
