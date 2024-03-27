package com.jesus.truck.inspect.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 数据源配置
 */
@Configuration
public class AutRefluxDataSourceConfig {
    @Bean(name = "avatarDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}
