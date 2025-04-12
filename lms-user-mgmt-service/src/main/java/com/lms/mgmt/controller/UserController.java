package com.lms.mgmt.controller;


import com.lms.mgmt.dto.UserDTO;
import com.lms.mgmt.exception.UserNotFoundException;
import com.lms.mgmt.exception.UsersNotFoundException;
import com.lms.mgmt.exception.UsersSaveException;
import com.lms.mgmt.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<UserDTO>> getUsers() {
        ResponseEntity<UserDTO> responseEntity;
        try {
            List<UserDTO> users = userService.getUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (UsersNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUser(@RequestParam Integer id) {
        ResponseEntity<UserDTO> responseEntity;
        try {
            UserDTO user = userService.getUserById(id).orElse(new UserDTO());
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        ResponseEntity<UserDTO> responseEntity;
        try {
            UserDTO userSaved = userService.saveUser(userDTO);
            return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
        } catch (UsersSaveException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/users/{id}")
    public void addUser(@RequestParam Integer id) {
        userService.deleteUser(id);
    }


}
