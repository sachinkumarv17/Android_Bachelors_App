package com.example.Bachelors;

public class userdetails {
    String username , type;

    public userdetails(String username, String type) {
        this.username = username;
        this.type = type;
    }

    public userdetails() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
