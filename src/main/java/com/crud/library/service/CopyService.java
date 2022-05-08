package com.crud.library.service;

import com.crud.library.entities.Book;
import com.crud.library.entities.Copy;
import com.crud.library.exception.ObjectNotFoundException;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.CopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.objenesis.ObjenesisException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CopyService {

    private final CopyRepository copyRepository;
    private final BookRepository bookRepository;

    public Copy saveCopy(Copy copy) {
        return copyRepository.save(copy);
    }

    public int numberCopiesOfBook(int bookId) throws ObjectNotFoundException {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ObjectNotFoundException(bookId));
        List<Copy> copiesOfBook = copyRepository.findAllByBook(book);
        return copiesOfBook.size();
    }

    public Copy findById(int id) throws ObjectNotFoundException {
        return copyRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
    }
}
