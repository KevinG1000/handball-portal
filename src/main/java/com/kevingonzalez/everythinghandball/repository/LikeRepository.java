package com.kevingonzalez.everythinghandball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kevingonzalez.everythinghandball.model.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {
    // Custom query methods can be added here later if needed.
}
