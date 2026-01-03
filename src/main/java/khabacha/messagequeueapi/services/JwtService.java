package khabacha.messagequeueapi.services;

import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private String SECRET_KEY = "votre_secret_key_ici_minimum_256_bits";

    // Méthode pour générer un token
    public String generateToken(String username) {
        // À compléter
    }

    // Méthode pour valider un token
    public boolean validateToken(String token) {
        // À compléter
    }

    // Méthode pour extraire le username du token
    public String extractUsername(String token) {
        // À compléter
    }
}