package com.crud.library.controller;

import com.crud.library.dto.BookDto;
import com.crud.library.dto.CopyDto;
import com.crud.library.entities.Book;
import com.crud.library.entities.Copy;
import com.crud.library.exception.ObjectNotFoundException;
import com.crud.library.mapper.BookMapper;
import com.crud.library.mapper.CopyMapper;
import com.crud.library.service.BookService;
import com.crud.library.service.CopyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/copy")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CopyController {

    private final CopyService copyService;
    private final BookService bookService;
    private final CopyMapper copyMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCopy(@RequestBody CopyDto copyDto) throws ObjectNotFoundException {
        Book book = bookService.findById(copyDto.getBookId());
        Copy copy = copyMapper.mapToCopy(copyDto, book);
        copyService.saveCopy(copy);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<CopyDto> changeCopyStatus(@RequestBody CopyDto copyDto) throws ObjectNotFoundException {
        Book book = bookService.findById(copyDto.getBookId());
        Copy copy = copyMapper.mapToCopy(copyDto, book);
        copyService.saveCopy(copy);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{bookId}")
    public ResponseEntity<Integer> bookCopiesCount(@PathVariable int bookId) throws ObjectNotFoundException {
        return ResponseEntity.ok(copyService.numberCopiesOfBook(bookId));
    }
}
