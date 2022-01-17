package com.example.userserice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UsersericeApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersericeApplication.class, args);
    }

}
