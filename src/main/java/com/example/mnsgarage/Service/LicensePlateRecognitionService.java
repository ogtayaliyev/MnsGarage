package com.example.mnsgarage.Service;


import com.example.mnsgarage.Entite.Voitures;
import com.example.mnsgarage.Repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LicensePlateRecognitionService {

    private final VoitureRepository voitureRepository;

    @Autowired
    public LicensePlateRecognitionService(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }

    public Voitures recognizeVehicleByLicensePlate(String plaqueImmatriculation) {
        return voitureRepository.findByPlaqueImmatriculation(plaqueImmatriculation);
    }
}
