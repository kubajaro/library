package com.crud.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CopyDto {
    private int id;
    private String bookTitle;
    private String author;
    private int bookId;
    private String status;
}
