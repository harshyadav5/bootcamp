package com.tothenew.bootcamp.springframework.Ques3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDriver {
    @Autowired
    private Employee employee;
    public EmployeeDriver() {
        System.out.println("EmployeeDriver Constructor");
    }
    public void showEmployeeDriver(){
        System.out.println("EmployeeDriver Show");
        employee.show();
    }
}
