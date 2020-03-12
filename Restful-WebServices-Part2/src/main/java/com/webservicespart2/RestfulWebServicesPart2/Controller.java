package com.webservicespart2.RestfulWebServicesPart2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
public class Controller{
    @Autowired
    private  EmployeeDaoServices employeeDaoServices;
    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/helloWorld1")
    public String helloWorldInternationalisation(){
        return messageSource.getMessage("good-morning",null, LocaleContextHolder.getLocale());
    }
    @GetMapping("/helloWorld/{username}")
    public String returnHelloUserName(@PathVariable  String username){
        return "Hello"+username;
    }
    @GetMapping("/getEmployees")
    public List<Employee> getAllEmployees(){
        return employeeDaoServices.findAll();
    }
    @PostMapping("/addEmployee")
    public void addNewEmployee(@RequestBody Employee emp){
        Employee employee = employeeDaoServices.addEmployee(emp);
    }
}
    