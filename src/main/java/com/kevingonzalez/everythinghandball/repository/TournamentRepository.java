package com.kevingonzalez.everythinghandball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kevingonzalez.everythinghandball.model.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    // You can add custom query methods here if needed later.
}
