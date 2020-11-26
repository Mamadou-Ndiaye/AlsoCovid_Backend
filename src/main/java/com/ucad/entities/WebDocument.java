package com.ucad.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WebDocument {
    @Id
    private  String id;
    private  String url;
    private  String langue;
    private  String titre;
    private  String resume;
    private  String[][] bodySpacy;
    private  double environnement;
    private  double  connaissance_covid;
    private  double identite;
    private  double objet;
    private  double historique_sanitaire;
    private  double nutrition;
    private  String[] img;
    private  String[] videos;
    private  String[] pdf;


}
