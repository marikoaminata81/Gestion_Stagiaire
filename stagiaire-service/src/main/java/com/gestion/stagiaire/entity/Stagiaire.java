package com.gestion.stagiaire.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "stagiaires")
public class Stagiaire {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nom;
    
    @Column(nullable = false)
    private String prenom;
    
    @Column(unique = true)
    private String email;
    
    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;
    
    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;
    
    @Column(name = "encadreur_id")
    private Long encadreurId;
    
    // Constructeur vide
    public Stagiaire() {}
    
    // Constructeur avec paramètres
    public Stagiaire(String nom, String prenom, String email, LocalDate dateDebut, LocalDate dateFin, Long encadreurId) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.encadreurId = encadreurId;
    }
    
    // Getters et Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public LocalDate getDateDebut() {
        return dateDebut;
    }
    
    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }
    
    public LocalDate getDateFin() {
        return dateFin;
    }
    
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
    
    public Long getEncadreurId() {
        return encadreurId;
    }
    
    public void setEncadreurId(Long encadreurId) {
        this.encadreurId = encadreurId;
    }
}
