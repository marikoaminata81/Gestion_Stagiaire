package com.gestion.stagiaire.service;

import com.gestion.stagiaire.entity.Stagiaire;
import com.gestion.stagiaire.repository.StagiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StagiaireService {
    
    @Autowired
    private StagiaireRepository stagiaireRepository;
    
    // Récupérer tous les stagiaires
    public List<Stagiaire> getAllStagiaires() {
        return stagiaireRepository.findAll();
    }
    
    // Récupérer un stagiaire par ID
    public Optional<Stagiaire> getStagiaireById(Long id) {
        return stagiaireRepository.findById(id);
    }
    
    // Créer un nouveau stagiaire
    public Stagiaire createStagiaire(Stagiaire stagiaire) {
        return stagiaireRepository.save(stagiaire);
    }
    
    // Mettre à jour un stagiaire
    public Stagiaire updateStagiaire(Long id, Stagiaire stagiaireDetails) {
        Optional<Stagiaire> optionalStagiaire = stagiaireRepository.findById(id);
        if (optionalStagiaire.isPresent()) {
            Stagiaire stagiaire = optionalStagiaire.get();
            stagiaire.setNom(stagiaireDetails.getNom());
            stagiaire.setPrenom(stagiaireDetails.getPrenom());
            stagiaire.setEmail(stagiaireDetails.getEmail());
            stagiaire.setDateDebut(stagiaireDetails.getDateDebut());
            stagiaire.setDateFin(stagiaireDetails.getDateFin());
            stagiaire.setEncadreurId(stagiaireDetails.getEncadreurId());
            return stagiaireRepository.save(stagiaire);
        }
        return null;
    }
    
    // Supprimer un stagiaire
    public boolean deleteStagiaire(Long id) {
        if (stagiaireRepository.existsById(id)) {
            stagiaireRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
