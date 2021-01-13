package com.ucad.controller;


import com.ucad.dao.PlosOneRepository;
import com.ucad.entities.Nature;
import com.ucad.entities.PlosOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class PlosOneController {

    @Autowired
    PlosOneRepository plosOneRepository;

    // http://localhost:8080/byFiltrePlosOne?type=res&annee=2020
    @GetMapping(path = "/byFiltrePlosOne")
    public List<PlosOne> findByTitreContains(@RequestParam(required = false,name = "type") String type[] , @RequestParam(required = false,name = "annee") String annee[]) {
        List<PlosOne>  res= new ArrayList<PlosOne>();
        for (String a : annee) {
            for (String t : type) {
                if(a!=null && t!=null)
                {
                    List<PlosOne>  plosOnes =  new ArrayList<>();
                    plosOnes= plosOneRepository.findByTypeContainsIgnoreCaseAndDateContainsIgnoreCase(t,a);
                    res.addAll(plosOnes);
                }
                else if(a!=null )
                {
                    List<PlosOne>  plosOnes =  new ArrayList<>();
                    plosOnes = plosOneRepository.findByDateContainsIgnoreCase(a);
                    res.addAll(plosOnes);
                }
                else
                {
                    List<PlosOne>  plosOnes =  new ArrayList<>();
                    plosOnes= plosOneRepository.findByTypeContainsIgnoreCase(t);
                    res.addAll(plosOnes);
                }

            }
        }
        return  res;
    }


    // Chemin d accees http://localhost:8080/byFiltrePloseOneAnnee?annee=2020
    @GetMapping(path = "/byFiltrePlosOneAnnee")
    public List<PlosOne> findByAnneeContains(@RequestParam(required = false,name = "annee") String annee[]) {
        List<PlosOne>  res= new ArrayList<PlosOne>();
        for (String a : annee) {
            if(a!=null)
            {
                List<PlosOne>  plosOne =  new ArrayList<>();
                plosOne= plosOneRepository.findByDateContainsIgnoreCase(a);
                res.addAll(plosOne);
            }
        }
        return  res;
    }

    // Chemin d'access  http://localhost:8080/byFiltrePlosOneType?type=articl
    @GetMapping(path = "/byFiltrePlosOneType")
    public List<PlosOne> findByTypeContains(@RequestParam(required = false,name = "type") String type[]) {
        List<PlosOne>  res= new ArrayList<PlosOne>();
        for (String t : type) {
            if(t!=null)
            {
                List<PlosOne>  plosOne =  new ArrayList<>();
                plosOne= plosOneRepository.findByTypeContainsIgnoreCase(t);
                res.addAll(plosOne);
            }
        }
        return  res;
    }
}

