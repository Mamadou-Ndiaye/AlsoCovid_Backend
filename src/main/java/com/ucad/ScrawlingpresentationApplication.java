package com.ucad;


import com.ucad.dao.*;
import com.ucad.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication

public class ScrawlingpresentationApplication {
    String[] profile= new String[0];

    public static void main(String[] args) {
        SpringApplication.run(ScrawlingpresentationApplication.class, args);
    }



   @Autowired
   UtilisateurRepository utilisateurRepository;

    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    NatureRepository natureRepository;

    @Autowired
    PlosOneRepository plosOneRepository;

   @Bean
    CommandLineRunner start(WebDocumentRepository webDocumentRepository){
       repositoryRestConfiguration.exposeIdsFor(WebDocument.class);
        return args -> {
          //  utilisateurRepository.save(new Utilisateur(null,"mamadou","openopen",false,null));
            //utilisateurRepository.save(new Utilisateur(null,"chimi","1234",false,null));
            //utilisateurRepository.save(new Utilisateur(null,"einstein","einstein",false,null));
         // webDocumentRepository.save( new WebDocument(null,"https://www.afro.who.int/health-topics/coronavirus-covid-19","english","Coronavirus",
           //      "Even before the first confirmed case of COVID-19",null,0.0,0.0,0.0,0.0,0.0,0.0,null,null,null));
            // articleRepository.save(new Article(null,null,null,null,null,null,null));
            //plosOneRepository.save(new PlosOne(null,null,null,null,null,null));
            System.out.print("Hello world");
        };
   }



}
