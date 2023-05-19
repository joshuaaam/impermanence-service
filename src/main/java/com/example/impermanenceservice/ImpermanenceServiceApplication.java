package com.example.impermanenceservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.example.impermanenceservice.repository")
@SpringBootApplication
public class ImpermanenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImpermanenceServiceApplication.class, args);
    }

}
