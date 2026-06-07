package com.mkk_app.JUKIR.models;

import java.time.LocalDateTime;

/**
 *
 * @author muhammad faiq
 */
public class QrisPayment extends PaymentProcessor {
    private String qrToken;
    private String status;

    public QrisPayment(double amount, LocalDateTime paymentTime, String qrToken) {
        super(amount, paymentTime);
        this.qrToken = qrToken;
        this.status = "PENDING";
    }

    @Override
    public void processPayment() {
        System.out.println("Memproses pembayaran QRIS sebesar: " + amount + " dengan token: " + qrToken);
        confirmRealtime();
    }

    public void confirmRealtime() {
        this.status = "SUCCESS";
        System.out.println("Konfirmasi QRIS realtime sukses.");
    }

    @Override
    public String getStatus() {
        return status;
    }

    public String getQrToken() {
        return qrToken;
    }

    public void setQrToken(String qrToken) {
        this.qrToken = qrToken;
    }
}
