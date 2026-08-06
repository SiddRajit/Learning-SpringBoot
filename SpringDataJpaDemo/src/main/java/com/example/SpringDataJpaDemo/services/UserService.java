package com.example.SpringDataJpaDemo.services;

import com.example.SpringDataJpaDemo.dto.CreateUserDto;
import com.example.SpringDataJpaDemo.dto.UserDto;
import com.example.SpringDataJpaDemo.entities.User;
import com.example.SpringDataJpaDemo.exception.UserNotFoundException;
import com.example.SpringDataJpaDemo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public UserDto updateUser(Long id, CreateUserDto user) {
        User updatedUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
        updatedUser.setEmail(user.getEmail());
        updatedUser.setName(user.getName());

        return new UserDto(updatedUser.getId(), updatedUser.getName(), updatedUser.getEmail());
    }

    @Transactional
    public UserDto patchUser(Long id, CreateUserDto user) {
        User updatedUser = userRepository.findById(id).orElseThrow();

        if (user.getEmail() != null) {
            updatedUser.setEmail(user.getEmail());
        }
        if (user.getName() != null) {
            updatedUser.setName(user.getName());
        }

        return new UserDto(updatedUser.getId(), updatedUser.getName(), updatedUser.getEmail());
    }

    public List<UserDto> getAllUsersPaginated(int page, int pageSize, String direction, String sortBy) {
        Sort sort;
        sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() :
               Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        Page<User> userPage = userRepository.findAll(pageable);

        List<UserDto> userDtoList = new ArrayList<>();
        userPage.forEach(user -> userDtoList.add(new UserDto(user.getId(), user.getName(), user.getEmail())));

        return userDtoList;
    }
}
