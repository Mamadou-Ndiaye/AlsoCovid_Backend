package com.ucad.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Lob;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FileDB {
    @Id
    private String id;

    private String name;

    private String type;
    @Lob
    private byte[] data;

}
