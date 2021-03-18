package com.ucad.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PubMed {
    @Id
    private  String id;
    private  String url;
    // private  String type;
    private  String titre;
    private  String date;
    private  String auteurs;
}

