package com.crud.library.controller;

import com.crud.library.controller.service.BookControllerService;
import com.crud.library.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin("*")
public class BookController {

    private final BookControllerService bookControllerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createBook(@RequestBody BookDto bookDto) {
        bookControllerService.createBook(bookDto);
        return ResponseEntity.ok().build();
    }
}
