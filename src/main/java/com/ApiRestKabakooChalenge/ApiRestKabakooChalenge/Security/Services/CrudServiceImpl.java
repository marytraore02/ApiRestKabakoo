package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Security.Services;

import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.User;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudServiceImpl implements CrudService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public String Supprimer(Long id_user) {
        userRepository.deleteById(id_user);
        return "Supprimer avec succes";
    }


    @Override
    public String Modifier(User user) {
        return userRepository.findById(user.getId()).map(
                use -> {
                    use.setNomEtPrenom(user.getNomEtPrenom());
                    use.setContact(user.getContact());
                    use.setDate(user.getDate());
                    use.setUsername(user.getUsername());
                    use.setEmail(user.getEmail());
                    use.setPassword(passwordEncoder.encode(user.getPassword()));
                    userRepository.save(use);
                    return "Modification reussie avec succès";
                }
        ).orElseThrow(() -> new RuntimeException("Cet utilisateur n'existe pas"));

    }

    @Override
    public List<User> Afficher() {
        return userRepository.findAll();
    }

}
