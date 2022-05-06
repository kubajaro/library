package com.crud.library.controller;

import com.crud.library.dto.BookDto;
import com.crud.library.dto.CopyDto;
import com.crud.library.entities.Book;
import com.crud.library.entities.Copy;
import com.crud.library.mapper.BookMapper;
import com.crud.library.mapper.CopyMapper;
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
    private final CopyMapper copyMapper;
    private final BookMapper bookMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCopy(@RequestBody CopyDto copyDto, @RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        Copy copy = copyMapper.mapToCopy(copyDto, book);
        copyService.saveCopy(copy);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<CopyDto> changeCopyStatus(@RequestBody CopyDto copyDto, @RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        Copy copy = copyMapper.mapToCopy(copyDto, book);
        copyService.saveCopy(copy);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{bookDto}")
    public ResponseEntity<Integer> bookCopiesCount(@PathVariable BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        return ResponseEntity.ok(copyService.numberCopiesOfBook(book));
    }
}
