package org.regexandserial.models;

import java.io.Serializable;

public class UserRegisterInput implements Serializable{

    private String name;
    private String surName;
    private String email;
    private String street;
    //todo make password non-serializable
    private String password;

    public UserRegisterInput() {
    }

    public UserRegisterInput(String name, String surName, String email, String street, String password) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.street = street;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserRegisterInput{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                ", street='" + street + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
