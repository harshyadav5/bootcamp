package com.example.JPAAssignment3;

import javax.persistence.*;
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
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Subject> list;

    public Integer getAuthorid() {
        return authorid;
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
}
