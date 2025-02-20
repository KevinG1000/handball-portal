package com.kevingonzalez.everythinghandball.service;

import com.kevingonzalez.everythinghandball.model.Comment;
import com.kevingonzalez.everythinghandball.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // Create a new comment
    public Comment createComment(Comment comment) {
        comment.setTimestamp(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    // Get comments for a specific tournament
    public List<Comment> getCommentsByTournamentId(Long tournamentId) {
        return commentRepository.findByTournamentIdOrderByTimestampDesc(tournamentId);
    }

    // Retrieve a comment by ID
    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    // Retrieve all comments
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    // Update an existing comment
    public Comment updateComment(Long id, Comment updatedComment) {
        return commentRepository.findById(id)
            .map(comment -> {
                comment.setContent(updatedComment.getContent());
                comment.setTournamentId(updatedComment.getTournamentId());
                return commentRepository.save(comment);
            })
            .orElseThrow(() -> new RuntimeException("Comment not found with id " + id));
    }

    // Delete a comment by ID
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
