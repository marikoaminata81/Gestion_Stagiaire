package com.gestion.encadreur.controller;

import com.gestion.encadreur.entity.Encadreur;
import com.gestion.encadreur.service.EncadreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/encadreurs")
public class EncadreurController {
    
    @Autowired
    private EncadreurService encadreurService;
    
    // GET /api/encadreurs - Récupérer tous les encadreurs
    @GetMapping
    public ResponseEntity<List<Encadreur>> getAllEncadreurs() {
        List<Encadreur> encadreurs = encadreurService.getAllEncadreurs();
        return ResponseEntity.ok(encadreurs);
    }
    
    // GET /api/encadreurs/{id} - Récupérer un encadreur par ID
    @GetMapping("/{id}")
    public ResponseEntity<Encadreur> getEncadreurById(@PathVariable Long id) {
        Optional<Encadreur> encadreur = encadreurService.getEncadreurById(id);
        if (encadreur.isPresent()) {
            return ResponseEntity.ok(encadreur.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // POST /api/encadreurs - Créer un nouveau encadreur
    @PostMapping
    public ResponseEntity<Encadreur> createEncadreur(@RequestBody Encadreur encadreur) {
        Encadreur createdEncadreur = encadreurService.createEncadreur(encadreur);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEncadreur);
    }
    
    // PUT /api/encadreurs/{id} - Mettre à jour un encadreur
    @PutMapping("/{id}")
    public ResponseEntity<Encadreur> updateEncadreur(@PathVariable Long id, @RequestBody Encadreur encadreurDetails) {
        Encadreur updatedEncadreur = encadreurService.updateEncadreur(id, encadreurDetails);
        if (updatedEncadreur != null) {
            return ResponseEntity.ok(updatedEncadreur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // DELETE /api/encadreurs/{id} - Supprimer un encadreur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEncadreur(@PathVariable Long id) {
        boolean deleted = encadreurService.deleteEncadreur(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
