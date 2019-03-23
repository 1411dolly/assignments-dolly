package com.ttn.entity.oneToManyWithoutTable;

import javax.persistence.*;
import java.util.*;


@Entity
public class Author {
//    Q6...Rename all the fields using column annotation.
//Q9...Generate Id for Author Using IDENTITY and TABLE starategy.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "author_id")
    int id;

    @Column(name ="first_name")
    String firstName;

//    Q6...Mark lastName as @Transient.
    @Transient
    @Column(name = "last_name")
    String lastName;

    @Column(name = "age")
    int age;

//    Q8...Use @Temporal for date of birth of Author.
    @Temporal(TemporalType.DATE)
    @Column(name = "dob")
    Date dob;

    @Embedded
    Address address;
//    Q12...Introduce a List of subjects for author.

    @OneToMany(mappedBy = "author")
    Collection<Book> book = new HashSet<>();

    @ElementCollection
    List<String> subjects=new ArrayList<>();

    public Author(String firstName, String lastName, int age, Date dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dob = dob;
    }

    public Author() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public Collection<Book> getBook() {
        return book;
    }

    public void setBook(Collection<Book> book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
