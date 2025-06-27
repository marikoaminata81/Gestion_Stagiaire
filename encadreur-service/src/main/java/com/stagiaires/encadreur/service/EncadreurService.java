package com.stagiaires.encadreur.service;

import com.stagiaires.encadreur.entity.Encadreur;
import com.stagiaires.encadreur.repository.EncadreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncadreurService {
    
    @Autowired
    private EncadreurRepository encadreurRepository;
    
    public List<Encadreur> getAllEncadreurs() {
        return encadreurRepository.findAll();
    }
    
    public Optional<Encadreur> getEncadreurById(Long id) {
        return encadreurRepository.findById(id);
    }
    
    public Encadreur createEncadreur(Encadreur encadreur) {
        return encadreurRepository.save(encadreur);
    }
    
    public Optional<Encadreur> updateEncadreur(Long id, Encadreur encadreurDetails) {
        return encadreurRepository.findById(id)
                .map(encadreur -> {
                    encadreur.setNom(encadreurDetails.getNom());
                    encadreur.setPrenom(encadreurDetails.getPrenom());
                    encadreur.setEmail(encadreurDetails.getEmail());
                    encadreur.setTelephone(encadreurDetails.getTelephone());
                    return encadreurRepository.save(encadreur);
                });
    }
    
    public boolean deleteEncadreur(Long id) {
        return encadreurRepository.findById(id)
                .map(encadreur -> {
                    encadreurRepository.delete(encadreur);
                    return true;
                }).orElse(false);
    }
}
