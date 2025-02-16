package com.kevingonzalez.everythinghandball.service;

import com.kevingonzalez.everythinghandball.model.User;
import com.kevingonzalez.everythinghandball.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Retrieve a user by id
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Retrieve all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Update an existing user
    public User updateUser(Long id, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }

    // Delete a user by id
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Retrieve a user by username (for login)
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
