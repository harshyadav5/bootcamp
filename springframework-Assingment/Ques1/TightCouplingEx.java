package com.tothenew.bootcamp.springframework.Ques1;

//Ques 1:Write a program to demonstrate Tightly Coupled code.
public class TightCouplingEx {
    public static void main(String[] args) {
       Student stu = new Student();
       stu.display();
    }
}
class Student{
    Person per;
    public Student(){
         per = new Person();
    }
    public void display(){
        System.out.println("This is student class");
        per.display();
    }
}
class Person{
    public Person(){ }
    public void display(){
        System.out.println("This is person class");
    }
}
