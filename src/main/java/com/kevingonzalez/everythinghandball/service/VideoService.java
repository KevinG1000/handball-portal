package com.kevingonzalez.everythinghandball.service;

import com.kevingonzalez.everythinghandball.model.Video;
import com.kevingonzalez.everythinghandball.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    // Create a new video
    public Video createVideo(Video video) {
        return videoRepository.save(video);
    }

    // Retrieve a video by ID
    public Optional<Video> getVideoById(Long id) {
        return videoRepository.findById(id);
    }

    // Retrieve all videos
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    // Update an existing video
    public Video updateVideo(Long id, Video updatedVideo) {
        Optional<Video> optionalVideo = videoRepository.findById(id);
        if (optionalVideo.isPresent()) {
            Video video = optionalVideo.get();
            video.setTitle(updatedVideo.getTitle());
            video.setVideoUrl(updatedVideo.getVideoUrl());
            video.setVideoType(updatedVideo.getVideoType());
            return videoRepository.save(video);
        } else {
            throw new RuntimeException("Video not found with id " + id);
        }
    }

    // Delete a video by ID
    public void deleteVideo(Long id) {
        videoRepository.deleteById(id);
    }
}
