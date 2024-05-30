package com.example.mnsgarage;

import com.example.mnsgarage.Entite.Role;
import com.example.mnsgarage.Entite.Utilisateur;
import com.example.mnsgarage.Repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@EnableScheduling
@SpringBootApplication
public class MnsgarageApplication implements CommandLineRunner {
    UtilisateurRepository utilisateurRepository;
    PasswordEncoder passwordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(MnsgarageApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createUtilisateurIfNotExists("admin", "ogtayaliyev9@gmail.com", "Admin2024.", TypeDeRole.ADMINISTRATEUR);
    }

    private void createUtilisateurIfNotExists(String nom, String email, String password, TypeDeRole roleType) {
        if (utilisateurRepository.findByEmail(email).isEmpty()) {
            Utilisateur utilisateur = Utilisateur.builder()
                    .actif(true)
                    .nom(nom)
                    .email(email)
                    .password(passwordEncoder.encode(password))
                    .role(
                            Role.builder()
                                    .libelle(roleType)
                                    .build()
                    )
                    .build();
            utilisateurRepository.save(utilisateur);
        }
    }
}
