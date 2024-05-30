package com.example.mnsgarage.Controller;


import com.example.mnsgarage.Entite.Voitures;
import com.example.mnsgarage.Service.LicensePlateRecognitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LicensePlateController {
    private final LicensePlateRecognitionService licensePlateRecognitionService;

    @Autowired
    public LicensePlateController(LicensePlateRecognitionService licensePlateRecognitionService) {
        this.licensePlateRecognitionService = licensePlateRecognitionService;
    }

    @GetMapping("recognize/{plateNumber}")
    public ResponseEntity<Voitures> recognizeVehicleByLicensePlate(@PathVariable("plateNumber") String plaqueImmatriculation) {
        Voitures recognizedVehicle = licensePlateRecognitionService.recognizeVehicleByLicensePlate(plaqueImmatriculation);
        if (recognizedVehicle != null) {
            return ResponseEntity.ok(recognizedVehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}