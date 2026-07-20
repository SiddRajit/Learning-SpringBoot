package com.productAPI.demo_API.service;

import com.productAPI.demo_API.dto.CreateUserDto;
import com.productAPI.demo_API.dto.UserDto;
import com.productAPI.demo_API.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll();
    }

    public UserDto getUserById(String id) {
        return userRepository.findById(id);
    }

    public UserDto createUser(CreateUserDto user) {
        return userRepository.create(user);
    }

    public UserDto updateUser(CreateUserDto user, String id) {
        if (userRepository.findById(id) == null) {
            return null;
        }
        return userRepository.update(user, id);
    }

    public void deleteUser(String id) {
        userRepository.delete(id);
    }
}
