package com.tothenew.bootcamp.springframework.Ques3;

import com.tothenew.bootcamp.springframework.SpringframeworkApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Ques3BeanHandle {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringframeworkApplication.class);
        EmployeeDriver employee = configurableApplicationContext.getBean(EmployeeDriver.class);
        employee.showEmployeeDriver();
    }
}
