package com.choice.minecraftdevelopment.model;

public class User {

    private final String username;
    private final String password;
    private Boolean online;
    private String lastLogin;
    private String timestamp;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.online = false;
        this.lastLogin = null;
        this.timestamp = null;
    }

    public User(String username, String password, Boolean online, String last_login, String timestamp) {
        this.username = username;
        this.password = password;
        this.online = online;
        this.lastLogin = last_login;
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean isOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getTimestamp() {
        return lastLogin;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
