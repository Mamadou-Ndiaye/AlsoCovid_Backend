package com.ucad.controller;


import com.ucad.dao.ElsevierRepository;
import com.ucad.entities.Elsevier;
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
public class ElsevierController {
    @Autowired
    ElsevierRepository elsevierRepository;
    //On a 3 cas soit on coche sur Annee et Type ,soit on coche sur type simplement ,soit on coche sur annee

    // http://localhost:8080/byFiltreElsevier?type=res&annee=2020
    @GetMapping(path = "/byFiltreElsevier")
    public List<Elsevier> findByTitreContains(@RequestParam(required = false,name = "type") String type[] , @RequestParam(required = false,name = "annee") String annee[]) {
        List<Elsevier>  res= new ArrayList<Elsevier>();
        for (String a : annee) {
            for (String t : type) {
                if(a!=null && t!=null)
                {
                    List<Elsevier>  elseviers =  new ArrayList<>();
                    elseviers= elsevierRepository.findByTypeContainsIgnoreCaseAndDateContainsIgnoreCase(t,a);
                    res.addAll(elseviers);
                }
                else if(a!=null )
                {
                    List<Elsevier>  elseviers =  new ArrayList<>();
                    elseviers = elsevierRepository.findByDateContainsIgnoreCase(a);
                    res.addAll(elseviers);
                }
                else
                {
                    List<Elsevier>  elseviers =  new ArrayList<>();
                    elseviers= elsevierRepository.findByTypeContainsIgnoreCase(t);
                    res.addAll(elseviers);
                }

            }
        }
        return  res;
    }

    // Chemin d accees http://localhost:8080/byFiltreElsevierAnnee?annee=2020
    @GetMapping(path = "/byFiltreElsevierAnnee")
    public List<Elsevier> findByAnneeContains(@RequestParam(required = false,name = "annee") String annee[]) {
        List<Elsevier>  res= new ArrayList<Elsevier>();
        for (String a : annee) {
            if(a!=null)
            {
                List<Elsevier>  elseviers =  new ArrayList<>();
                elseviers= elsevierRepository.findByDateContainsIgnoreCase(a);
                res.addAll(elseviers);
            }
        }
        return  res;
    }

    // Chemin d'access  http://localhost:8080/byFiltreElsevierType?type=articl
    @GetMapping(path = "/byFiltreElsevierType")
    public List<Elsevier> findByTypeContains(@RequestParam(required = false,name = "type") String type[]) {
        List<Elsevier>  res= new ArrayList<Elsevier>();
        for (String t : type) {
            if(t!=null)
            {
                List<Elsevier>  elseviers =  new ArrayList<>();
                elseviers= elsevierRepository.findByTypeContainsIgnoreCase(t);
                res.addAll(elseviers);
            }
        }
        return  res;
    }

}
