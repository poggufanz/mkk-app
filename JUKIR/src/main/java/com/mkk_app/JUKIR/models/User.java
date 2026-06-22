package com.mkk_app.JUKIR.models;

import com.mkk_app.JUKIR.enums.Role;
import java.util.ArrayList;

public abstract class User {
    protected String userId;
    protected String username;
    protected String password;
    protected Role role;
    
    public User(String userId, String username, String password, Role role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public void login() {
    }
    
    public abstract ArrayList<String> getAccessMenu();

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}
