package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Services;

import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.Pays;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.Regions;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.dto.RegionDto;

import java.util.List;
import java.util.Optional;

public interface RegionsService {
    // Methode de creation d'une region
    Regions creer(Regions regions);

    // Rétourner la liste des regions par pays
    List<Regions> lire();

    // Modifier une region
    Regions modifier(Long id, RegionDto region);

    // Supprimer une region
    void supprimer(long idRegion);

    // Récupérer une region par son id
    Optional<Regions> getOne(Long id);

    // Récupérer une region par son nom
    Regions getNomRegion(String name);

    // Rétourner la liste des regions sans pays
    Iterable<Object[]> getRegionsSP();
}
