package com.example.springbootcrudexample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootcrudexample.model.entity.User;

public interface UserInfoRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String username);
}
