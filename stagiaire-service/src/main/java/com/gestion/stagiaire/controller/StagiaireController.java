package com.gestion.stagiaire.controller;

import com.gestion.stagiaire.entity.Stagiaire;
import com.gestion.stagiaire.service.StagiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stagiaires")
public class StagiaireController {
    
    @Autowired
    private StagiaireService stagiaireService;
    
    // GET /api/stagiaires - Récupérer tous les stagiaires
    @GetMapping
    public ResponseEntity<List<Stagiaire>> getAllStagiaires() {
        List<Stagiaire> stagiaires = stagiaireService.getAllStagiaires();
        return ResponseEntity.ok(stagiaires);
    }
    
    // GET /api/stagiaires/{id} - Récupérer un stagiaire par ID
    @GetMapping("/{id}")
    public ResponseEntity<Stagiaire> getStagiaireById(@PathVariable Long id) {
        Optional<Stagiaire> stagiaire = stagiaireService.getStagiaireById(id);
        if (stagiaire.isPresent()) {
            return ResponseEntity.ok(stagiaire.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // POST /api/stagiaires - Créer un nouveau stagiaire
    @PostMapping
    public ResponseEntity<Stagiaire> createStagiaire(@RequestBody Stagiaire stagiaire) {
        Stagiaire createdStagiaire = stagiaireService.createStagiaire(stagiaire);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStagiaire);
    }
    
    // PUT /api/stagiaires/{id} - Mettre à jour un stagiaire
    @PutMapping("/{id}")
    public ResponseEntity<Stagiaire> updateStagiaire(@PathVariable Long id, @RequestBody Stagiaire stagiaireDetails) {
        Stagiaire updatedStagiaire = stagiaireService.updateStagiaire(id, stagiaireDetails);
        if (updatedStagiaire != null) {
            return ResponseEntity.ok(updatedStagiaire);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // DELETE /api/stagiaires/{id} - Supprimer un stagiaire
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStagiaire(@PathVariable Long id) {
        boolean deleted = stagiaireService.deleteStagiaire(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
