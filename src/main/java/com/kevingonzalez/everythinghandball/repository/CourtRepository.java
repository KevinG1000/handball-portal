package com.kevingonzalez.everythinghandball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kevingonzalez.everythinghandball.model.Court;

public interface CourtRepository extends JpaRepository<Court, Long> {
    // You can add custom query methods here if needed later.
}
