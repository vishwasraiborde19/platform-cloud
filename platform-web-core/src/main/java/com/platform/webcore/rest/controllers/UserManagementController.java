package com.platform.webcore.rest.controllers;

import com.platform.common.vo.User;
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
    public User createUser(@PathVariable String id) {
        return restTemplate.getForEntity("http://localhost:4000/v1/users/{id}", User.class,id).getBody();
    }

}
