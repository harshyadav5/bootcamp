package com.webservicespart2.RestfulWebServicesPart2;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class Employee {

    private Integer id;
    @Size(min = 3)
    private String name;
    @Past
    private Date dateOfBirth;

    public Employee(Integer id, String name, Date dateOfBirth) {
        super();
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}