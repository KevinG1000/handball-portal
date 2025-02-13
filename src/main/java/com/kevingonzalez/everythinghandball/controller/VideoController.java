package com.kevingonzalez.everythinghandball.controller;

import com.kevingonzalez.everythinghandball.model.Video;
import com.kevingonzalez.everythinghandball.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    // Create a new video
    @PostMapping
    public Video createVideo(@RequestBody Video video) {
        return videoService.createVideo(video);
    }

    // Retrieve a video by ID
    @GetMapping("/{id}")
    public Optional<Video> getVideoById(@PathVariable Long id) {
        return videoService.getVideoById(id);
    }

    // Retrieve all videos
    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    // Update an existing video
    @PutMapping("/{id}")
    public Video updateVideo(@PathVariable Long id, @RequestBody Video video) {
        return videoService.updateVideo(id, video);
    }

    // Delete a video by ID
    @DeleteMapping("/{id}")
    public void deleteVideo(@PathVariable Long id) {
        videoService.deleteVideo(id);
    }
}
