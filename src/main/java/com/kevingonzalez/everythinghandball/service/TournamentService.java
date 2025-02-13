package com.kevingonzalez.everythinghandball.service;

import com.kevingonzalez.everythinghandball.model.Tournament;
import com.kevingonzalez.everythinghandball.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    // Create a new tournament
    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    // Retrieve a tournament by ID
    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }

    // Retrieve all tournaments
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    // Update a tournament
    public Tournament updateTournament(Long id, Tournament updatedTournament) {
        Optional<Tournament> optionalTournament = tournamentRepository.findById(id);
        if (optionalTournament.isPresent()) {
            Tournament tournament = optionalTournament.get();
            tournament.setName(updatedTournament.getName());
            tournament.setDate(updatedTournament.getDate());
            tournament.setDescription(updatedTournament.getDescription());
            // Update any additional fields as necessary
            return tournamentRepository.save(tournament);
        } else {
            // Handle the case where the tournament isn't found (e.g., throw an exception)
            throw new RuntimeException("Tournament not found with id " + id);
        }
    }

    // Delete a tournament by ID
    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }
}
