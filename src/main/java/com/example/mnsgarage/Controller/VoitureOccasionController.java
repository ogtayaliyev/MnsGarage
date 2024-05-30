package com.example.mnsgarage.Controller;


import com.example.mnsgarage.Entite.Voiture_ocasion;
import com.example.mnsgarage.Repository.VoitureOccasionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
public class VoitureOccasionController {

 @Autowired
  private VoitureOccasionRepository voitureOccasionRepository;

    @GetMapping("voitureOccasion")
    public List<Voiture_ocasion> getAllVoitures() {

        return voitureOccasionRepository.findAll();
    }
}
