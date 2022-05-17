package com.crud.library.controller;

import com.crud.library.controller.service.CopyControllerService;
import com.crud.library.dto.CopyDto;
import com.crud.library.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/copy")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CopyController {

    public final CopyControllerService copyControllerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCopy(@RequestBody CopyDto copyDto) throws ObjectNotFoundException {
        copyControllerService.createOrSaveCopy(copyDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<CopyDto> changeCopyStatus(@RequestBody CopyDto copyDto) throws ObjectNotFoundException {
        copyControllerService.createOrSaveCopy(copyDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{bookId}")
    public ResponseEntity<Integer> bookCopiesCount(@PathVariable int bookId) throws ObjectNotFoundException {
        return ResponseEntity.ok(copyControllerService.countCopies(bookId));
    }
}
