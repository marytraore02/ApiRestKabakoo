package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Repositories;

import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionsRepository extends JpaRepository<Regions, Long> {
    // Récupération de la region par son nom
    Regions findByNomRegion(String name);

    // Récupération de la region par son Id
    Optional<Regions> findByIdRegion(Long idRegion);

    // Récupération de la liste des regions sans pays
    @Query(value = "SELECT id,code_region,nom_region,description_region,langue_majoritaire_region,domaine_activite_region,superficie_region FROM regions", nativeQuery = true)
    Iterable<Object[]> getRegionsSP ();

}
