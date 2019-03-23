package com.ttn.springboot.entity;

import com.ttn.springboot.repository.StudentRepository;
import com.ttn.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class Bootstrap {
// Q6...Bootstrap Data for Student Domain (3 Marks)
    @Autowired
    StudentRepository studentRepository;
    @EventListener(ApplicationStartedEvent.class)
    public void init()
    {
        Iterator<Student> bookIterable = studentRepository.findAll().iterator();
        if (!bookIterable.hasNext()) {
            for (int i = 1; i <= 10; i++) {
                Student book = new Student(i, "Book " + i,10.0f);
                studentRepository.save(book);
                System.out.println("Book " + i + " created");
            }
        }
        System.out.println("Your Application is up and running");
    }
}
