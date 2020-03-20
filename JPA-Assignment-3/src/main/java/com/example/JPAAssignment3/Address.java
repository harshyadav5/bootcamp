package com.example.JPAAssignment3;

import javax.persistence.Embeddable;

//Ques 1: Create a class Address for Author with instance variables streetNumber, location, State.
@Embeddable
public class Address {
    private String streetnumber;
    private String location;
    private String state;

    public String getStreetNumber() {
        return streetnumber;
    }

    public void setStreetNumber(String streetnumber) {
        this.streetnumber = streetnumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
