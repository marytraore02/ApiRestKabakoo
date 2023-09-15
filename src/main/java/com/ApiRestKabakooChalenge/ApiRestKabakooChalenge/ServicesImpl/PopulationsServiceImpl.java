package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.ServicesImpl;

import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.Populations;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Repositories.PopulationsRepository;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Services.PopulationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopulationsServiceImpl implements PopulationsService {
    @Autowired
    PopulationsRepository populationsRepository;
    @Override
    public Populations creer(Populations populations) {
        return populationsRepository.save(populations);
    }

    @Override
    public List<Populations> lire() {
        return populationsRepository.findAll();
    }

    @Override
    public Populations modifier(Long id_population, Populations population) {
        return populationsRepository.findById(id_population)
                .map(p->{
                    p.setNombrePopulation(population.getNombrePopulation());
                    p.setAnneePopulation(population.getAnneePopulation());
                    return populationsRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Population non trouvé !"));
    }

    @Override
    public String supprimer(long id_population) {
        populationsRepository.deleteById(id_population);
        return "Population supprimé avec success";
    }
}
