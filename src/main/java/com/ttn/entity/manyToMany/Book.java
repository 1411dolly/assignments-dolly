package com.ttn.entity.manyToMany;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String bookName;

    @ManyToMany(mappedBy = "book",cascade = CascadeType.ALL)
    @Nullable
    Collection<Author> author = new HashSet<>();

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Book() {
    }

    public Collection<Author> getAuthor() {
        return author;
    }

    public void setAuthor(Collection<Author> author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
