package com.kevingonzalez.everythinghandball.service;

import com.kevingonzalez.everythinghandball.model.Comment;
import com.kevingonzalez.everythinghandball.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // Create a new comment
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
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
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            comment.setUserId(updatedComment.getUserId());
            comment.setTargetType(updatedComment.getTargetType());
            comment.setTargetId(updatedComment.getTargetId());
            comment.setContent(updatedComment.getContent());
            // Optionally, update the timestamp if needed:
            // comment.setTimestamp(LocalDateTime.now());
            return commentRepository.save(comment);
        } else {
            throw new RuntimeException("Comment not found with id " + id);
        }
    }

    // Delete a comment by ID
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
