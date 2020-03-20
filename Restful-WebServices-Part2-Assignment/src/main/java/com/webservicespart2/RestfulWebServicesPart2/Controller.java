package com.webservicespart2.RestfulWebServicesPart2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller{
    @Autowired
    private EmployeeDaoServices employeeDaoServices;
    @Autowired
    private MessageSource messageSource;

    // Internationalization

    @GetMapping(path = "/helloWorld1")
    public String helloWorldInternationalisation(){
        return messageSource.getMessage("good-morning",null, LocaleContextHolder.getLocale());
    }
    @GetMapping("/helloWorld/{username}")
    public String returnHelloUserName(@PathVariable  String username){
        return "Hello"+username;
    }

    // Content Negotiation
    
    // Ques 5(a): Get details of User using GET request.
    @GetMapping("/getEmployees")
    public List<Employee> getAllEmployees(){
        return employeeDaoServices.findAll();
    }
    // Ques 5(b): Get details of User using GET request.
    @PostMapping("/addEmployee")
    public void addNewEmployee(@RequestBody Employee emp){
        Employee employee = employeeDaoServices.addEmployee(emp);
    }
    // Ques 5(c): Delete a user using DELETE request.
    @DeleteMapping("deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable int id){
        Employee emp = employeeDaoServices.deleteEmployeeByID(id);

        if(emp == null){
            throw  new EmployeeNotFoundException("id"+id);
        }
    }

}
