package com.example.ahmed.task_movie_app.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ahmed on 5/18/2017.
 */

public class User {

    @SerializedName("fname")
    private String fname;
    @SerializedName("lname")
    private String lname;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;


    public User(String fname,String lname, String email, String password) {
        this.fname = fname;
        this.lname=lname;
        this.email = email;
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
