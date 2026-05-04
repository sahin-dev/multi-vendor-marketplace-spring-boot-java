package com.bestkid.bestkid_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bestkid.bestkid_api.entity.User;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    
} 