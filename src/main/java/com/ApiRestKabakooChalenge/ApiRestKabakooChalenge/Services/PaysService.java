package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Services;

import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.Pays;

import java.util.List;

public interface PaysService {
    // Methode de creation d'un pays
    Pays creer (Pays pays);

    // Récupérer un pays par son nom
    Pays getNomPays( String nom);

    // Rétourner la liste des pays
    List<Pays> lire();

    // Modifier un pays
    Pays modifier(Long id_pays, Pays pays);

    // Supprimer un pays
    String supprimer(long id_pays);
}
