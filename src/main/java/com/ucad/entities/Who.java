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
public class Who {
    @Id
    private  String id;
    private  String url;
    private  String titre;
    private  String resume;
    private  String img;
    private  String date;
   /* private  String[][] bodySpacy;
    private  String langue;
    private  double environnement;
    public   double  conCovid;
    private  double identite;
    private  double objet;
    private  double histSanitaire;
    private  double nutrition;*/
    /*private  String[] videos;
    private  String[] pdf;*/


}
