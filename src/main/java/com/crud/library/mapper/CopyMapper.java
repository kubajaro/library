package com.crud.library.mapper;

import com.crud.library.dto.CopyDto;
import com.crud.library.entities.Book;
import com.crud.library.entities.Copy;
import com.crud.library.enumvalues.CopyStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CopyMapper {

    public Copy mapToCopy(final CopyDto copyDto, final Book book) {
        String copyStatus = copyDto.getStatus().toString();
       return new Copy(
               copyDto.getId(),
               book,
               copyStatus
               );
    }

    public CopyDto mapToCopyDto(final Copy copy) {
        CopyStatus copyStatus = CopyStatus.valueOf(copy.getStatus());
        return new CopyDto(
                copy.getId(),
                copy.getBook().getId(),
                copyStatus
        );
    }

    public List<CopyDto> mapToCopyDtoList(final List<Copy> copies) {
        return copies.stream().
                map(this::mapToCopyDto)
                .collect(Collectors.toList());
    }
}
