package com.ucad.dao;

import com.ucad.entities.Article;
import com.ucad.entities.WebDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@CrossOrigin
@RepositoryRestResource
public interface ArticleRepository  extends MongoRepository<Article,String> {
   // Recuperer en fonction du titre
    @RestResource(path = "/byTitre")
    public List<Article> findByTitreContainsIgnoreCase(@Param("titre") String titre);

    // Recuperer en fonction du date
    @RestResource(path = "/byDate")
    public List<Article> findByDateContainsIgnoreCase(@Param("annee") String annee);

    // Recuperer en fonction du type
    @RestResource(path = "/byType")
    public List<Article> findByTypeContainsIgnoreCase(@Param("type") String type);

    // Recuperer en fonction du type et de la date
    @RestResource(path = "/byTypeAndDate")
    public List<Article> findByTypeContainsIgnoreCaseAndDateContainsIgnoreCase(@Param("type") String type,@Param("annee") String annee);


    // Recuperer en fonction du titre et du date Pour y acceder on peut mettre par exemple  http://localhost:8080/articles/search/byDateAndTitre?titre=sars&&annee=2020
    @RestResource(path = "/byDateAndTitre")
    public List<Article> findByTitreContainsIgnoreCaseAndDateContainsIgnoreCase(@Param("titre") String titre,@Param("annee") String annee);


    @RestResource(path = "/byDateAndType")
    public List<Article> findByTypeAndDateContainsIgnoreCase(@Param("type") String type,@Param("annee") String annee);


    @RestResource(path = "/byDateORTitre")
    public List<Article> findByTitreOrDateContainsIgnoreCase(@Param("titre") String titre,@Param("annee") String annee);

    @RestResource(path = "/filtreScience")
    public List<Article> findByTypeOrDateContainsIgnoreCase(@Param("type") String type,@Param("annee") String annee);



}
