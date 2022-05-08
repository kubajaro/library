package com.crud.library.service;

import com.crud.library.entities.Reader;
import com.crud.library.exception.ObjectNotFoundException;
import com.crud.library.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    public Reader getReader(int id) throws ObjectNotFoundException {
        return readerRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }
}
