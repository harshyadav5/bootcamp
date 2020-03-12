package com.webservicespart2.RestfulWebServicesPart2;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class EmployeeDaoServices{
    private static List<Employee> emp = new ArrayList<>();
    private static int idCounter= 3;
    static {
        emp.add(new Employee(1,"Harsh",new Date()));
        emp.add(new Employee(2,"Apoorva",new Date()));
        emp.add(new Employee(3,"Aman",new Date()));
    }

    public List<Employee> findAll()
    {
        return emp;
    }

    public Employee addEmployee(Employee emp1){
        if(emp1.getId() == null){
            emp1.setId(++idCounter);
        }
        emp.add(emp1);
        return emp1;
    }

}