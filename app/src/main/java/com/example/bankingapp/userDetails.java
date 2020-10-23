package com.example.bankingapp;

public class userDetails {
//Variables.
    public String id;
    public String name;
    public String surname;
    public String email;
    public String password;
    public String mobile;
    public String gender;
    public String curBal;
    public String savBal;
    //Constructor.
    public userDetails(String id, String name, String surname, String email, String password, String mobile, String gender, String curBal, String savBal) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.gender = gender;
        this.curBal = curBal;
        this.savBal = savBal;
    }
    //Getters.
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getMobile() {
        return mobile;
    }
    public String getGender() {
        return gender;
    }
    public String getCurBal() {
        return curBal;
    }
    public String getSavBal() {
        return savBal;
    }

    //Setters.
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setCurBal(String curBal) {
        this.curBal = curBal;
    }
    public void setSavBal(String savBal) {
        this.savBal = savBal;
    }
}
