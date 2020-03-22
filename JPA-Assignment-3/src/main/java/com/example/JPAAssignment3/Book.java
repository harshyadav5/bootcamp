package com.example.JPAAssignment3;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "book_Name")
    private String bookNmae;

//    @ManyToMany(mappedBy = "books")
//    private List<Author> authorList;
    @ManyToMany(mappedBy = "books")
    private Set<Author> authorSet;

    public Integer getBookId() {
        return id;
    }

    public void setBookId(Integer bookId) {
        this.id = bookId;
    }

    public String getBookNmae() {
        return bookNmae;
    }

    public void setBookNmae(String bookNmae) {
        this.bookNmae = bookNmae;
    }

    public Set<Author> getAuthorSet() {
        return authorSet;
    }

    public void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }
}
