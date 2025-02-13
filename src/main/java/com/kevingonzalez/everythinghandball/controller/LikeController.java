package com.kevingonzalez.everythinghandball.controller;

import com.kevingonzalez.everythinghandball.model.Like;
import com.kevingonzalez.everythinghandball.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    // Create a new like
    @PostMapping
    public Like createLike(@RequestBody Like like) {
        return likeService.createLike(like);
    }

    // Retrieve a like by ID
    @GetMapping("/{id}")
    public Optional<Like> getLikeById(@PathVariable Long id) {
        return likeService.getLikeById(id);
    }

    // Retrieve all likes
    @GetMapping
    public List<Like> getAllLikes() {
        return likeService.getAllLikes();
    }

    // Update a like
    @PutMapping("/{id}")
    public Like updateLike(@PathVariable Long id, @RequestBody Like like) {
        return likeService.updateLike(id, like);
    }

    // Delete a like by ID
    @DeleteMapping("/{id}")
    public void deleteLike(@PathVariable Long id) {
        likeService.deleteLike(id);
    }
}
