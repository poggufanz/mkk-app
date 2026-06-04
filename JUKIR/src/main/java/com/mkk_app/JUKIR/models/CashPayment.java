/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkk_app.JUKIR.models;

import com.mkk_app.JUKIR.interfaces.MetodePembayaran;
import com.mkk_app.JUKIR.exceptions.PaymentException;

/**
 *
 * @author muhammad faiq
 */
public class CashPayment implements MetodePembayaran {
    @Override
    public boolean processPayment(double amount, String transactionId) throws PaymentException {
        if (amount <= 0) {
            throw new PaymentException("Jumlah pembayaran tunai harus lebih dari 0");
        }
        System.out.println("Memproses pembayaran tunai sebesar: " + amount + " untuk transaksi: " + transactionId);
        return true;
    }

    @Override
    public String getPaymentStatus(String transactionId) {
        return "SUCCESS";
    }
}
