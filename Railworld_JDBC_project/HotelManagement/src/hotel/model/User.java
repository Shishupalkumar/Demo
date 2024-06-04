package hotel.model;

//package com.hotel.model;

public class User {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String contact;
    private String role;

    public User(int userId, String username, String password, String email, String contact, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.contact = contact;
        this.role = this.role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

