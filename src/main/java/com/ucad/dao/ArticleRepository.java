package com.ucad.dao;

import com.ucad.entities.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin
@RepositoryRestResource
public interface ArticleRepository  extends MongoRepository<Article,String> {

}
