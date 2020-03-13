package com.webservicespart2.RestfulWebServicesPart2.Versioning;

public class OldVersion {
    private User user;

    public OldVersion(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

