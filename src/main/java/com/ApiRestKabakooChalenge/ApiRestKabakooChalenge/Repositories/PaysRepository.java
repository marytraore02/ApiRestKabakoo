package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Repositories;

import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaysRepository extends JpaRepository<Pays, Long> {
    // Récupératio du nom du pays
    Pays findByNomPays(String nom_pays);

}
