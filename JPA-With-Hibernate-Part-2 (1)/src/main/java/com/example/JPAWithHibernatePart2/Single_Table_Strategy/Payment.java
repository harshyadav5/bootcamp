package com.example.JPAWithHibernatePart2.Single_Table_Strategy;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pmode",discriminatorType = DiscriminatorType.STRING)
public abstract class Payment {
    @Id
    private Integer id;
    private double amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
