package com.crud.library.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "book")
public class Book {

    @Id
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "publication_year")
    private Date publicationYear;
}
