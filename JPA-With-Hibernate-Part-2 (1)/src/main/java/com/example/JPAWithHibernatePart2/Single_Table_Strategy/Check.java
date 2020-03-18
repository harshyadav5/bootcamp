package com.example.JPAWithHibernatePart2.Single_Table_Strategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cc")
public class Check extends Payment{
    private String check_Number;

    public String getCheck_Number() {
        return check_Number;
    }

    public void setCheck_Number(String check_Number) {
        this.check_Number = check_Number;
    }
}
