package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Services;

import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.User;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UtilisateurService {
    @Autowired
    UserRepository userRepository;

    public User getByEmail(String email) {
        // TODO Auto-generated method stub
        return userRepository.findByEmail(email);
    }
    public boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }
    public boolean getByNomEtPrenom(String nom){
        return userRepository.existsByNomEtPrenom(nom);
    }
    public User creer(User utilisateur){
        return userRepository.save(utilisateur);
    }

}
