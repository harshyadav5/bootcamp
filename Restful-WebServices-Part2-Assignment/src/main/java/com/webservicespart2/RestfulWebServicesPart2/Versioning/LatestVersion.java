package com.webservicespart2.RestfulWebServicesPart2.Versioning;

public class LatestVersion {
    private User user;

    public LatestVersion(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
