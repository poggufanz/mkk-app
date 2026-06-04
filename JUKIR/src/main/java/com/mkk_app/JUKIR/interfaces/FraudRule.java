/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkk_app.JUKIR.interfaces;

/**
 *
 * @author muhammad faiq
 */
public interface FraudRule {
    Object evaluate(Object transaksi, Object petugas); // Using Object for now
    String getRuleName();
}
