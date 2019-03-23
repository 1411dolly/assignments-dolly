package com.ttn.springboot.service;

import com.ttn.springboot.entity.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getBooks(){
        return Arrays.asList(new Student(1,"dolly",10),new Student(2,"student",9),new Student(3,"last_student",8));
    }
}
