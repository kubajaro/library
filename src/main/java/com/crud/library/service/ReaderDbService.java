package com.crud.library.service;

import com.crud.library.entities.Reader;
import com.crud.library.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReaderDbService {

    private final ReaderRepository readerRepository;

    public List<Reader> getAllReaders() {
        return (List<Reader>) readerRepository.findAll();
    }

    public Optional<Reader> getReader(int id) {
        return readerRepository.findById(id);
    }

    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public void deleteReader(int id) {
        readerRepository.deleteById(id);
    }
}
