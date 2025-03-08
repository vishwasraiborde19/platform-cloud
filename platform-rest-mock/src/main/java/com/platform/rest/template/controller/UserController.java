package com.platform.rest.template.controller;

import com.platform.rest.template.vo.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class UserController {

    private final List<User> USERS = Arrays.asList(
            new User("1", "vishwas", "email.com"),
            new User("2", "jenny", "jenny.com"),
            new User("3", "sam", "sam.com"),
            new User("4", "sam", "sam.com")
    );


    private final RestTemplate restTemplate;

    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return USERS;
    }

    @PostMapping("/users")
    public List<User> addUser(@RequestBody User user) {
        USERS.add(user);
        return USERS;
    }

    @GetMapping("/users/{id}")
    public List<User> getUser(@PathVariable String id) {
        return USERS.stream().filter(user -> user.getId().equals(id)).collect(Collectors.toList());
    }


}
