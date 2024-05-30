package com.example.mnsgarage.Repository;

import com.example.mnsgarage.Entite.ReparationType;
import org.springframework.data.jpa.repository.JpaRepository;

// Creating an interface called ReparationTypeRepository. It extends JpaRepository,
// allowing it to utilize JpaRepository's methods to interact with the data of the ReparationType table in the database.
public interface ReparationTypeRepository extends JpaRepository<ReparationType, Long> {
}
