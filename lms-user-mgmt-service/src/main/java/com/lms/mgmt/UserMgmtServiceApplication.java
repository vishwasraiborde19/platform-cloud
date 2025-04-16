package com.lms.mgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserMgmtServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserMgmtServiceApplication.class, args);
    }

}
