package com.ucad.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(types =  {WebDocument.class }, name = "customWebDocument")
public interface DocumentProject {
    String getUrl();
    String getImg();
    String getVideos();
    String getNutrition();
    String getHistorique_sanitaire();
    String getIdentite();
    String getObjet();
    String getTitre();
    String getLangue();
    String getResume();
    String getConnaissance_covid();
    String getEnvironnement();

}
