package com.ucad.dao;


import com.ucad.entities.Who;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource
public interface WhoRepository extends MongoRepository<Who,String> {

    // Recuperer en fonction du titre
    @RestResource(path = "/byTitre")
    public List<Who> findByTitreContainsIgnoreCase(@Param("titre") String titre);

    // Recuperer en fonction du date
    @RestResource(path = "/byDate")
    public List<Who> findByDateContainsIgnoreCase(@Param("annee") String annee);


    // Recuperer en fonction du type et de la date
    @RestResource(path = "/byTitreAndDate")
    public List<Who> findByTitreContainsIgnoreCaseAndDateContainsIgnoreCase(@Param("type") String type,@Param("annee") String annee);


    @RestResource(path = "/byDateORTitre")
    public List<Who> findByTitreOrDateContainsIgnoreCase(@Param("titre") String titre,@Param("annee") String annee);


}
