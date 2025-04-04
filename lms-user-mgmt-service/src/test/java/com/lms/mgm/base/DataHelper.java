package com.lms.mgm.base;



import com.lms.mgm.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {

    public static UserDTO getUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("admin");
        userDTO.setPassword("admin");
        userDTO.setEmail("admin@admin.com");
        userDTO.setContact("admin@admin.com");
        return userDTO;
    }

    public static List<UserDTO> getUsers() {
        int id = 1;
        List<UserDTO> userDTOList = new ArrayList<>();
        for(int i= id ; id<=10 ; id ++) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername("admin");
            userDTO.setPassword("admin");
            userDTO.setEmail("admin@admin.com");
            userDTO.setContact("admin@admin.com");
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }
}
