package com.example.JPAWithHibernatePart2.Table_Per_Class;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cardtable")
public class CardPayment extends PaymentParent{
    private String card_Number;

    public String getCard_Number() {
        return card_Number;
    }

    public void setCard_Number(String card_Number) {
        this.card_Number = card_Number;
    }
}
