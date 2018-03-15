package com.example.jibba.birdwatcher.objects;

/**
 * Created by jibba on 15-03-2018.
 */

public class Users {
    private String UserId;
    private String email;
    private String name;

public Users(){}

public Users(String email, String name){
    this.email = email;
    this.name = name;
}

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

