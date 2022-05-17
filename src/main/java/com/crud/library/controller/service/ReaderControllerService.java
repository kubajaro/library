package com.crud.library.controller.service;

import com.crud.library.dto.ReaderDto;
import com.crud.library.entities.Reader;
import com.crud.library.mapper.ReaderMapper;
import com.crud.library.service.ReaderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReaderControllerService {
    private final ReaderService readerService;
    private final ReaderMapper readerMapper;

    public void createReader(ReaderDto readerDto) {
        Reader reader = readerMapper.mapToReader(readerDto);
        readerService.saveReader(reader);
    }
}
