package com.platform.webcore.rest.controllers;

import com.platform.common.vo.User;
import com.platform.webcore.rest.service.UserManagementService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


@RestController
@RequestMapping("/v1/management")
public class UserManagementController {

    private final UserManagementService userManagementService;

    public UserManagementController(final UserManagementService userManagementService){
        this.userManagementService = userManagementService;
    }

    @PostMapping("/users")
    public User getAllUsers() {
        return userManagementService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        return userManagementService.getUser(id);
    }

}
