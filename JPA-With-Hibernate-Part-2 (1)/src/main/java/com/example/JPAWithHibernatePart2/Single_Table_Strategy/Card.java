package com.example.JPAWithHibernatePart2.Single_Table_Strategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cd")
public class Card extends Payment{
    private String card_Number;

    public String getCard_Number() {
        return card_Number;
    }

    public void setCard_Number(String card_Number) {
        this.card_Number = card_Number;
    }
}
