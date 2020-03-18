package com.example.JPAWithHibernatePart2;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee{
    @Id
    @Column(name = "emp_id")
    private Integer id;
    @Column(name = "emp_firstname")
    private String firstName;
    @Column(name = "emp_lastname")
    private String lastName;
    @Column(name = "emp_salary")
    private Integer salary;
    @Column(name = "emp_age")
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}