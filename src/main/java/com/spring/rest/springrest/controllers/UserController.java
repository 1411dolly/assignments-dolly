package com.spring.rest.springrest.controllers;


import com.spring.rest.springrest.entities.Post;
import com.spring.rest.springrest.entities.User;
import com.spring.rest.springrest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

//    @GetMapping("/")
//    String helloWorld(){
//        return "Hello World";
//    }
    @GetMapping("/users")
    List<User> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/post")
    public String getPost(){
        RestTemplate restTemplate = new RestTemplate();
        String url="https://jsonplaceholder.typicode.com/posts/1";
        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
        System.out.println(response.getStatusCode().toString());
        System.out.println(response.getHeaders().toString());
        return response.getBody();
    }

    @GetMapping("/postObject")
    public Post getPostObject(){
        RestTemplate restTemplate = new RestTemplate();
        String url="https://jsonplaceholder.typicode.com/posts/1";
        ResponseEntity<Post> response = restTemplate.getForEntity(url, Post.class);
        System.out.println(response.getStatusCode().toString());
        System.out.println(response.getHeaders().toString());
        return response.getBody();
    }

    @GetMapping("/postList")
    public List<Post> getPostList(){
        RestTemplate restTemplate = new RestTemplate();
        String url="https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<List<Post>> response = restTemplate
                .exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Post>>(){});
        return response.getBody();
    }

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    User saveUser( @RequestBody User user){
        userService.saveUser(user);
        return user;
    }

//    @PostMapping("/users")
//    ResponseEntity<User> saveUser(@RequestBody User user){
//        userService.saveUser(user);
//
//        URI uri= ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}").buildAndExpand(user.getId()).toUri();
//
//        return ResponseEntity.created(uri).build();
//    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id){
        User user=userService.getUserById(id);

//        if(user==null) {
//            throw new UserNotFoundException("User not found");
//        }
        userService.deleteUser(user);

    }



}
