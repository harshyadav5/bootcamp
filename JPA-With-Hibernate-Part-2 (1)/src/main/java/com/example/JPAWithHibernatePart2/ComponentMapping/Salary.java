package com.example.JPAWithHibernatePart2.ComponentMapping;

import javax.persistence.Embeddable;

@Embeddable
public class Salary {
    private double basicsalary;
    private double bonussalary;
    private double taxamount;
    private double specialallowancesalary;

    public double getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(double basicsalary) {
        this.basicsalary = basicsalary;
    }

    public double getBonussalary() {
        return bonussalary;
    }

    public void setBonussalary(double bonussalary) {
        this.bonussalary = bonussalary;
    }

    public double getTaxamount() {
        return taxamount;
    }

    public void setTaxamount(double taxamount) {
        this.taxamount = taxamount;
    }

    public double getSpecialallowancesalary() {
        return specialallowancesalary;
    }

    public void setSpecialallowancesalary(double specialallowancesalary) {
        this.specialallowancesalary = specialallowancesalary;
    }
}
