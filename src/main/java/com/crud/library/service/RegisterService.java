package com.crud.library.service;

import com.crud.library.entities.Register;
import com.crud.library.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final RegisterRepository registerRepository;

    public Register saveRegister(Register register) {
        return registerRepository.save(register);
    }
}
