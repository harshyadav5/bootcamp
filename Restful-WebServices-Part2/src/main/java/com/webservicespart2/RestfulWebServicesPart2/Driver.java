package com.webservicespart2.RestfulWebServicesPart2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class Driver {
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
}
