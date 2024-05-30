package com.example.mnsgarage.Repository;



import com.example.mnsgarage.Entite.Validation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// Creating an interface called ValidationRepository. It extends CrudRepository,
// allowing it to utilize CrudRepository's methods to interact with the data of the Validation table in the database.
public interface ValidationRepository extends CrudRepository<Validation, Integer> {

    // Method to find a validation by code.
    Optional<Validation> findByCode(String code);
}
