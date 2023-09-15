package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Controllers;

import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.Populations;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Services.PopulationsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api(value = "hello", description = "CRUD POPULATIONS")
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/populations")
@AllArgsConstructor
public class PopulationsController {
    @Autowired
    PopulationsService populationsService;
//    @ApiOperation(value = "Créer une population")
    @PostMapping("/create")
    public Populations create(@RequestBody Populations populations){
        return populationsService.creer(populations);
    }

//    @ApiOperation(value = "Récupérer liste populations")
    @GetMapping("/read")
    public List<Populations> read(){
        return populationsService.lire();
    }

//    @ApiOperation(value = "Modifier une population")
    @PutMapping("/update/{id_population}")
    public Populations update(@PathVariable Long id_population, @RequestBody Populations populations){
        return populationsService.modifier(id_population, populations);
    }

//    @ApiOperation(value = "Supprimer une population")
    @DeleteMapping("/delete/{id_population}")
    public String delete(@PathVariable Long id_population){
        return populationsService.supprimer(id_population);
    }
}

