package com.kevingonzalez.everythinghandball.controller;

import com.kevingonzalez.everythinghandball.model.Court;
import com.kevingonzalez.everythinghandball.service.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courts")
public class CourtController {

    private final CourtService courtService;

    @Autowired
    public CourtController(CourtService courtService) {
        this.courtService = courtService;
    }

    // Create a new court
    @PostMapping
    public Court createCourt(@RequestBody Court court) {
        return courtService.createCourt(court);
    }

    // Retrieve a court by ID
    @GetMapping("/{id}")
    public Optional<Court> getCourtById(@PathVariable Long id) {
        return courtService.getCourtById(id);
    }

    // Retrieve all courts
    @GetMapping
    public List<Court> getAllCourts() {
        return courtService.getAllCourts();
    }

    // Update an existing court
    @PutMapping("/{id}")
    public Court updateCourt(@PathVariable Long id, @RequestBody Court court) {
        return courtService.updateCourt(id, court);
    }

    // Delete a court by ID
    @DeleteMapping("/{id}")
    public void deleteCourt(@PathVariable Long id) {
        courtService.deleteCourt(id);
    }
}
