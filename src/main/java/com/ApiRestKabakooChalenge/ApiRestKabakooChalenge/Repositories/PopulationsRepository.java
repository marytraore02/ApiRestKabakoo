package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Repositories;

import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.Populations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopulationsRepository extends JpaRepository<Populations, Long> {
}
