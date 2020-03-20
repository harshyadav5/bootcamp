package com.example.JPAAssignment3;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorid;
    private String authorname;

    //Ques 2:Create instance variable of Address class inside Author class and save it as embedded object.
    @Embedded
    Address address;

    //Ques 3:Introduce a List of subjects for author.
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<Subject> list;

    @OneToOne(mappedBy = "author",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Book book;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Book> bookList;

    public Integer getAuthorid() {
        return authorid;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public List<Subject> getList() {
        return list;
    }

    public void setList(List<Subject> list) {
        this.list = list;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    //Better way to handle Foreign Key
    public void addSubject(Subject subject){
        if (subject != null){
            if (list == null){
                list = new ArrayList<Subject>();
            }
            subject.setAuthor(this);
            list.add(subject);
        }
    }
    public void addBook(Book book){
        if (book != null){
            book.setAuthor(this);
        }
    }
    public void addBookList(Book book){
        if (book != null){
            if (bookList == null){
                bookList = new ArrayList<Book>();
            }
            book.setAuthor(this);
            bookList.add(book);
        }
    }
}
