package com.gestion.stagiaire.repository;

import com.gestion.stagiaire.entity.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {
    // Spring Data JPA génère automatiquement les méthodes CRUD
}
