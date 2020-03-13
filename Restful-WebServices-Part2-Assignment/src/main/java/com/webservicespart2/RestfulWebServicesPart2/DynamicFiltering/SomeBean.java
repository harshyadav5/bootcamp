package com.webservicespart2.RestfulWebServicesPart2.DynamicFiltering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("NewFilter")
public class SomeBean {
    private String username;
    private String password;

    public SomeBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SomeBean{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}