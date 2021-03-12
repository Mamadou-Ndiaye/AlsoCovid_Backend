package com.ucad.controller;


import com.ucad.dao.PubMedRepository;
import com.ucad.entities.PubMed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class PubMedController {

    @Autowired
    PubMedRepository pubMedRepository;

    // Chemin d accees http://localhost:8080/byFiltrePubMedAnnee?annee=2020
    @GetMapping(path = "/byFiltrePubMedAnnee")
    public List<PubMed> findByAnneeContains(@RequestParam(required = false,name = "annee") String annee[]) {
        List<PubMed>  res= new ArrayList<PubMed>();
        for (String a : annee) {
            if(a!=null)
            {
                List<PubMed>  pubMeds =  new ArrayList<>();
                pubMeds= pubMedRepository.findByDateContainsIgnoreCase(a);
                res.addAll(pubMeds);
            }
        }
        return  res;
    }

}
