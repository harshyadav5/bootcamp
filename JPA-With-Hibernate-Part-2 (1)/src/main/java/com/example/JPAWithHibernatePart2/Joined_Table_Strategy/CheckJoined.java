package com.example.JPAWithHibernatePart2.Joined_Table_Strategy;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "checkjoined")
@PrimaryKeyJoinColumn(name = "id")
public class CheckJoined extends Paymentjoined {
    private String checknumber;

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }
}
