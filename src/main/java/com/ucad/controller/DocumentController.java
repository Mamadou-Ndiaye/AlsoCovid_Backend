package com.ucad.controller;


import com.ucad.dao.WebDocumentRepository;

import com.ucad.entities.WebDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

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
public class DocumentController {
    @Autowired
    WebDocumentRepository webDocumentRepository;
    @Autowired
    MongoTemplate mongoTemplate;
//    @GetMapping(path = "/byRecherche")
//    public ResponseEntity<List<WebDocument>> searchForWebDocument(@SearchSpec Specification<WebDocument> specs) {
//        return new ResponseEntity(webDocumentRepository.findAll((Pageable) Specification.where(specs)), HttpStatus.OK);
//    }

    @GetMapping(path = "/byFiltre")
    public List<WebDocument> findByTitreContains(@RequestParam(required = false,name = "titre") String titre[]) {
        List<WebDocument>  res= new ArrayList<WebDocument>();
        for (String s : titre) {
            if(s!=null)
            {
                List<WebDocument>  webDoc =  new ArrayList<>();
                 webDoc= webDocumentRepository.findByTitreContainsIgnoreCase(s);
                 res.addAll(webDoc);
            }
        }
        return  res;
    }


/*

    @GetMapping(path = "/filtre")
    public List<WebDocument> filtre( @RequestParam (required = false,defaultValue = "") String titre[], @RequestParam (required = false,defaultValue = "") String maladie,Pageable pageable) {
        Page<WebDocument>  docMaladie =  webDocumentRepository.findByTitreContainsIgnoreCase(maladie,pageable);
        List<WebDocument> resultsdocMaladie;
        resultsdocMaladie=docMaladie.getContent();
       // Page<WebDocument>  docTitre =  webDocumentRepository.findByTitreContainsIgnoreCase(titre,pageable);
        List<WebDocument> resultsdocTitre;
       // resultsdocTitre=docTitre.getContent();

//        List<WebDocument> res =  Stream.concat(resultsdocMaladie.stream(), resultsdocTitre.stream())
                .collect(Collectors.toList());

//        ArrayList<WebDocument> resultsfinal = new ArrayList<>() ;
//        resultsfinal.add((WebDocument) resultsdocMaladie);

        return res;
       // @RequestParam (required = false,defaultValue = "") String annee
        // (List<WebDocument>) webDocumentRepository.findByTitreContainsIgnoreCase(titre,pageable);
    }
*/

    @GetMapping(value = "/imageWho/{id}",produces ={MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE,MediaType.APPLICATION_PDF_VALUE},consumes = MediaType.ALL_VALUE)
    public  byte[] images(@PathVariable(name = "id")String id) throws IOException {
        WebDocument webDocument =webDocumentRepository.findById(id).get();
        //String photoName=webDocument.getUrl();
        int a  =new Random().nextInt(webDocument.getImg().length); // nombre aleatoires sur le tableau d image que nous avons
        File file= new File(System.getProperty("user.home")+"/alsocovid/image/"+webDocument.getImg()[a]);
        Path path= Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }

    @GetMapping(path = "/maladies")
    public Page<WebDocument> listDocsByMaladie( @RequestParam (required = false,defaultValue = "maladie") String titre,Pageable pageable ){
        return webDocumentRepository.findAll(pageable);
    }


    @GetMapping(path = "/docs")
    public List<WebDocument> listDocument(){
        return webDocumentRepository.findAll();
    }

    @GetMapping(path = "/webDocumentOrderByCovid")
    public Page<WebDocument> listCovid(Pageable pageable)
     { return webDocumentRepository.findByOrderByConCovidDesc(pageable);}

    @GetMapping(path = "/webDocumentOrderByhistorique")
    public Page<WebDocument>  listhistorique(Pageable pageable)
    { return webDocumentRepository.findByOrderByHistSanitaireDesc(pageable);}

    @GetMapping(path = "/webDocumentOrderByEnvironnement")
    public Page<WebDocument>  listenvironnement(Pageable pageable)
    { return webDocumentRepository.findByOrderByEnvironnementDesc(pageable);}

    @GetMapping(path = "/webDocumentOrderByNutrition")
    public Page<WebDocument>  listNutrition(Pageable pageable)
    { return webDocumentRepository.findByOrderByNutritionDesc(pageable);}

    @GetMapping(path = "/webDocumentOrderByIdentite")
    public Page<WebDocument>  listIdentite(Pageable pageable)
    { return webDocumentRepository.findByOrderByIdentiteDesc(pageable);}

    @GetMapping(path = "/webDocumentOrderByObjet")
    public Page<WebDocument>  listObjet(Pageable pageable)
    { return webDocumentRepository.findByOrderByObjetDesc(pageable);}

    @RestResource(path = "/findbyTitre")
    public Page<WebDocument>  finfByTitre(@Param("titre") String titre, Pageable pageable)
    { return webDocumentRepository.findByTitreContainsIgnoreCase(titre,pageable);}
}

