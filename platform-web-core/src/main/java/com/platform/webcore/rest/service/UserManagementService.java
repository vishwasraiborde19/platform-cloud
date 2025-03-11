package com.platform.webcore.rest.service;

import com.platform.common.vo.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Service
public class UserManagementService {

    private final RestTemplate restTemplate;

    public UserManagementService(final RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public User getAllUsers() {
        return restTemplate.getForEntity("http://localhost:4000/v1/users", User.class).getBody();
    }

    @Retry(name = "userService")
    @CircuitBreaker(name = "userService", fallbackMethod = "circuitBreakerFallBack")
    // @Bulkhead(name="userService")
    // @TimeLimiter(name = "userService",fallbackMethod = "timeLimiterFallBack")
    // @RateLimiter(name = "userService")
    // last Retry ( CircuitBreaker ( RateLimiter ( TimeLimiter ( first.Bulkhead ( Function ) ) ) ) )
    public User getUser(String id) {
        System.out.println("create User");
        return restTemplate.getForEntity("http://localhost:4000/v1/users/{id}", User.class,id).getBody();
    }


    public User retryFallBack(Exception exception) {
        System.out.println("in retryFallBack");
        return new User("retryFallBack","retryFallBack","retryFallBack");
    }

    public User circuitBreakerFallBack(Exception exception) {
        System.out.println("in circuitBreakerFallBack");
        return new User("circuitBreakerFallBack","circuitBreakerFallBack","circuitBreakerFallBack");
    }

    public CompletionStage<User> timeLimiterFallBack(Exception exception) {
        System.out.println("in timeLimiterFallBack");
        return  CompletableFuture.completedFuture(new User("timeLimiterFallBack","timeLimiterFallBack","timeLimiterFallBack"));
    }
}
