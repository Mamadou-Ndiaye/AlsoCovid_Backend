package com.ucad.dao;

import com.ucad.entities.Utilisateur;
import com.ucad.entities.WebDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import java.util.List;

@CrossOrigin
@RestController
public class DocumentController {
    @Autowired
    WebDocumentRepository  webDocumentRepository;
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
}

