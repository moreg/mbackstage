package com.mys.meisiniu;


import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan("com.mys.meisiniu.dao")
@EnableCaching
public class MeisiniuApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeisiniuApplication.class, args);
    }
}
