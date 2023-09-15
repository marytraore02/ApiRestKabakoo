package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Security.Services;

import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.User;

import java.util.List;

public interface CrudService {

    String Supprimer(Long id_user);  // LA METHODE PERMETTANT DE SUPPRIMER UN COLLABORATEUR

    String Modifier(User user);   // LA METHODE PERMETTANT DE MODIFIER UN COLLABORATEUR

    List<User> Afficher();       // LA METHODE PERMETTANT D'AFFICHER UN COLLABORATEUR

}
