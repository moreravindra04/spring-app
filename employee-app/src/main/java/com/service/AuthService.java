package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String username, String password) {
        // In a real application, you would:
        // 1. Look up the user in the database
        // 2. Hash the provided password and compare with stored hash
        // 3. Return true if matches, false otherwise
        return userRepository.validateCredentials(username, password);
    }
}