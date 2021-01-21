package com.ucad.controller;

import com.sipios.springsearch.anotation.SearchSpec;
import com.ucad.dao.WebDocumentRepository;
import com.ucad.entities.Utilisateur;
import com.ucad.entities.WebDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;


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

