package com.example.SpringDataJpaDemo.services;

import com.example.SpringDataJpaDemo.dto.CreateUserDto;
import com.example.SpringDataJpaDemo.dto.UserDto;
import com.example.SpringDataJpaDemo.entities.User;
import com.example.SpringDataJpaDemo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto createUser(CreateUserDto user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());

        User saveUser = userRepository.save(newUser);

        return new UserDto(saveUser.getId(), saveUser.getName(), saveUser.getEmail());
    }

    public List<UserDto> getAllUsers() {
        List<User> users = new ArrayList<>();
        users = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for (User user: users) {
            UserDto userDto= new UserDto(user.getId(), user.getName(), user.getEmail());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

//    public UserDto patchUser(Long id, CreateUserDto user) {
//    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

//    public UserDto updateUser(Long id, CreateUserDto user) {
//    }
}
