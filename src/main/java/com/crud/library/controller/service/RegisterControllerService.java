package com.crud.library.controller.service;

import com.crud.library.dto.RegisterDto;
import com.crud.library.entities.Copy;
import com.crud.library.entities.Reader;
import com.crud.library.entities.Register;
import com.crud.library.exception.ObjectNotFoundException;
import com.crud.library.mapper.RegisterMapper;
import com.crud.library.service.CopyService;
import com.crud.library.service.ReaderService;
import com.crud.library.service.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterControllerService {
    private final RegisterService registerService;
    private final CopyService copyService;
    private final ReaderService readerService;
    private final RegisterMapper registerMapper;

    public void createRegister(RegisterDto registerDto) throws ObjectNotFoundException {
        Copy copy = copyService.findById(registerDto.getCopyId());
        Reader reader = readerService.getReader(registerDto.getReaderId());
        Register register = registerMapper.mapToRegister(registerDto, copy, reader);
        registerService.saveRegister(register);
    }

    public RegisterDto returnBook(RegisterDto registerDto) throws ObjectNotFoundException {
        Copy copy = copyService.findById(registerDto.getCopyId());
        Reader reader = readerService.getReader(registerDto.getReaderId());
        Register register = registerMapper.mapToRegister(registerDto, copy, reader);
        Register savedRegister = registerService.saveRegister(register);
        return registerMapper.mapToRegisterDto(savedRegister);
    }
}
