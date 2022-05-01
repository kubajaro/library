package com.crud.library.mapper;

import com.crud.library.dto.BookDto;
import com.crud.library.entities.Book;

public class BookMapper {

    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublicationYear()
                );
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublicationYear()
        );
    }
}
