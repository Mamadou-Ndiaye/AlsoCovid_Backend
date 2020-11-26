package com.ucad;


import com.ucad.dao.UtilisateurRepository;
import com.ucad.dao.WebDocumentRepository;
import com.ucad.entities.Utilisateur;

import com.ucad.entities.WebDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ScrawlingpresentationApplication {
    String[] profile= new String[0];

    public static void main(String[] args) {
        SpringApplication.run(ScrawlingpresentationApplication.class, args);
    }
   @Autowired
   UtilisateurRepository utilisateurRepository;
   @Bean
    CommandLineRunner start(WebDocumentRepository webDocumentRepository){
        return args -> {
          //  utilisateurRepository.save(new Utilisateur(null,"mamadou","openopen",false,null));
            //utilisateurRepository.save(new Utilisateur(null,"chimi","1234",false,null));
            //utilisateurRepository.save(new Utilisateur(null,"einstein","einstein",false,null));
         //  webDocumentRepository.save( new WebDocument(null,"https://www.afro.who.int/health-topics/coronavirus-covid-19","english","Coronavirus",
               //   "Even before the first confirmed case of COVID-19",null,0.0,0.0,0.0,0.0,0.0,0.0,null,null,null));

            System.out.print("Hello world");
        };
   }

}
