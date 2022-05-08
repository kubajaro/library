package com.crud.library.controller;

import com.crud.library.dto.RegisterDto;
import com.crud.library.entities.Copy;
import com.crud.library.entities.Reader;
import com.crud.library.entities.Register;
import com.crud.library.exception.ObjectNotFoundException;
import com.crud.library.mapper.RegisterMapper;
import com.crud.library.service.CopyService;
import com.crud.library.service.ReaderService;
import com.crud.library.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RegisterController {

    private final RegisterService registerService;
    private final CopyService copyService;
    private final ReaderService readerService;
    private final RegisterMapper registerMapper;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createRegister(@RequestBody RegisterDto registerDto) throws ObjectNotFoundException {
        Copy copy = copyService.findById(registerDto.getCopyId());
        Reader reader = readerService.getReader(registerDto.getReaderId());
        Register register = registerMapper.mapToRegister(registerDto, copy, reader);

        registerService.saveRegister(register);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<RegisterDto> returnBook(@RequestBody RegisterDto registerDto) throws ObjectNotFoundException {
        Copy copy = copyService.findById(registerDto.getCopyId());
        Reader reader = readerService.getReader(registerDto.getReaderId());
        Register register = registerMapper.mapToRegister(registerDto, copy, reader);

        Register savedRegister = registerService.saveRegister(register);

        return ResponseEntity.ok(registerMapper.mapToRegisterDto(savedRegister));
    }
}
