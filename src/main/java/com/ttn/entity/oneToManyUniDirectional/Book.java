package com.ttn.entity.oneToManyUniDirectional;

import javax.persistence.*;

@Entity
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String bookName;

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Book() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
