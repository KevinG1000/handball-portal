package com.kevingonzalez.everythinghandball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kevingonzalez.everythinghandball.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
    // Additional custom query methods can be added here if needed later.
}
