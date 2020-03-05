package com.tothenew.bootcamp.springframework.Ques5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ques5ResolveAmbiguity {
    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(Ques5ResolveAmbiguity.class);
        Ques5Driver ques5Driver = applicationContext.getBean(Ques5Driver.class);
        ques5Driver.setShowDetails();
    }
}
