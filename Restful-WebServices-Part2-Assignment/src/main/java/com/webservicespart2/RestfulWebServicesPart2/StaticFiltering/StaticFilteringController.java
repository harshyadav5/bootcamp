package com.webservicespart2.RestfulWebServicesPart2.StaticFiltering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StaticFilteringController {
    @GetMapping("/staticFiltering1")
    public SomeBean returnStaticFiltering(){
        return new SomeBean("Harsh","password");
    }
    @GetMapping("/staticFiltering2")
    public List<SomeBean> returnStaticFilteringResult(){
        return Arrays.asList(new SomeBean("Harsh","password1")
                ,new SomeBean("Aditya","password2"));
    }
}
