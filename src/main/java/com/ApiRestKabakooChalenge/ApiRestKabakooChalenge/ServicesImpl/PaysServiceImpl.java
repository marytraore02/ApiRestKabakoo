package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.ServicesImpl;

import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.Pays;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Repositories.PaysRepository;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Services.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaysServiceImpl implements PaysService {
    @Autowired
    PaysRepository paysRepository;
    @Override
    public Pays creer(Pays pays) {
        return paysRepository.save(pays);
    }

    @Override
    public Pays getNomPays(String nom) {
        return paysRepository.findByNomPays(nom);
    }

    @Override
    public List<Pays> lire() {
        return paysRepository.findAll();
    }

    @Override
    public Pays modifier(Long id_pays, Pays pays) {
        return paysRepository.findById(id_pays)
                .map(p->{
                    p.setNomPays(pays.getNomPays());
                    return paysRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Pays non trouvé !"));
    }

    @Override
    public String supprimer(long id_pays) {
        paysRepository.deleteById(id_pays);
        return "Pays supprimé avec success";
    }
}
