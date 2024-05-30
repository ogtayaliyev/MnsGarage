package com.example.mnsgarage.Service;


import com.example.mnsgarage.Entite.Utilisateur;
import com.example.mnsgarage.Entite.Voiture_Marque;
import com.example.mnsgarage.Entite.Voiture_model;
import com.example.mnsgarage.Entite.Voitures;
import com.example.mnsgarage.Repository.MarqueRepository;
import com.example.mnsgarage.Repository.ModelRepository;
import com.example.mnsgarage.Repository.UtilisateurRepository;
import com.example.mnsgarage.Repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureService {

    @Autowired
    private VoitureRepository voitureRepository;
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private MarqueRepository marqueRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Voitures> getAllVoitures() {
        return voitureRepository.findAll();
    }

    public List<Voiture_Marque> getAllMarques() {
    return marqueRepository.findAll();
    }

    public void addVoiture(int idUtilisateur, Voitures voitures) {

        Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable avec l'ID : " + idUtilisateur));

        // Associer la voiture à l'utilisateur
        voitures.setUtilisateur(utilisateur);

        // Sauvegarder la voiture dans la base de données
        voitureRepository.save(voitures);
    }

    public Voitures updateVoiture(Long userId, Long voitureId, Voitures voitureModifiee) {
        // List des Voitures utilisateur connecté
        List<Voitures> kullaniciAraclari = voitureRepository.findByUtilisateurId(userId);

        // Trouver voiture utilisateure dans les voitures existent
        Voitures voitureExistante = null;
        for (Voitures voiture : kullaniciAraclari) {
            if (voiture.getId().equals(voitureId)) {
                voitureExistante = voiture;
                break;
            }
        }

        if (voitureExistante == null) {
            return null; //
        }

        if (voitureModifiee.getKilometrage() != null) {
            voitureExistante.setKilometrage(voitureModifiee.getKilometrage());
        }
        voitureExistante.setEtatVente(voitureModifiee.isEtatVente());
        return voitureRepository.save(voitureExistante);
    }



    public List<Voiture_model> getModelsByMarqueId(Long marqueId) {
        return modelRepository.findByMarqueId(marqueId);
    }


    public void deleteVoiture(Long id) {
        voitureRepository.deleteById(id);
    }

}
