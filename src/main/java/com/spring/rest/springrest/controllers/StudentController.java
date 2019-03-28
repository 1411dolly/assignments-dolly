package com.spring.rest.springrest.controllers;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.spring.rest.springrest.entities.Post;
import com.spring.rest.springrest.entities.Student;
import com.spring.rest.springrest.entities.StudentV2;
import com.spring.rest.springrest.entities.User;
import com.spring.rest.springrest.expections.UserNotFoundException;
import com.spring.rest.springrest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
//Q1...Create a Rest API for Student using noun plurals for endpoint and http verbs for different operations.(1 Mark)
    @GetMapping("/students")
    List<Student> getStudents(){
        return studentService.getAllUsers();
    }

    @GetMapping("/students/{id}")
    Student getStudentById(@PathVariable Long id){
        return studentService.getUserById(id);
    }

    //Q2...Create a Customise Exception Handler.(1 Mark)
    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable Long id){
        Student student=studentService.getUserById(id);
        if(student==null) {
            throw new UserNotFoundException("User not found");
        }
        studentService.deleteStudent(student);
    }

//Q3...Print the Validation Messages of student Entity in response.(1 Mark)
    @PostMapping("/students")
    ResponseEntity<Student> saveStudent( @Valid @RequestBody Student student){
        studentService.saveStudent(student);
        URI uri= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}").buildAndExpand(student.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

//Q4...Perform Internationalization for a greeting message in your app.(1 Mark)
    @Autowired
    MessageSource messageSource;
//
//    @GetMapping("/hello")
//    String helloWorld(@RequestHeader(name = "Accept-Language",required = false)Locale locale){
//        System.out.println("hello world");
//        System.out.println(locale.getLanguage());
//        return messageSource.getMessage("good.morning.message",null,locale);
//    }
//
//    @GetMapping("/")
//    String helloWorld(){
//        System.out.println("hello world");
//        System.out.println(LocaleContextHolder.getLocale());
//        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
//
//    }


//Q5...Return XML Response when new Student is created.(1 Mark)
    //in build gradle

//Q6...Ignore ID field in the Response.(1 Mark)
//static->    in entity
//dynamic->

//
//    @GetMapping("/student")
//    MappingJacksonValue getEmployee(){
//        Student student=new Student("dolly","st",21,"delhi",12f);
//        SimpleBeanPropertyFilter simpleBeanPropertyFilter= SimpleBeanPropertyFilter.filterOutAllExcept("name","standard","city","age","percentage","city");
//        FilterProvider filterProvider=new SimpleFilterProvider().addFilter("myFilter",simpleBeanPropertyFilter);
//        MappingJacksonValue mappingJacksonValue= new MappingJacksonValue(student);
//        mappingJacksonValue.setFilters(filterProvider);
//        return mappingJacksonValue;
//    }


//Q7...Create 2 versions of your API one take reprsent name of the Student as single string and other showing firstname and lastname seperately.
// (Create the Versions of the API using URI, parameter and header versioning) (2 Marks)

        //URI versioning

    @GetMapping("/student/V1")
    Student getStudentV1() {
        return new Student("dolly","st",21,"delhi",12f);
    }

    @GetMapping("/student/V2")
    StudentV2 getStudentV2() {
        return new StudentV2("dolly","thakur","st",21,"delhi",12f);
    }

//    Parameter Versioning

    @GetMapping(value = "/student/param",params = "version=1")
    Student getStudentV1param() {
        return new Student("dolly","st",21,"delhi",12f);
    }

    @GetMapping(value = "/student/param",params = "version=2")
    StudentV2 getStudentV2version() {
        return new StudentV2("dolly","thakur","st",21,"delhi",12f);
    }

    //header versioning

    @GetMapping(value = "/student/header",headers = "API-VERSION=1")
    Student getStudentHeader1() {
        return new Student("dolly","st",21,"delhi",12f);
    }


    @GetMapping(value = "/student/header",headers = "API-VERSION=2")
    StudentV2 getStudentHeader2() {
        return new StudentV2("dolly","thakur","st",21,"delhi",12f);
    }

    @GetMapping(value = "/student/produces",produces = "application/app-v1+json")
    Student getStudentProducer1() {
        return new Student("dolly","st",21,"delhi",12f);
    }

    @GetMapping(value = "/student/produces",produces = "application/app-v2+json")
    StudentV2 getStudentProducer2() {
        return new StudentV2("dolly","thakur","st",21,"delhi",12f);
    }

//Q8...Perform CRUD operations on the resource below using   RestTemplate  https://jsonplaceholder.typicode.com/posts   (2 Marks)
    //create post
    @PostMapping("/createPost")
    public ResponseEntity<Post> createPost(){
        String url="https://jsonplaceholder.typicode.com/posts";
        RestTemplate restTemplate= new RestTemplate();
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("Content-type","application/json; charset=UTF-8");
        HttpEntity<Post> request=new HttpEntity<>(new Post(15,15,"title1","description1"),httpHeaders);
        Post post=restTemplate.postForObject(url,request,Post.class);
        System.out.println(post);
        return new ResponseEntity<Post>(post, HttpStatus.CREATED);
    }

    //read post with id
    @GetMapping("/readPost/{id}")
    public Post getPost(@PathVariable int id){
        RestTemplate restTemplate = new RestTemplate();
        String url="https://jsonplaceholder.typicode.com/posts/"+id;
        ResponseEntity<Post> response = restTemplate.getForEntity(url,Post.class);
        System.out.println("id::"+response.getBody().getId()+",body::"+response.getBody().getBody()+",title::"+response.getBody().getTitle());
        return response.getBody();
    }

//    update post
//    @PutMapping("/updatePost/{id}")
//    public ResponseEntity<Post> updatePost(@PathVariable int id){
//        String url="https://jsonplaceholder.typicode.com/posts/"+id;
//        RestTemplate restTemplate= new RestTemplate();
//        HttpHeaders httpHeaders= new HttpHeaders();
//        httpHeaders.add("Content-type","application/json; charset=UTF-8");
//        HttpEntity<Post> request=new HttpEntity<>(new Post(100,100,"title100","description100"),httpHeaders);
//        return restTemplate.exchange(url, HttpMethod.PUT,request,Post.class);
//    }

    @PutMapping("/updatePost")
    public ResponseEntity<Post> updatePost(){
        String url="https://jsonplaceholder.typicode.com/posts/1";
        RestTemplate restTemplate= new RestTemplate();
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("Content-type","application/json; charset=UTF-8");
        HttpEntity<Post> request=new HttpEntity<>(new Post(1,100,"title1","description1"),httpHeaders);
        return restTemplate.exchange(url,HttpMethod.PUT,request,Post.class);
    }


    //delete post
    @DeleteMapping("/deletePost/{id}")
    public void deletePost(@PathVariable int id){
        String url="https://jsonplaceholder.typicode.com/posts/"+id;
        RestTemplate restTemplate= new RestTemplate();
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("Content-type","application/json; charset=UTF-8");
        HttpEntity<Post> request=new HttpEntity<>(httpHeaders);
        restTemplate.exchange(url,HttpMethod.DELETE,request,Post.class);
    }

}


