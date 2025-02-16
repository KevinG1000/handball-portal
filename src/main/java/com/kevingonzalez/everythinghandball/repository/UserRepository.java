package com.kevingonzalez.everythinghandball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kevingonzalez.everythinghandball.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query method to find a user by username
    User findByUsername(String username);
}
