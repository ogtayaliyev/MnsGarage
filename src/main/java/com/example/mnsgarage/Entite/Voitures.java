package com.example.mnsgarage.Entite;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Voitures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    private Date anne_fabrication;
    private String couleur;
    private String boite;
    private String carroserie;
    private String carburant;
    private Integer kilometrage;
    private String plaqueImmatriculation;
    private boolean etatVente;


//    @ManyToOne
//    @JoinColumn(name = "marque_id")
//    private Voiture_Marque marque;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Voiture_model model;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;



}