package com.example.SpringDataJpaDemo.repositories;

import com.example.SpringDataJpaDemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
