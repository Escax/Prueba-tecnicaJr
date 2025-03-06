package com.escax.crud.service;

import com.escax.crud.dto.UserDTO;
import com.escax.crud.entity.User;
import com.escax.crud.mapper.UserMapper;
import com.escax.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDTO(user);
    }

    public List<UserDTO> searchUsersForName(String name) {
        List<User> users = userRepository.findByNameContainingIgnoreCase(name);
        return users.stream().map(userMapper::toDTO).toList();
    }

    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail(), "******", Collections.emptyList()))
                .toList();
    }



}
