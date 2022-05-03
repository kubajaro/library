package com.crud.library.mapper;

import com.crud.library.dto.RegisterDto;
import com.crud.library.entities.Copy;
import com.crud.library.entities.Reader;
import com.crud.library.entities.Register;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegisterMapper {

    public Register mapToRegister(final RegisterDto registerDto, final Copy copy, final Reader reader) {
        return new Register(
                registerDto.getId(),
                copy,
                reader,
                registerDto.getBorrowDate(),
                registerDto.getReturnDate()
        );
    }

    public RegisterDto mapToRegisterDto(final Register register) {
        return new RegisterDto(
                register.getId(),
                register.getCopy().getId(),
                register.getReader().getId(),
                register.getBorrowDate(),
                register.getReturnDate()
        );
    }

    public List<RegisterDto> mapToRegisterDtoList(final List<Register> registers) {
        return registers.stream()
                .map(this::mapToRegisterDto)
                .collect(Collectors.toList());
    }
}
