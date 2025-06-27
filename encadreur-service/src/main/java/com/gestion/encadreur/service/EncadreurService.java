package com.gestion.encadreur.service;

import com.gestion.encadreur.entity.Encadreur;
import com.gestion.encadreur.repository.EncadreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncadreurService {
    
    @Autowired
    private EncadreurRepository encadreurRepository;
    
    // Récupérer tous les encadreurs
    public List<Encadreur> getAllEncadreurs() {
        return encadreurRepository.findAll();
    }
    
    // Récupérer un encadreur par ID
    public Optional<Encadreur> getEncadreurById(Long id) {
        return encadreurRepository.findById(id);
    }
    
    // Créer un nouveau encadreur
    public Encadreur createEncadreur(Encadreur encadreur) {
        return encadreurRepository.save(encadreur);
    }
    
    // Mettre à jour un encadreur
    public Encadreur updateEncadreur(Long id, Encadreur encadreurDetails) {
        Optional<Encadreur> optionalEncadreur = encadreurRepository.findById(id);
        if (optionalEncadreur.isPresent()) {
            Encadreur encadreur = optionalEncadreur.get();
            encadreur.setNom(encadreurDetails.getNom());
            encadreur.setPrenom(encadreurDetails.getPrenom());
            encadreur.setEmail(encadreurDetails.getEmail());
            encadreur.setTelephone(encadreurDetails.getTelephone());
            return encadreurRepository.save(encadreur);
        }
        return null;
    }
    
    // Supprimer un encadreur
    public boolean deleteEncadreur(Long id) {
        if (encadreurRepository.existsById(id)) {
            encadreurRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
