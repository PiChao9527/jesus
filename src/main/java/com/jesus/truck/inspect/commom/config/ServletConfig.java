package com.jesus.truck.inspect.commom.config;

import com.jesus.truck.inspect.commom.filter.LogMdcFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class ServletConfig {

    @Autowired
    private LogMdcFilter logMdcFilter;

    @Bean
    public FilterRegistrationBean<Filter> someFilterRegistration() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(logMdcFilter);
        registration.addUrlPatterns("/*");
        registration.setName("requestBodyFilter");
        registration.setOrder(99);
        return registration;
    }
}
