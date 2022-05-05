package com.crud.library.repository;

import com.crud.library.entities.Book;
import com.crud.library.entities.Copy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopyRepository extends CrudRepository<Copy, Integer> {
    public List<Copy> findAllByBook(Book book);
}
