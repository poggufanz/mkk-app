/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkk_app.JUKIR.interfaces;

/**
 *
 * @author muhammad faiq
 */
public interface EventListener {
    void onEvent(String type, Object data); // Using String for type until EventType enum is fully defined
}
