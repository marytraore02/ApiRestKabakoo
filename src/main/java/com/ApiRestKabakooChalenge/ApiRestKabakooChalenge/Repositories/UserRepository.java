package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Repositories;

import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
    Boolean existsByNomEtPrenom(String nom);

    Boolean existsByEmail(String email);

    User findByEmail(String email);
    User findByImage(String image);

    User findByEmailAndPassword(String email, String password);


    List<User> findById(User role);
}
