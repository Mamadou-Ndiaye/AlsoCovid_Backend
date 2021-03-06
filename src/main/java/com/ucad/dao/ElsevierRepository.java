package com.ucad.dao;

import com.ucad.entities.Elsevier;
import com.ucad.entities.PubMed;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource
public interface ElsevierRepository extends MongoRepository<Elsevier,String> {
    // Recuperer en fonction du titre
    @RestResource(path = "/byTitre")
    public List<Elsevier> findByTitreContainsIgnoreCase(@Param("titre") String titre);

    // Recuperer en fonction du date
    @RestResource(path = "/byDate")
    public List<Elsevier> findByDateContainsIgnoreCase(@Param("annee") String annee);

      // Recuperer en fonction du type
      @RestResource(path = "/byType")
      public List<Elsevier> findByTypeContainsIgnoreCase(@Param("type") String type);

      // Recuperer en fonction du type et de la date
      @RestResource(path = "/byTypeAndDate")
      public List<Elsevier> findByTypeContainsIgnoreCaseAndDateContainsIgnoreCase(@Param("type") String type,@Param("annee") String annee);

    // Recuperer en fonction du titre et du date Pour y acceder on peut mettre par exemple  http://localhost:8080/Natures/search/byDateAndTitre?titre=sars&&annee=2020
    @RestResource(path = "/byDateAndTitre")
    public List<PubMed> findByTitreContainsIgnoreCaseAndDateContainsIgnoreCase(@Param("titre") String titre,@Param("annee") String annee);

}
