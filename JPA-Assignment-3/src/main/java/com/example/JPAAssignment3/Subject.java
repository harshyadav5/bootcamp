package com.example.JPAAssignment3;


import javax.persistence.*;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectid;
    private String subjectname;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }
    public String getSubjectName() {
        return subjectname;
    }

    public void setSubjectName(String subjectName) {
        this.subjectname = subjectName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
