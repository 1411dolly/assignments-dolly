package com.spring.rest.springrest.services;

import com.spring.rest.springrest.entities.Student;
import com.spring.rest.springrest.entities.User;
import com.spring.rest.springrest.repositories.StudentRepository;
import com.spring.rest.springrest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllUsers(){
        return (List<Student>)studentRepository.findAll();
    }

    public Student getUserById(Long id){
        Optional<Student> optional=studentRepository.findById(id);
        return optional.isPresent() ? optional.get(): null;
    }


    public void saveStudent(Student student){
        studentRepository.save(student);
    }


    public void deleteStudent(Student student){
        studentRepository.delete(student);
    }
}
