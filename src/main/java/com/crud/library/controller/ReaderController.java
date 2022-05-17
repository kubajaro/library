package com.crud.library.controller;

import com.crud.library.controller.service.ReaderControllerService;
import com.crud.library.dto.ReaderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reader")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ReaderController {

    private final ReaderControllerService readerControllerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createReader(@RequestBody ReaderDto readerDto) {
       readerControllerService.createReader(readerDto);
        return ResponseEntity.ok().build();
    }
}
