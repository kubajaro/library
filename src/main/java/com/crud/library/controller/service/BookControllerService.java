package com.crud.library.controller.service;

import com.crud.library.dto.BookDto;
import com.crud.library.entities.Book;
import com.crud.library.mapper.BookMapper;
import com.crud.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookControllerService {
    private final BookService service;
    private final BookMapper bookMapper;

    public Book createBook(BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        return service.saveBook(book);

    }
}
