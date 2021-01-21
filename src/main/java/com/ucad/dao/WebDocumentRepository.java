package com.ucad.dao;

import com.sipios.springsearch.anotation.SearchSpec;
import com.ucad.entities.Utilisateur;
import com.ucad.entities.WebDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RepositoryRestResource
public interface WebDocumentRepository  extends MongoRepository<WebDocument,String> {

    @RestResource(path = "/byTitre")
    public Page<WebDocument>  findByTitreContainsIgnoreCase(@Param("titre") String titre,Pageable pageable);


    public List<WebDocument>  findByTitreContainsIgnoreCase(@Param("titre") String titre);

    @RestResource(path = "/byFiltre")
    public List<WebDocument>  findByTitreContains(@Param("titre") String titre[]);


    public  Page<WebDocument>  findByTitreContainsAndResumeContainsIgnoreCase(@Param("titre") String titre, @Param("res") String resume,Pageable pageable);

 // tout ce que nous avons fait avce objet mapping relationnel on peut le faire avec objet document

 // Dans les CNTP on ne doit pas reecrire ces methodes dans le controlleur ensuite dans le repository
 // Car il font le meme travail sauf que ces methodes ne fonctionnent pas dans le repository
 // et je ne le vois pas dans le controlleur si je l'enleve dans le repository
   @RestResource(path = "/webDocumentOrderByCovid")
   public Page<WebDocument> findByOrderByConCovidDesc(Pageable pageable);

    @RestResource(path = "/webDocumentOrderByhistorique")
    public Page<WebDocument>  findByOrderByHistSanitaireDesc(Pageable pageable);

    @RestResource(path = "/webDocumentOrderByIdentite")
    public Page<WebDocument>  findByOrderByIdentiteDesc(Pageable pageable);

    @RestResource(path = "/webDocumentOrderByEnvironnement")
    public Page<WebDocument>  findByOrderByEnvironnementDesc(Pageable pageable);

    @RestResource(path = "/webDocumentOrderByNutrition")
    public Page<WebDocument>  findByOrderByNutritionDesc(Pageable pageable);

    @RestResource(path = "/webDocumentOrderByObjet")
    public Page<WebDocument>  findByOrderByObjetDesc(Pageable pageable);


}
