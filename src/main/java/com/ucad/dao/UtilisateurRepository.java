package com.ucad.dao;

import com.ucad.entities.Utilisateur;
import com.ucad.entities.WebDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource
public interface UtilisateurRepository extends MongoRepository<Utilisateur,String> {

     @RestResource(path = "/etatUtilisateur")
    public List<Utilisateur>  findAllByEtatIsFalse();


}
