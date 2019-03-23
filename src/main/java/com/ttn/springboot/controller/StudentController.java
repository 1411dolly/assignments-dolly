package com.ttn.springboot.controller;

import com.ttn.springboot.entity.Student;
import com.ttn.springboot.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    Logger logger = LoggerFactory.getLogger(StudentController.class);
//Q1...Create a Restful API using Spring Boot for Student.
    @GetMapping("/studentlist")
    public List<Student> getBooks(){
        logger.info("INFO: list student");
        return studentService.getBooks();
    }

    @GetMapping("/view")
    public String getIndex()
    {
        return "index";
    }


}
