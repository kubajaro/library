package com.crud.library.service;

import com.crud.library.entities.Reader;
import com.crud.library.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    public List<Reader> getAllReaders() {
        return (List<Reader>) readerRepository.findAll();
    }

    public Reader getReader(int id) throws Exception {
        return readerRepository.findById(id).orElseThrow(Exception::new);
    }

    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public void deleteReader(int id){
        readerRepository.deleteById(id);
    }
}
