/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkk_app.JUKIR.interfaces;

import java.util.List;

/**
 *
 * @author rhaihan aditya
 */
public interface INotifiable {
    public List getNotifLog();
    
    public void sendNotification(String msg);
}
