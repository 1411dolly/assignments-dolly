package com.spring.rest.springrest.events;

import com.spring.rest.springrest.entities.Student;
import com.spring.rest.springrest.entities.User;
import com.spring.rest.springrest.repositories.StudentRepository;
import com.spring.rest.springrest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;
@Component
public class BootstrapStudent
{
    @Autowired
    StudentRepository studentRepository;

    @EventListener(ContextRefreshedEvent.class)
    void setUp(){

        if(!studentRepository.findAll().iterator().hasNext()) {
            IntStream.range(0, 10).forEach(e -> {
                Student student=new Student();
                student.setAge(20 + e);
                student.setName("name" + e);
                student.setStandard("standard" + e);
                student.setCity("city" + e);
                student.setPercentage(100f+e);
                studentRepository.save(student);
            });
        }
    }

}
