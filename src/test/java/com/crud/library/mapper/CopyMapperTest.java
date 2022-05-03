package com.crud.library.mapper;

import com.crud.library.dto.CopyDto;
import com.crud.library.entities.Book;
import com.crud.library.entities.Copy;
import com.crud.library.enumvalues.CopyStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CopyMapperTest {

    @Autowired
    CopyMapper copyMapper;

    @Test
    void mapToCopy() {
        //given
        CopyDto copyDto = new CopyDto(1, "A", "A", 1, "AVAILABLE");
        Book book = new Book(1, "A","A", 1992);

        //when
        Copy result = copyMapper.mapToCopy(copyDto, book);

        //then
        assertEquals(book, result.getBook());
        assertEquals(copyDto.getStatus(), CopyStatus.AVAILABLE.toString());
    }

    @Test
    void mapToCopyDto() {
        //given
        Book book = new Book(1, "A","A", 1992);
        Copy copy = new Copy(1, book, CopyStatus.AVAILABLE);

        //when
        CopyDto result = copyMapper.mapToCopyDto(copy);

        //then
        assertEquals(copy.getStatus().toString(), result.getStatus());
        assertEquals(book.getTitle(), result.getBookTitle());
    }

    @Test
    void mapToCopyDtoList() {
        //given
        List<Copy> copies = new ArrayList<>();
        Book book = new Book(1, "A","A", 1992);
        Book book2 = new Book(2, "B","C", 1991);
        copies.add(new Copy(1, book, CopyStatus.AVAILABLE));
        copies.add(new Copy(2, book2, CopyStatus.BORROWED));

        //when
        List<CopyDto> result = copyMapper.mapToCopyDtoList(copies);

        //then
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getBookId());
    }
}