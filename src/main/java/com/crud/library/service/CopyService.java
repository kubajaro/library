package com.crud.library.service;

import com.crud.library.entities.Book;
import com.crud.library.entities.Copy;
import com.crud.library.repository.CopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CopyService {

    private final CopyRepository copyRepository;

    public Copy saveCopy(Copy copy) {
        return copyRepository.save(copy);
    }

    public int numberCopiesOfBook(Book book) {
        List<Copy> copiesOfBook = copyRepository.findAllByBook(book);
        return copiesOfBook.size();
    }

    public Copy findById(int id) throws Exception{
        return copyRepository.findById(id).orElseThrow(Exception::new);
    }
}
