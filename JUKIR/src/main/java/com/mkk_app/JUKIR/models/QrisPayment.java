package com.mkk_app.JUKIR.models;

import java.time.LocalDateTime;

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
        confirmRealtime();
    }

    public void confirmRealtime() {
        this.status = "SUCCESS";
        System.out.println("Pembayaran QRIS berhasil dikonfirmasi. Status: SUCCESS");
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
