package com.example.mnsgarage.Service;


import com.example.mnsgarage.Entite.Reparation;
import com.example.mnsgarage.Entite.ReparationType;
import com.example.mnsgarage.Entite.Utilisateur;
import com.example.mnsgarage.Repository.ReparationRepository;
import com.example.mnsgarage.Repository.UtilisateurRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class ReparationService {

//   @Autowired
    private final ReparationRepository reparationRepository;

//    @Autowired
    private final UtilisateurRepository utilisateurRepository;

    public ReparationService(ReparationRepository reparationRepository, UtilisateurRepository utilisateurRepository) {
        this.reparationRepository = reparationRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public void makeReservation(Reparation reparation, int utilisateurId) throws Exception {
        // Charger l'utilisateur à partir de la base de données en utilisant son ID
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(utilisateurId);
        Utilisateur utilisateur = utilisateurOptional.orElseThrow(() -> new Exception("Utilisateur introuvable pour l'ID fourni."));

        // Vérifier si la date de début est spécifiée
        LocalDateTime startDate = reparation.getStartDate();
        if (startDate == null) {
            throw new IllegalArgumentException("Başlangıç tarihi belirtilmeli.");
        }

        // Récupérer le type de réparation en fonction de son ID
        Long reparationTypeId = reparation.getReparationType().getId();
        ReparationType reparationType = reparationRepository.findReparationTypeById(reparationTypeId);
        if (reparationType == null) {
            throw new IllegalArgumentException("Geçersiz reparationType ID'si: " + reparationTypeId);
        }

        // Vérifier s'il existe déjà deux réservations actives pour ce type de réparation
        List<Reparation> existingReservations = reparationRepository.findActiveReservationsByReparationType(reparationType);
        if (existingReservations.size() >= 2) {
            throw new IllegalStateException("Bu reparationType için zaten iki aktif rezervasyon bulunmakta.");
        }


        // Calculer et définir la date de fin de la réservation
        Long selectedDuree = reparationType.getDuree();
        LocalDateTime endDate = startDate.plusMinutes(selectedDuree);
        reparation.setEndDate(endDate);
        reparation.setUtilisateur(utilisateur);
        // Définir le type de réparation pour la réservation
        reparation.setReparationType(reparationType);

        // Enregistrer la nouvelle réservation
        reparationRepository.save(reparation);
    }

    public void deleteReparation(Long id) {
        reparationRepository.deleteById(id);
    }

    public Reparation updateReparation(Long userId, Long reparationId, Reparation reparationModifiee) {
        // List des Voitures utilisateur connecté
        List<Reparation> reparationlist = reparationRepository.findByUtilisateurId(userId);

        // Trouver entretiens reparation d' utilisateure dans les reparations existent
        Reparation reparationExistante = null;
        for (Reparation reparation : reparationlist) {
            if (reparation.getId().equals(reparationId)) {
                reparationExistante = reparation;
                break;
            }
        }

        if (reparationExistante == null) {
            return null; //
        }

        if (reparationModifiee.getEtatReparation() != null) {
            reparationExistante.setEtatReparation(reparationModifiee.getEtatReparation());
        }
        return reparationRepository.save(reparationExistante);
    }

    public List<Reparation> getAllReparations() {
        return reparationRepository.findAll();
    }

    @Scheduled(fixedRate = 60000) // S'exécute toutes les minutes
    public void updateReparationStatus() {
        List<Reparation> reparations = reparationRepository.findByEndDateBeforeAndEtatReparationNot(LocalDateTime.now(), "passé");
        for (Reparation entretien : reparations) {
            entretien.setEtatReparation("passé");
            reparationRepository.save(entretien);
        }
        List<Reparation> reparationsActives = reparationRepository.findByEndDateAfterAndEtatReparationNot(LocalDateTime.now(), "actif");
        for (Reparation reparation : reparationsActives) {
            reparation.setEtatReparation("actif");
            reparationRepository.save(reparation);
        }
    }

}

