package com.ttn.entity.oneToManyBiDirectional;

import javax.persistence.*;

@Entity
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String bookName;

    @ManyToOne
    Author author;

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Book() {
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
