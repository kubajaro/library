package com.crud.library.repository;

import com.crud.library.entities.Register;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends CrudRepository<Register, Integer> {
}
