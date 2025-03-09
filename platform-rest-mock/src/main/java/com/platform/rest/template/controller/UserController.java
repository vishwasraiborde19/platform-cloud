package com.platform.rest.template.controller;

import com.platform.common.vo.User;
import org.springframework.web.bind.annotation.*;

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
    public User getUser(@PathVariable String id) {
        return USERS.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }


}
