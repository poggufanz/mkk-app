/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkk_app.JUKIR.exceptions;

/**
 *
 * @author muhammad faiq
 */
public class InsufficientPaymentException extends MKKException {
    private double required;
    private double received;

    public InsufficientPaymentException(double required, double received) {
        super("Pembayaran kurang. Dibutuhkan: " + required + ", Diterima: " + received);
        this.required = required;
        this.received = received;
    }

    public double getRequired() {
        return required;
    }

    public double getReceived() {
        return received;
    }
}
