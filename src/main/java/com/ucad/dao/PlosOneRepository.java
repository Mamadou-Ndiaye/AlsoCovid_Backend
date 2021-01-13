package com.ucad.dao;


import com.ucad.entities.Nature;
import com.ucad.entities.PlosOne;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface PlosOneRepository  extends MongoRepository<PlosOne,String> {

    // Recuperer en fonction du titre
    @RestResource(path = "/byTitre")
    public List<PlosOne> findByTitreContainsIgnoreCase(@Param("titre") String titre);

    // Recuperer en fonction du date
    @RestResource(path = "/byDate")
    public List<PlosOne> findByDateContainsIgnoreCase(@Param("annee") String annee);

    // Recuperer en fonction du type
    @RestResource(path = "/byType")
    public List<PlosOne> findByTypeContainsIgnoreCase(@Param("type") String type);

    // Recuperer en fonction du type et de la date
    @RestResource(path = "/byTypeAndDate")
    public List<PlosOne> findByTypeContainsIgnoreCaseAndDateContainsIgnoreCase(@Param("type") String type,@Param("annee") String annee);

    // Recuperer en fonction du titre et du date Pour y acceder on peut mettre par exemple  http://localhost:8080/Natures/search/byDateAndTitre?titre=sars&&annee=2020
    @RestResource(path = "/byDateAndTitre")
    public List<PlosOne> findByTitreContainsIgnoreCaseAndDateContainsIgnoreCase(@Param("titre") String titre,@Param("annee") String annee);


    @RestResource(path = "/byDateAndType")
    public List<PlosOne> findByTypeAndDateContainsIgnoreCase(@Param("type") String type,@Param("annee") String annee);


    @RestResource(path = "/byDateORTitre")
    public List<PlosOne> findByTitreOrDateContainsIgnoreCase(@Param("titre") String titre,@Param("annee") String annee);

    @RestResource(path = "/filtreScience")
    public List<PlosOne> findByTypeOrDateContainsIgnoreCase(@Param("type") String type,@Param("annee") String annee);


}
