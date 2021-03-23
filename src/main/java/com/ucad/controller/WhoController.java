package com.ucad.controller;



import com.ucad.dao.WhoRepository;


import com.ucad.entities.WebDocument;
import com.ucad.entities.Who;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@CrossOrigin
@RestController
public class WhoController {

    @Autowired
    WhoRepository  whoRepository;

    @GetMapping(value = "/imageOms/{id}",produces ={MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE,MediaType.APPLICATION_PDF_VALUE},consumes = MediaType.ALL_VALUE)
    public  byte[] images(@PathVariable(name = "id")String id) throws IOException {
        Who who =whoRepository.findById(id).get();
        File file= new File(System.getProperty("user.home")+"/alsocovid/images/"+who.getImg());
        Path path= Paths.get(file.toURI());
        //System.out.println("+++++++++++++++++ "+path);
        return Files.readAllBytes(path);

    }

    // http://localhost:8080/byFiltreWho?type=res&annee=2020
    @GetMapping(path = "/byFiltreWho")
    public List<Who> findByTitreContains(@RequestParam(required = false,name = "titre") String titre[] , @RequestParam(required = false,name = "annee") String annee[]) {
        List<Who>  res= new ArrayList<Who>();
        for (String a : annee) {
            for (String t : titre) {
                if(a!=null && t!=null)
                {
                    List<Who>  whos =  new ArrayList<>();
                    whos= whoRepository.findByTitreContainsIgnoreCaseAndDateContainsIgnoreCase(t,a);
                    res.addAll(whos);
                }
                else if(a!=null )
                {
                    List<Who>  whos =  new ArrayList<>();
                    whos = whoRepository.findByDateContainsIgnoreCase(a);
                    res.addAll(whos);
                }
                else
                {
                    List<Who>  whos =  new ArrayList<>();
                    whos= whoRepository.findByTitreContainsIgnoreCase(t);
                    res.addAll(whos);
                }

            }
        }
        return  res;
    }

    // Chemin d accees http://localhost:8080/byFiltreWhoAnnee?annee=2020
    @GetMapping(path = "/byFiltreWhoAnnee")
    public List<Who> findByAnneeContains(@RequestParam(required = false,name = "annee") String annee[]) {
        List<Who>  res= new ArrayList<Who>();
        for (String a : annee) {
            if(a!=null)
            {
                List<Who>  whos =  new ArrayList<>();
                whos= whoRepository.findByDateContainsIgnoreCase(a);
                res.addAll(whos);
            }
        }
        return  res;
    }

    // Chemin d'access  http://localhost:8080/byFiltreWhoTitre?type=articl
    @GetMapping(path = "/byFiltreWhoTitre")
    public List<Who> findByTitreContains(@RequestParam(required = false,name = "titre") String titre[]) {
        List<Who>  res= new ArrayList<Who>();
        for (String t : titre) {
            if(t!=null)
            {
                List<Who>  whos =  new ArrayList<>();
                whos= whoRepository.findByTitreContainsIgnoreCase(t);
                res.addAll(whos);
            }
        }
        return  res;
    }


}
