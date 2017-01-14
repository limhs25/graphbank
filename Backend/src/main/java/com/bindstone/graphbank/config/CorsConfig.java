package com.bindstone.graphbank.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CorsConfig {
    static final Logger log = LoggerFactory.getLogger(CorsConfig.class);

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
