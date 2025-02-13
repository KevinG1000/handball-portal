package com.kevingonzalez.everythinghandball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kevingonzalez.everythinghandball.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Additional custom queries can be added here if needed.
}
