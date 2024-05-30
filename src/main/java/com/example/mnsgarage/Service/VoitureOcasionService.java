package com.example.mnsgarage.Service;


import com.example.mnsgarage.Entite.Voiture_ocasion;
import com.example.mnsgarage.Repository.VoitureOccasionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureOcasionService {

    private final VoitureOccasionRepository voitureOccasionRepository;

    @Autowired
    public VoitureOcasionService(VoitureOccasionRepository voitureOccasionRepository) {
        this.voitureOccasionRepository = voitureOccasionRepository;
    }

    public List<Voiture_ocasion> getAllVoitures() {
        return voitureOccasionRepository.findAll();
    }
}
