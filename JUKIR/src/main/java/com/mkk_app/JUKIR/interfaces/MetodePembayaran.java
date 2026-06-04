/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkk_app.JUKIR.interfaces;

import com.mkk_app.JUKIR.exceptions.PaymentException;

/**
 *
 * @author muhammad faiq
 */
public interface MetodePembayaran {
    boolean processPayment(double amount, String transactionId) throws PaymentException;
    String getPaymentStatus(String transactionId);
}
