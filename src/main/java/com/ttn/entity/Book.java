package com.ttn.entity;
import javax.persistence.*;

@Entity
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String bookName;


    public Book(String bookName) {
        this.bookName = bookName;
    }
}
