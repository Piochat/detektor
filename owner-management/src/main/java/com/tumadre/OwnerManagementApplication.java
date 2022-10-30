package com.tumadre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OwnerManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(OwnerManagementApplication.class, args);
    }
}