package com.crud.library.mapper;

import com.crud.library.dto.ReaderDto;
import com.crud.library.entities.Reader;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReaderMapper {

    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getId(),
                readerDto.getName(),
                readerDto.getLastName(),
                readerDto.getJoiningDate()
        );
    }

    public ReaderDto mapToReaderDto(final Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getName(),
                reader.getLastName(),
                reader.getJoiningDate()
        );
    }

    public List<ReaderDto> mapToReaderDtoList(final List<Reader> readers) {
        return readers.stream()
                .map(this::mapToReaderDto)
                .collect(Collectors.toList());
    }
}
