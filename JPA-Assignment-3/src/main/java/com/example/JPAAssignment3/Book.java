package com.example.JPAAssignment3;

import javax.persistence.Entity;
import javax.persistence.Id;

//Ques 5:Create an Entity book with an instance variable bookName.
@Entity
public class Book {
    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    @Id
    private Integer bookid;
    private String bookName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
