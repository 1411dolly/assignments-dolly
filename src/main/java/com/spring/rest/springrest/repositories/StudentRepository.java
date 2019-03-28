package com.spring.rest.springrest.repositories;

import com.spring.rest.springrest.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
}
