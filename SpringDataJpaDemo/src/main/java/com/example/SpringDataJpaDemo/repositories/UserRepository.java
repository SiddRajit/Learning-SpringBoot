package com.example.SpringDataJpaDemo.repositories;

import com.example.SpringDataJpaDemo.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findAllBy(Pageable pageable);
}
