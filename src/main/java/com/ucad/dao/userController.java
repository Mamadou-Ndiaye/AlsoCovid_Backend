package com.ucad.dao;

import com.ucad.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@CrossOrigin
@RestController
public class userController {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @GetMapping(path = "/users")
    public List<Utilisateur> listUsers(){
        return utilisateurRepository.findAll();
    }
   @PutMapping(path = "/updateUser/{id}")
   public  Utilisateur updateUser(@PathVariable(name = "id") String id, @RequestBody Utilisateur utilisateur){
        Utilisateur utilisateur1=utilisateurRepository.findById(id).get();
        utilisateur1.setEtat(utilisateur.etat);
      return  utilisateurRepository.save(utilisateur1);

   }




    @GetMapping(value = "/userTrue")
    public Collection<Utilisateur> getAllUsers() {
        Collection<Utilisateur> utilisateurs= new ArrayList<Utilisateur>();
        Collection<Utilisateur> users = utilisateurRepository.findAll();
        for (Utilisateur user:users ){
            if (user.isEtat())
            {
                utilisateurs.add(user);
            }
        }
        return  utilisateurs;
    }

}
