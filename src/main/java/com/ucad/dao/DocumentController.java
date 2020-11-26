package com.ucad.dao;

import com.ucad.entities.Utilisateur;
import com.ucad.entities.WebDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

