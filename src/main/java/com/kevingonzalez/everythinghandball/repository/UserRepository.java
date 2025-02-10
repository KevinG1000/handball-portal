package com.kevingonzalez.everythinghandball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kevingonzalez.everythinghandball.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Optionally, add custom query methods
    User findByUsername(String username);
}
