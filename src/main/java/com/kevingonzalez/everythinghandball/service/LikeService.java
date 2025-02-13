package com.kevingonzalez.everythinghandball.service;

import com.kevingonzalez.everythinghandball.model.Like;
import com.kevingonzalez.everythinghandball.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    private final LikeRepository likeRepository;

    @Autowired
    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    // Create a new like
    public Like createLike(Like like) {
        return likeRepository.save(like);
    }

    // Retrieve a like by ID
    public Optional<Like> getLikeById(Long id) {
        return likeRepository.findById(id);
    }

    // Retrieve all likes
    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }

    // Update a like (if necessary)
    public Like updateLike(Long id, Like updatedLike) {
        Optional<Like> optionalLike = likeRepository.findById(id);
        if (optionalLike.isPresent()) {
            Like like = optionalLike.get();
            like.setUserId(updatedLike.getUserId());
            like.setTargetType(updatedLike.getTargetType());
            like.setTargetId(updatedLike.getTargetId());
            return likeRepository.save(like);
        } else {
            throw new RuntimeException("Like not found with id " + id);
        }
    }

    // Delete a like by ID
    public void deleteLike(Long id) {
        likeRepository.deleteById(id);
    }
}
