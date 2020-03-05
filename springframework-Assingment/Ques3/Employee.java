package com.tothenew.bootcamp.springframework.Ques3;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    private Integer id;
    private String name;
    private Double salary;
    public Employee(){
        System.out.println("Employee Constructor");
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public void show(){
        System.out.println("Show Employee");
    }
}
