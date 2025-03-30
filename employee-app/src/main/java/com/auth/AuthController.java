package com.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dto.LoginRequest;
import com.dto.LoginResponse;
import com.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = authService.authenticate(
                loginRequest.getUsername(),
                loginRequest.getPassword());

        if (isAuthenticated) {
            LoginResponse response = new LoginResponse(true, "Login successful", "token123");
            return ResponseEntity.ok(response);
        } else {
            LoginResponse response = new LoginResponse(false, "Invalid username or password", null);
            return ResponseEntity.status(401).body(response);
        }
    }
}