package com.stagiaires.encadreur.controller;

import com.stagiaires.encadreur.entity.Encadreur;
import com.stagiaires.encadreur.service.EncadreurService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/encadreurs")
@Tag(name = "Encadreur", description = "API de gestion des encadreurs")
public class EncadreurController {
    
    @Autowired
    private EncadreurService encadreurService;
    
    @GetMapping
    @Operation(summary = "Récupérer tous les encadreurs")
    public ResponseEntity<List<Encadreur>> getAllEncadreurs() {
        List<Encadreur> encadreurs = encadreurService.getAllEncadreurs();
        return ResponseEntity.ok(encadreurs);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un encadreur par ID")
    public ResponseEntity<Encadreur> getEncadreurById(@PathVariable Long id) {
        return encadreurService.getEncadreurById(id)
                .map(encadreur -> ResponseEntity.ok().body(encadreur))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    @Operation(summary = "Créer un nouveau encadreur")
    public ResponseEntity<Encadreur> createEncadreur(@Valid @RequestBody Encadreur encadreur) {
        Encadreur createdEncadreur = encadreurService.createEncadreur(encadreur);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEncadreur);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un encadreur")
    public ResponseEntity<Encadreur> updateEncadreur(@PathVariable Long id, @Valid @RequestBody Encadreur encadreurDetails) {
        return encadreurService.updateEncadreur(id, encadreurDetails)
                .map(updatedEncadreur -> ResponseEntity.ok(updatedEncadreur))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un encadreur")
    public ResponseEntity<?> deleteEncadreur(@PathVariable Long id) {
        if (encadreurService.deleteEncadreur(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
