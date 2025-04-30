package com.platform.webcore.rest.controllers;

import com.platform.common.vo.User;
import com.platform.webcore.rest.service.UserManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/management")
public class UserManagementController {

    private final UserManagementService userManagementService;

    public UserManagementController(final UserManagementService userManagementService){
        this.userManagementService = userManagementService;
    }

    @PostMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userManagementService.getAllUsers();
        if(CollectionUtils.isEmpty(users)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        return userManagementService.getUser(id);
    }

}
