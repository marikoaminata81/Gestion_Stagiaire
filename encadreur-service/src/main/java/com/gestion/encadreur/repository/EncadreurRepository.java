package com.gestion.encadreur.repository;

import com.gestion.encadreur.entity.Encadreur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncadreurRepository extends JpaRepository<Encadreur, Long> {
    // Spring Data JPA génère automatiquement les méthodes CRUD
}
