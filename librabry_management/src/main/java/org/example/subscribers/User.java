package org.example.subscribers;

import java.security.PrivateKey;

public class User {
    public String getGender;
    private int userId;
    private String userName;
    private String gender;
    private String role = "subscribers";

    public User(int userId, String userName, String role , String gender) {
        this.userId = userId;
        this.userName = userName;
        this.gender = gender;
        this.role = role;
    }

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
                ", userName='" + userName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
