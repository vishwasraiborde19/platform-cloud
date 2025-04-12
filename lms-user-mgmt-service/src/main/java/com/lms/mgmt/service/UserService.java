package com.lms.mgmt.service;


import com.lms.mgmt.dto.UserDTO;
import com.lms.mgmt.entity.User;
import com.lms.mgmt.exception.UserNotFoundException;
import com.lms.mgmt.exception.UsersDeleteException;
import com.lms.mgmt.exception.UsersNotFoundException;
import com.lms.mgmt.exception.UsersSaveException;
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

    public Optional<UserDTO> getUserById(Integer id) throws UserNotFoundException {
        try {
            Optional<User> user = userRepository.findById(id);
            if (user.isPresent()) {
                UserDTO userDTO = modelMapper.map(user.get(), UserDTO.class);
                return Optional.of(userDTO);
            }
            return Optional.empty();
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            throw new UsersNotFoundException(e);
        }
    }

    public List<UserDTO> getUsers() throws UsersNotFoundException {
        try {
            List<User> users = userRepository.findAll();
            return modelMapper.map(users, List.class);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            throw new UsersNotFoundException(e);
        }
    }

    public UserDTO saveUser(UserDTO userDTO) throws UsersSaveException {
        try {
            User user = modelMapper.map(userDTO, User.class);
            user = userRepository.save(user);
            return modelMapper.map(user, UserDTO.class);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            throw new UsersSaveException(e);
        }
    }

    public void deleteUser(Integer id) throws UsersDeleteException {
        try {
            User user = new User();
            user.setId(id);
            userRepository.delete(user);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            throw new UsersDeleteException(e);
        }
    }

}
