package com.ucad.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Article {
     // Article renvoie aux donnees que nous avons recuperer de Science Direct donc on pouvait le nommer ScienceDirect comme
    // les autres qui portent les informations de leurs site web exmple Nature et PlosOne
    @Id
    private  String id;
    private  String url;
    private  String type;
    private  String titre;
    private  String book;
    private  String date;
    private  String auteurs1;
    private  String auteurs2;
}
