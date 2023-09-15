package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Services;

import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.Populations;

import java.util.List;

public interface PopulationsService {
    // Methode de creation d'une population
    Populations creer (Populations populations);

    // Rétourner la liste des populations
    List<Populations> lire();

    // Modifier une populations données
    Populations modifier(Long id_population, Populations population);

    // Supprimer une populations
    String supprimer(long id_population);

}
