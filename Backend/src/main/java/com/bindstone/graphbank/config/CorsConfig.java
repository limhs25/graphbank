package com.bindstone.graphbank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.logging.Logger;

@Configuration
public class CorsConfig {
    static Logger log = Logger.getLogger(CorsConfig.class.getName());

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                log.info("Enable CORS with pattern: '/**'");
                registry.addMapping("/**");
                //.allowedMethods("POST, GET, OPTIONS, DELETE")
                //.allowedOrigins("**")
                //.allowedHeaders("Content-Type, Accept, X-Requested-With, remember-me");
            }
        };
    }
}
