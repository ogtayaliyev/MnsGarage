package com.example.mnsgarage.Repository;


import com.example.mnsgarage.Entite.Voiture_Marque;
import org.springframework.data.jpa.repository.JpaRepository;

// Creating an interface called MarqueRepository. It extends JpaRepository,
// allowing it to utilize JpaRepository's methods to interact with the data of the Voiture_Marque table in the database.
public interface MarqueRepository extends JpaRepository<Voiture_Marque, Long> {
}