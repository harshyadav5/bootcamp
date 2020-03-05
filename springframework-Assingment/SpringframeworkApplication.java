package com.tothenew.bootcamp.springframework;

import com.tothenew.bootcamp.springframework.Ques3.EmployeeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//Ques 4: Get a Spring Bean from application context and display its properties.
@SpringBootApplication
public class SpringframeworkApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(SpringframeworkApplication.class);
		EmployeeDriver employeeDriver = applicationContext.getBean(EmployeeDriver.class);
		employeeDriver.showEmployeeDriver();
	}
}
