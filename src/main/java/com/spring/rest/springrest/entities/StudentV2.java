package com.spring.rest.springrest.entities;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
@Entity
//@JsonIgnoreProperties(value = {"id"})
//@JsonFilter("myFilter")
public class StudentV2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Size(min = 2, message = "Name should have at least 2 characters")
    String firstname;
    String lastname;
    String standard;
    int age;
    String city;
    float percentage;

    public StudentV2() {

    }

    public StudentV2(@Size(min = 2, message = "Name should have at least 2 characters") String firstname, String lastname, String standard, int age, String city, float percentage) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.standard = standard;
        this.age = age;
        this.city = city;
        this.percentage = percentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
}
