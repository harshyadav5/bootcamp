package SpringDataJpa.JPAAssignment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity                        //Ques 1: Create an Employee Entity which contains following fields
public class Employee {
    private String name;
    @Id
    private Integer id;
    private Integer age;
    @Column(name = "loc")
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
