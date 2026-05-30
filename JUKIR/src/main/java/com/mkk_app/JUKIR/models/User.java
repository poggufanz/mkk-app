/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkk_app.JUKIR.models;

import java.util.List;

/**
 *
 * @author rhaihan aditya
 */
public abstract class User {
    protected String userId, username, password;
    protected Role role;
    
    public User(String userId, String username, String password, Role role){
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public void login(){
        System.out.println(username + " berhasil login sebagai " + role);
    }
    
    public abstract List getAccessMenu();

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
    
    public String getPassword(){
        return password;
    }

    public Role getRole() {
        return role;
    }
    
}
