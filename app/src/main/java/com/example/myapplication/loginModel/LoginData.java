package com.example.myapplication.loginModel;

public class LoginData {
    private String role;
    private String activeTeam;
    private String userId;
    private String username;
    private String token;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getActiveTeam() {
        return activeTeam;
    }

    public void setActiveTeam(String activeTeam) {
        this.activeTeam = activeTeam;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginData(String role, String activeTeam, String userId, String username, String token) {
        this.role = role;
        this.activeTeam = activeTeam;
        this.userId = userId;
        this.username = username;
        this.token = token;

    }
}
