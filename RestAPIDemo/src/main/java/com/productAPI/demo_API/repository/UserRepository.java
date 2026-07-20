package com.productAPI.demo_API.repository;

import com.productAPI.demo_API.dto.CreateUserDto;
import com.productAPI.demo_API.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
public class UserRepository {
    List<UserDto> users = new ArrayList<>();

    public UserRepository() {
        users.add(new UserDto(UUID.randomUUID().toString(), "User 1", "User1@gmail.com"));
        users.add(new UserDto(UUID.randomUUID().toString(), "User 2", "User2@gmail.com"));
        users.add(new UserDto(UUID.randomUUID().toString(), "User 3", "User3@gmail.com"));
    }

    public List<UserDto> findAll() {
        return this.users;
    }

    public UserDto findById(String id) {
        for (UserDto user : users) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        return null;
    }

    public UserDto create(CreateUserDto user) {
        UserDto newUser = new UserDto(UUID.randomUUID().toString(), user.getName(), user.getEmail());
        users.add(newUser);
        return newUser;
    }

    public UserDto update(CreateUserDto user, String id) {
        for (UserDto updatedUser : users) {
            if (Objects.equals(updatedUser.getId(), id)) {
                updatedUser.setEmail(user.getEmail());
                updatedUser.setName(user.getName());
                return updatedUser;
            }
        }

        return null;
    }

    public void delete(String id) {
       users.removeIf(user -> Objects.equals(user.getId(), id));
    }
}
