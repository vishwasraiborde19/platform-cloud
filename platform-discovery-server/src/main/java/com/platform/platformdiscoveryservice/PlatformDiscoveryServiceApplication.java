package com.platform.platformdiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PlatformDiscoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformDiscoveryServiceApplication.class, args);
    }

}
