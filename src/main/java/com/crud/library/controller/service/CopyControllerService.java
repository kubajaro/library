package com.crud.library.controller.service;

import com.crud.library.dto.CopyDto;
import com.crud.library.entities.Book;
import com.crud.library.entities.Copy;
import com.crud.library.exception.ObjectNotFoundException;
import com.crud.library.mapper.CopyMapper;
import com.crud.library.service.BookService;
import com.crud.library.service.CopyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CopyControllerService {
    private final CopyService copyService;
    private final BookService bookService;
    private final CopyMapper copyMapper;

    public Copy createOrSaveCopy(CopyDto copyDto) throws ObjectNotFoundException {
        Book book = bookService.findById(copyDto.getBookId());
        Copy copy = copyMapper.mapToCopy(copyDto, book);
        return copy;
    }

    public Integer countCopies(int bookId) throws ObjectNotFoundException {
        return copyService.numberCopiesOfBook(bookId);
    }
}
