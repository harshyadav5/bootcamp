package com.example.JPAWithHibernatePart2.Joined_Table_Strategy;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cardjoined")
@PrimaryKeyJoinColumn(name = "id")
public class CardJoined extends Paymentjoined {
    private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}
