package com.crud.library.service;

import com.crud.library.entities.Book;
import com.crud.library.exception.ObjectNotFoundException;
import com.crud.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book findById(int bookId) throws ObjectNotFoundException {
        return bookRepository.findById(bookId).orElseThrow(() -> new ObjectNotFoundException(bookId));
    }
}
