package com.stagiaires.stagiaire.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "stagiaires")
public class Stagiaire {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Le nom est obligatoire")
    @Column(nullable = false)
    private String nom;
    
    @NotBlank(message = "Le prénom est obligatoire")
    @Column(nullable = false)
    private String prenom;
    
    @Email(message = "Format d'email invalide")
    @Column(unique = true)
    private String email;
    
    @NotNull(message = "La date de début est obligatoire")
    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;
    
    @NotNull(message = "La date de fin est obligatoire")
    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;
    
    @Column(name = "encadreur_id")
    private Long encadreurId;
    
    // Constructeurs
    public Stagiaire() {}
    
    public Stagiaire(String nom, String prenom, String email, LocalDate dateDebut, LocalDate dateFin, Long encadreurId) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.encadreurId = encadreurId;
    }
    
    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }
    
    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }
    
    public Long getEncadreurId() { return encadreurId; }
    public void setEncadreurId(Long encadreurId) { this.encadreurId = encadreurId; }
}
