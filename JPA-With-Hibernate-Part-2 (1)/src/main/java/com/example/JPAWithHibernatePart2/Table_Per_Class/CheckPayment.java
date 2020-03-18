package com.example.JPAWithHibernatePart2.Table_Per_Class;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "checktable")
public class CheckPayment extends PaymentParent{
    private String check_Number;

    public String getCheck_Number() {
        return check_Number;
    }

    public void setCheck_Number(String check_Number) {
        this.check_Number = check_Number;
    }
}
