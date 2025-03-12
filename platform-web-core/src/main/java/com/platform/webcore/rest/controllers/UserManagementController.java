package com.platform.webcore.rest.controllers;

import com.platform.common.vo.User;
import com.platform.webcore.rest.service.UserManagementService;
import org.springframework.web.bind.annotation.*;


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
