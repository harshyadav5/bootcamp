package com.tothenew.bootcamp.springframework.Ques5;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Student implements ShowDetails {
    @Override
    public void showDetails() {
        System.out.println("These are student details");
    }
}
