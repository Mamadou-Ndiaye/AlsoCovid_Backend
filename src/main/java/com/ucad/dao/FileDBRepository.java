package com.ucad.dao;

import com.ucad.entities.FileDB;
import com.ucad.entities.Nature;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource
public interface FileDBRepository  extends MongoRepository<FileDB,String> {
}
