package com.ucad.controller;


import com.ucad.dao.ArticleRepository;
import com.ucad.entities.Article;
import com.ucad.entities.WebDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;


    // http://localhost:8080/byFiltreArticle?type=res&annee=2020
    @GetMapping(path = "/byFiltreArticle")
    public List<Article> findByTitreContains(@RequestParam(required = false,name = "type") String type[] , @RequestParam(required = false,name = "annee") String annee[]) {
        List<Article>  res= new ArrayList<Article>();
        for (String a : annee) {
            for (String t : type) {
                if(a!=null && t!=null)
                {
                    List<Article>  article =  new ArrayList<>();
                    article= articleRepository.findByTypeContainsIgnoreCaseAndDateContainsIgnoreCase(t,a);
                    res.addAll(article);
                }
                else if(a!=null )
                {
                    List<Article>  article =  new ArrayList<>();
                    article= articleRepository.findByDateContainsIgnoreCase(a);
                    res.addAll(article);
                }
                else
                {
                    List<Article>  article =  new ArrayList<>();
                    article= articleRepository.findByTypeContainsIgnoreCase(t);
                    res.addAll(article);
                }

            }
        }
        return  res;
    }

   // Chemin d accees http://localhost:8080/byFiltreAnnee?annee=2020
    @GetMapping(path = "/byFiltreAnnee")
    public List<Article> findByAnneeContains(@RequestParam(required = false,name = "annee") String annee[]) {
        List<Article>  res= new ArrayList<Article>();
        for (String s : annee) {
            if(s!=null)
            {
                List<Article>  article =  new ArrayList<>();
                article= articleRepository.findByDateContainsIgnoreCase(s);
                res.addAll(article);
            }
        }
        return  res;
    }

   // Chemin d'access  http://localhost:8080/byFiltreType?type=articl
    @GetMapping(path = "/byFiltreType")
    public List<Article> findByTypeContains(@RequestParam(required = false,name = "type") String type[]) {
        List<Article>  res= new ArrayList<Article>();
        for (String s : type) {
            if(s!=null)
            {
                List<Article>  article =  new ArrayList<>();
                article= articleRepository.findByTypeContainsIgnoreCase(s);
                res.addAll(article);
            }
        }
        return  res;
    }


}
