package com.jesus.truck.inspect;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan(value = {"com.jesus.truck.inspect.dao"})
@ServletComponentScan
@EnableCaching
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class JesusApplication {

    public static void main(String[] args) {
        SpringApplication.run(JesusApplication.class, args);
    }

}
