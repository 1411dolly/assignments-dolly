package com.ttn.entity.manyToMany;


import javax.persistence.Embeddable;

//Q10...Create a class Address for Author with instance variables streetNumber, location, State.
@Embeddable
public class Address {
    int streetNumber;
    String location;
    String State;

    public Address(int streetNumber, String location, String state) {
        this.streetNumber = streetNumber;
        this.location = location;
        State = state;
    }

    public Address() {
    }
}
