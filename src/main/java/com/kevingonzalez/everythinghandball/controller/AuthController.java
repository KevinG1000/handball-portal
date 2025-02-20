package com.kevingonzalez.everythinghandball.controller;

import com.kevingonzalez.everythinghandball.dto.SignUpRequest;
import com.kevingonzalez.everythinghandball.model.User;
import com.kevingonzalez.everythinghandball.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Sign-Up Endpoint: prevents duplicate usernames
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        try {
            // Check if username exists
            if (userService.findByUsername(signUpRequest.getUsername()) != null) {
                return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Username already exists");
            }

            // Create new user
            User user = new User();
            user.setUsername(signUpRequest.getUsername());
            user.setEmail(signUpRequest.getEmail());
            user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

            User createdUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error creating user: " + e.getMessage());
        }
    }

    // Login Endpoint: validates credentials and returns a message
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            User user = userService.findByUsername(loginRequest.getUsername());
            
            // Add debug logging
            System.out.println("Login attempt for username: " + loginRequest.getUsername());
            System.out.println("User found: " + (user != null));
            
            if (user != null) {
                boolean passwordMatches = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
                System.out.println("Password matches: " + passwordMatches);
                
                if (passwordMatches) {
                    // Remove password from response
                    user.setPassword(null);
                    return ResponseEntity.ok(user);
                }
            }
            
            return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Invalid username or password");
                
        } catch (Exception e) {
            System.out.println("Login error: " + e.getMessage());
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error during login: " + e.getMessage());
        }
    }
}

// DTO for login requests
class LoginRequest {
    private String username;
    private String password;

    // Getters and Setters
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
