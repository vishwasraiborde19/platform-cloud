package com.lms.mgmt.service;


import com.lms.mgmt.base.BaseIntegrationTest;
import com.lms.mgmt.base.DataHelper;
import com.lms.mgmt.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class UserServiceTest extends BaseIntegrationTest {

    @Autowired
    UserService userService;

    @Test
    void getUserById() {
    }

    @Test
    void getUsers() {
        List<UserDTO> users = DataHelper.getUsers();
        for (UserDTO userDTO : users) {
            userDTO = userService.saveUser(userDTO);
            log.info("user data is persisted [{}]", userDTO.toString());
        }
        List<UserDTO> usersRetrieved = userService.getUsers();
        assertTrue(usersRetrieved.size() >= 10);
    }

    @Test
    void saveUser() {
        List<UserDTO> users = DataHelper.getUsers();
        for (UserDTO userDTO : users) {
            userDTO = userService.saveUser(userDTO);
            log.info("user data is persisted [{}]", userDTO.toString());
        }
        assertNotNull(userService.getUserById(5));
    }

    @Test
    void deleteUser() {
        List<UserDTO> users = DataHelper.getUsers();
        for (UserDTO userDTO : users) {
            userDTO = userService.saveUser(userDTO);
            log.info("user data is persisted [{}]", userDTO.toString());
        }
        userService.deleteUser(5);
        Optional<UserDTO> userDTO = userService.getUserById(5);
        assertEquals(userDTO.isPresent(), Boolean.FALSE);
    }

}