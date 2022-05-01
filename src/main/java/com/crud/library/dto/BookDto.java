package com.crud.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private int id;
    private String title;
    private String author;
    private Date publicationDate;
}
