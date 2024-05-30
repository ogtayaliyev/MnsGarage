package com.example.mnsgarage.Repository;


import com.example.mnsgarage.Entite.Voiture_model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Creating an interface called ModelRepository. It extends JpaRepository,
// allowing it to utilize JpaRepository's methods to interact with the data of the Voiture_model table in the database.
public interface ModelRepository extends JpaRepository<Voiture_model, Long> {

    // Method to find models by marque ID.
    List<Voiture_model> findByMarqueId(Long marqueId);
}
