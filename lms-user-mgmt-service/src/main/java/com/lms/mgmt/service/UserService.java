package com.lms.mgmt.service;



import com.lms.mgmt.dto.UserDTO;
import com.lms.mgmt.entity.User;
import com.lms.mgmt.mapper.UserModelMapper;
import com.lms.mgmt.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final UserModelMapper modelMapper;

    public UserService(UserRepository userRepository, UserModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<UserDTO> getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            UserDTO userDTO = modelMapper.map(user.get(), UserDTO.class);
            return Optional.of(userDTO);
        }
        return Optional.empty();
    }

    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDto = modelMapper.map(users, List.class);
        return userDto;
    }

    public UserDTO saveUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user = userRepository.save(user);
        userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    public void deleteUser(Integer id) {
        User user = new User();
        user.setId(id);
        userRepository.delete(user);
    }

}
