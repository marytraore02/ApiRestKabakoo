package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Controllers;

import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.Pays;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Services.PaysService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api(value = "hello", description = "CRUD PAYS")
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/pays")
@AllArgsConstructor
public class PaysController {
    @Autowired
    PaysService paysService;
//    @ApiOperation(value = "Créer un pays")
    @PostMapping("/create")
    public Pays create(@RequestBody Pays pays){
        return paysService.creer(pays);
    }

//    @ApiOperation(value = "Récupérer liste pays")
    @GetMapping("/read")
    public List<Pays> read(){
        return paysService.lire();
    }

//    @ApiOperation(value = "Modifier un pays")
    @PutMapping("/update/{id_pays}")
    public Pays update(@PathVariable Long id_pays, @RequestBody Pays pays){
        return paysService.modifier(id_pays, pays);
    }

//    @ApiOperation(value = "Supprimer un pays")
    @DeleteMapping("/delete/{id_pays}")
    public String delete(@PathVariable Long id_pays){
        return paysService.supprimer(id_pays);
    }

}
