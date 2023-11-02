package com.example.workingapp;

public class UserData {
    String email,username,password,confirm_password;

    public UserData(String email, String username, String password, String confirm_password) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.confirm_password = confirm_password;
    }

    public UserData() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }
}

