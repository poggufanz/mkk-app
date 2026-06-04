/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkk_app.JUKIR.interfaces;

/**
 *
 * @author muhammad faiq
 */
public interface TarifStrategy {
    double hitungTarif(Object tiket); // Using Object for now until TiketParkir is fully defined
    String getNamaStrategy();
}
