package com.webservicespart2.RestfulWebServicesPart2.Versioning;

public class User {
    private Integer id;
    private String name;
    private Integer mobno;
    private String address;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(Integer id, String name, Integer mobno, String address) {
        this.id = id;
        this.name = name;
        this.mobno = mobno;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMobno() {
        return mobno;
    }

    public void setMobno(Integer mobno) {
        this.mobno = mobno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobno=" + mobno +
                ", address='" + address + '\'' +
                '}';
    }
}
