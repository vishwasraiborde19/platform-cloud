package com.lms.mgm.controller;


import com.lms.mgm.dto.UserDTO;
import com.lms.mgm.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-mgmt/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return List.of(new UserDTO());
    }

    @GetMapping("/users/{id}")
    public UserDTO getUser(@RequestParam Integer id) {
        return userService.getUserById(id).orElse(new UserDTO());
    }

    @PostMapping("/users")
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @DeleteMapping("/users/{id}")
    public void addUser(@RequestParam Integer id) {
        userService.deleteUser(id);
    }


}
