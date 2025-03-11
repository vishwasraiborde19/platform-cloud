package com.platform.webcore.rest.controllers;

import com.platform.common.vo.User;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/v1/management")
public class UserManagementController {

    private final RestTemplate restTemplate;

    public UserManagementController(final RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return restTemplate.getForEntity("http://localhost:4000/v1/users", User.class).getBody();
    }

    @GetMapping("/users/{id}")
    @Retry(name = "retryService", fallbackMethod = "retryFallBack")
    @CircuitBreaker(name = "circuitBreakerService", fallbackMethod = "circuitBreakerFallBack")
    @TimeLimiter(name = "timeLimiterService")
    @Bulkhead(name="bulkheadService")
    public User createUser(@PathVariable String id) {
        System.out.println("create User");
        return restTemplate.getForEntity("http://localhost:4000/v1/users/{id}", User.class,id).getBody();
    }


    public User retryFallBack(Exception exception) {
        System.out.println("in retryFallBack");
        return new User("retryFallBack","retryFallBack","retryFallBack");
    }

    @ExceptionHandler()
    public User circuitBreakerFallBack(Exception exception) {
        System.out.println("in circuitBreakerFallBack");
        return new User("circuitBreakerFallBack","circuitBreakerFallBack","circuitBreakerFallBack");
    }

}
