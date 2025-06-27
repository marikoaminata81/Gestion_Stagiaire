package com.stagiaires.stagiaire.repository;

import com.stagiaires.stagiaire.entity.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {
    Optional<Stagiaire> findByEmail(String email);
    List<Stagiaire> findByEncadreurId(Long encadreurId);
}
