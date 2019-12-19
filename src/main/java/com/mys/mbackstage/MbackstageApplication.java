package com.mys.mbackstage;


import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan("com.mys.mbackstage.dao")
@EnableCaching
public class MbackstageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MbackstageApplication.class, args);
    }
}
