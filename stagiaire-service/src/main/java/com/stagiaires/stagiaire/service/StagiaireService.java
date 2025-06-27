package com.stagiaires.stagiaire.service;

import com.stagiaires.stagiaire.entity.Stagiaire;
import com.stagiaires.stagiaire.repository.StagiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StagiaireService {
    
    @Autowired
    private StagiaireRepository stagiaireRepository;
    
    public List<Stagiaire> getAllStagiaires() {
        return stagiaireRepository.findAll();
    }
    
    public Optional<Stagiaire> getStagiaireById(Long id) {
        return stagiaireRepository.findById(id);
    }
    
    public Stagiaire createStagiaire(Stagiaire stagiaire) {
        return stagiaireRepository.save(stagiaire);
    }
    
    public Optional<Stagiaire> updateStagiaire(Long id, Stagiaire stagiaireDetails) {
        return stagiaireRepository.findById(id)
                .map(stagiaire -> {
                    stagiaire.setNom(stagiaireDetails.getNom());
                    stagiaire.setPrenom(stagiaireDetails.getPrenom());
                    stagiaire.setEmail(stagiaireDetails.getEmail());
                    stagiaire.setDateDebut(stagiaireDetails.getDateDebut());
                    stagiaire.setDateFin(stagiaireDetails.getDateFin());
                    stagiaire.setEncadreurId(stagiaireDetails.getEncadreurId());
                    return stagiaireRepository.save(stagiaire);
                });
    }
    
    public boolean deleteStagiaire(Long id) {
        return stagiaireRepository.findById(id)
                .map(stagiaire -> {
                    stagiaireRepository.delete(stagiaire);
                    return true;
                }).orElse(false);
    }
}
