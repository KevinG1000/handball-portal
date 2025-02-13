package com.kevingonzalez.everythinghandball.service;

import com.kevingonzalez.everythinghandball.model.Court;
import com.kevingonzalez.everythinghandball.repository.CourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourtService {

    private final CourtRepository courtRepository;

    @Autowired
    public CourtService(CourtRepository courtRepository) {
        this.courtRepository = courtRepository;
    }

    // Create a new court
    public Court createCourt(Court court) {
        return courtRepository.save(court);
    }

    // Retrieve a court by ID
    public Optional<Court> getCourtById(Long id) {
        return courtRepository.findById(id);
    }

    // Retrieve all courts
    public List<Court> getAllCourts() {
        return courtRepository.findAll();
    }

    // Update an existing court
    public Court updateCourt(Long id, Court updatedCourt) {
        Optional<Court> optionalCourt = courtRepository.findById(id);
        if (optionalCourt.isPresent()) {
            Court court = optionalCourt.get();
            court.setName(updatedCourt.getName());
            court.setBorough(updatedCourt.getBorough());
            court.setImageUrl(updatedCourt.getImageUrl());
            // Update any additional fields as needed
            return courtRepository.save(court);
        } else {
            throw new RuntimeException("Court not found with id " + id);
        }
    }

    // Delete a court by ID
    public void deleteCourt(Long id) {
        courtRepository.deleteById(id);
    }
}
