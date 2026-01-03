package khabacha.messagequeueapi.services;

import khabacha.messagequeueapi.repository.IUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUsers userRepository;

    @Autowired
    private JwtService jwtService;

    // Méthode register
    public void register(String username, String password) {
        // Encoder le password avec BCrypt
        // Sauvegarder l'user
    }

    // Méthode login
    public String login(String username, String password) {
        // Vérifier credentials
        // Générer et retourner JWT
    }
}