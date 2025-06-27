package com.stagiaires.stagiaire.controller;

import com.stagiaires.stagiaire.entity.Stagiaire;
import com.stagiaires.stagiaire.service.StagiaireService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stagiaires")
@Tag(name = "Stagiaire", description = "API de gestion des stagiaires")
public class StagiaireController {
    
    @Autowired
    private StagiaireService stagiaireService;
    
    @GetMapping
    @Operation(summary = "Récupérer tous les stagiaires")
    public ResponseEntity<List<Stagiaire>> getAllStagiaires() {
        List<Stagiaire> stagiaires = stagiaireService.getAllStagiaires();
        return ResponseEntity.ok(stagiaires);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un stagiaire par ID")
    public ResponseEntity<Stagiaire> getStagiaireById(@PathVariable Long id) {
        return stagiaireService.getStagiaireById(id)
                .map(stagiaire -> ResponseEntity.ok().body(stagiaire))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    @Operation(summary = "Créer un nouveau stagiaire")
    public ResponseEntity<Stagiaire> createStagiaire(@Valid @RequestBody Stagiaire stagiaire) {
        Stagiaire createdStagiaire = stagiaireService.createStagiaire(stagiaire);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStagiaire);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un stagiaire")
    public ResponseEntity<Stagiaire> updateStagiaire(@PathVariable Long id, @Valid @RequestBody Stagiaire stagiaireDetails) {
        return stagiaireService.updateStagiaire(id, stagiaireDetails)
                .map(updatedStagiaire -> ResponseEntity.ok(updatedStagiaire))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un stagiaire")
    public ResponseEntity<?> deleteStagiaire(@PathVariable Long id) {
        if (stagiaireService.deleteStagiaire(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
