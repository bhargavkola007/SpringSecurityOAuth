package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email); // Update this method to 'existsByEmail'
}
