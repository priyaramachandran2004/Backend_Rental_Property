package com.rental.lease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients(basePackages = "com.rental.lease.client")
public class LeaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeaseApplication.class, args);
    }
}