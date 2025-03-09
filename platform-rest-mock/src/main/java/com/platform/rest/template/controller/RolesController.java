package com.platform.rest.template.controller;

import com.platform.rest.template.vo.Role;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class RolesController {

    private final List<Role> ROLES = Arrays.asList(
         new Role("100","admin"),
         new Role("200","guest")
    );



    @GetMapping("/roles")
    public List<Role> getRoles() {
        return ROLES;
    }

    @PostMapping("/roles")
    public List<Role> addRole(@RequestBody Role user) {
        ROLES.add(user);
        return ROLES;
    }

    @GetMapping("/roles/{id}")
    public List<Role> getRole(@PathVariable String id) {
        return ROLES.stream().filter(user -> user.getId().equals(id)).collect(Collectors.toList());
    }


}
