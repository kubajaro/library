package com.crud.library.controller;

import com.crud.library.controller.service.RegisterControllerService;
import com.crud.library.dto.RegisterDto;
import com.crud.library.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RegisterController {

    private final RegisterControllerService registerControllerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createRegister(@RequestBody RegisterDto registerDto) throws ObjectNotFoundException {
        registerControllerService.createRegister(registerDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<RegisterDto> returnBook(@RequestBody RegisterDto registerDto) throws ObjectNotFoundException {
        return ResponseEntity.ok(registerControllerService.returnBook(registerDto));
    }
}
