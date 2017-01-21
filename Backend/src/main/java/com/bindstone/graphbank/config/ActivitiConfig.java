package com.bindstone.graphbank.config;

import org.activiti.spring.SpringAsyncExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class ActivitiConfig extends AbstractProcessEngineAutoConfiguration {

    @Value("${graphbank.activiti.datasource.url}")
    private String url;

    @Value("${graphbank.activiti.datasource.driverClassName}")
    private String driver;

    @Value("${graphbank.activiti.datasource.username}")
    private String user;

    @Value("${graphbank.activiti.datasource.password}")
    private String password;


    @Autowired
    @ConfigurationProperties(prefix = "datasource.activiti")
    public DataSource activitiDataSource() {
        return DataSourceBuilder
                .create()
                .url(url)
                .username(user)
                .password(password)
                .driverClassName(driver)
                .build();
    }

    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(
            PlatformTransactionManager transactionManager,
            SpringAsyncExecutor springAsyncExecutor) throws IOException {

        return baseSpringProcessEngineConfiguration(
                activitiDataSource(),
                transactionManager,
                springAsyncExecutor);
    }
}