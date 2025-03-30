package com.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    // Simple in-memory user store with username -> password mapping
    private Map<String, String> users = new HashMap<>();

    public UserRepository() {
        // Pre-populate with some test users
        users.put("admin", "admin123");
        users.put("user", "password");
    }

    public boolean validateCredentials(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
}