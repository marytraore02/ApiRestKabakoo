package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.ServicesImpl;

import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.Pays;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.Regions;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Repositories.RegionsRepository;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Services.RegionsService;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.dto.RegionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionsServiceImpl implements RegionsService {
    @Autowired
    RegionsRepository regionsRepository;
    @Override
    public Regions creer(Regions regions) {
        return regionsRepository.save(regions);
    }

    @Override
    public List<Regions> lire() {
        return regionsRepository.findAll();
    }

    @Override
    public Regions modifier(Long idRegion, RegionDto regions) {
        return regionsRepository.findById(idRegion)
                .map(p->{
                    p.setCodeRegion(regions.getCodeRegion());
                    p.setNomRegion(regions.getNomRegion());
                    p.setDescriptionRegion(regions.getDescriptionRegion());
                    p.setDomaineActiviteRegion(regions.getDomaineActiviteRegion());
                    p.setLangueMajoritaireRegion(regions.getLangueMajoritaireRegion());
                    p.setSuperficieRegion(regions.getSuperficieRegion());
                    return regionsRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Region non trouvé !"));
    }

    @Override
    public void supprimer(long idRegion) {
        regionsRepository.deleteById(idRegion);
    }

    @Override
    public Optional<Regions> getOne(Long id) {
        return regionsRepository.findById(id);
    }

    @Override
    public Regions getNomRegion(String name) {
        return regionsRepository.findByNomRegion(name);
    }

    @Override
    public Iterable<Object[]> getRegionsSP() {
        return regionsRepository.getRegionsSP();
    }

}
