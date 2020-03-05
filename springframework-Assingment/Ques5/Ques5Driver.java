package com.tothenew.bootcamp.springframework.Ques5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Ques5Driver {
    @Autowired
    ShowDetails showDetails;

    public void setShowDetails(){
        showDetails.showDetails();
    }
}
