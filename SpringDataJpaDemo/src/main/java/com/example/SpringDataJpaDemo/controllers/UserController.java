package com.example.SpringDataJpaDemo.controllers;

import com.example.SpringDataJpaDemo.dto.CreateUserDto;
import com.example.SpringDataJpaDemo.dto.UserDto;
import com.example.SpringDataJpaDemo.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    UserService userService;

    public UserController() {
        this.userService = userService;
    }

//    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto user) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
//    }


}
