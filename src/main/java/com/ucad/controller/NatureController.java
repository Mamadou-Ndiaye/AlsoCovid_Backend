package com.ucad.controller;


import com.ucad.dao.NatureRepository;
import com.ucad.entities.Article;
import com.ucad.entities.Nature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class NatureController {
    @Autowired
    NatureRepository natureRepository;

    // http://localhost:8080/byFiltreNature?type=res&annee=2020
    @GetMapping(path = "/byFiltreNature")
    public List<Nature> findByTitreContains(@RequestParam(required = false,name = "type") String type[] , @RequestParam(required = false,name = "annee") String annee[]) {
        List<Nature>  res= new ArrayList<Nature>();
        for (String a : annee) {
            for (String t : type) {
                if(a!=null && t!=null)
                {
                    List<Nature>  natures =  new ArrayList<>();
                    natures= natureRepository.findByTypeContainsIgnoreCaseAndDateContainsIgnoreCase(t,a);
                    res.addAll(natures);
                }
                else if(a!=null )
                {
                    List<Nature>  natures =  new ArrayList<>();
                     natures = natureRepository.findByDateContainsIgnoreCase(a);
                    res.addAll(natures);
                }
                else
                {
                    List<Nature>  natures =  new ArrayList<>();
                    natures= natureRepository.findByTypeContainsIgnoreCase(t);
                    res.addAll(natures);
                }

            }
        }
        return  res;
    }

    // Chemin d accees http://localhost:8080/byFiltreNatureAnnee?annee=2020
    @GetMapping(path = "/byFiltreNatureAnnee")
    public List<Nature> findByAnneeContains(@RequestParam(required = false,name = "annee") String annee[]) {
        List<Nature>  res= new ArrayList<Nature>();
        for (String a : annee) {
            if(a!=null)
            {
                List<Nature>  nature =  new ArrayList<>();
                nature= natureRepository.findByDateContainsIgnoreCase(a);
                res.addAll(nature);
            }
        }
        return  res;
    }

    // Chemin d'access  http://localhost:8080/byFiltreNatureType?type=articl
    @GetMapping(path = "/byFiltreNatureType")
    public List<Nature> findByTypeContains(@RequestParam(required = false,name = "type") String type[]) {
        List<Nature>  res= new ArrayList<Nature>();
        for (String t : type) {
            if(t!=null)
            {
                List<Nature>  nature =  new ArrayList<>();
                nature= natureRepository.findByTypeContainsIgnoreCase(t);
                res.addAll(nature);
            }
        }
        return  res;
    }

}
