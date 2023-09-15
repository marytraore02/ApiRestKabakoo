package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Controllers;

import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Configurations.ImageUploadConfig;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.Pays;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.Regions;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Repositories.RegionsRepository;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Services.PaysService;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Services.RegionsService;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.dto.Message;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.dto.RegionDto;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.micrometer.common.util.StringUtils;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

//@Api(value = "hello", description = "CRUD REGIONS")
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/regions")
@AllArgsConstructor
public class RegionsController {
    @Autowired
    RegionsService regionsService;
    @Autowired
    PaysService paysServices;
    @Autowired
    RegionsRepository regionsRepository;

//    @ApiOperation(value = "Créer une region")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create/new/{nomPays}")
    public ResponseEntity<?> create(@RequestParam(value = "data") String acti,
                                    @PathVariable("nomPays") String nomPays,
                                    @RequestParam(value = "file", required = false) MultipartFile file)
            throws IOException {
        Regions region = null;

        //System.out.println(idutilisateur);
        Pays pays = paysServices.getNomPays(nomPays);

        try {
            region = new JsonMapper().readValue(acti, Regions.class);
            System.out.println("==========Nom region===========" + region);

            if (file != null && pays != null) {
                try {
                    //                    User user = crudService.RecupererParId(idutilisateur);
                    //                    region.setCreateur(user);

                    //System.out.println(user);

                    region.setImageRegion(ImageUploadConfig.save("region", file, region.getNomRegion()));
                    regionsService.creer(region);
                    return new ResponseEntity(new Message("Region créé avec success"), HttpStatus.OK);
                } catch (Exception e) {
                    // TODO: handle exception
                    return new ResponseEntity(new Message("Pays introuvable ou fichier corrompu"), HttpStatus.OK);
                }
            } else {
                return new ResponseEntity(new Message("Fichier vide"), HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println(region);
            return new ResponseEntity(new Message("Erreur"), HttpStatus.OK);
        }

    }


    @PreAuthorize("hasRole('ADMIN')")
//    @ApiOperation(value = "Modifier une region")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody RegionDto regionDto){
        if(!regionsRepository.existsById(id))
            return new ResponseEntity(new Message("Id de la region n'existe pas"), HttpStatus.NOT_FOUND);
        /*if(regionRepository.existsByName(regionDto.getNomRegion()) && regionService.getByNameRegion(regionDto.getNomRegion()).get().getIdRegion() != id)
            return new ResponseEntity(new Message("La region existe déjà"), HttpStatus.BAD_REQUEST);*/
        if(StringUtils.isBlank(regionDto.getNomRegion()))
            return new ResponseEntity(new Message("le nom de la region est obligatoire pour effectuer la mise à jour"), HttpStatus.BAD_REQUEST);

        regionsService.modifier(id, regionDto);
        return new ResponseEntity(new Message("Mise à jour effectué avec success"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
//    @ApiOperation(value = "Supprimer une region")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(!regionsRepository.existsById(id))
            return new ResponseEntity(new Message("Id de la region n'existe pas"), HttpStatus.NOT_FOUND);
        regionsService.supprimer(id);
        return new ResponseEntity(new Message("Region supprimer avec success"), HttpStatus.OK);
    }


    //    @ApiOperation(value = "Récupérer la liste des regions")
    @GetMapping("/read")
    public ResponseEntity<List<Regions>> list(){
        List<Regions> list = regionsService.lire();
        return new ResponseEntity(list, HttpStatus.OK);
    }


    //    @ApiOperation(value = "Récupérer liste des regions sans pays")
    @GetMapping("/lireSP")
    public Iterable<Object[]> getRegionsSP(){
        return regionsService.getRegionsSP();
    }



//    @ApiOperation(value = "Voir les details d'une region")
//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Regions> getById(@PathVariable("id") Long id){
        if(!regionsRepository.existsById(id))
            return new ResponseEntity(new Message("La region n'existe pas"), HttpStatus.NOT_FOUND);
        Regions r = regionsService.getOne(id).get();
        return new ResponseEntity(r, HttpStatus.OK);
    }



    }
