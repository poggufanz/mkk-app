package com.mkk_app.JUKIR.models;

import com.mkk_app.JUKIR.exceptions.InsufficientPaymentException;
import java.time.LocalDateTime;

/**
 *
 * @author muhammad faiq
 */
public class CashPayment extends PaymentProcessor {
    private double receivedAmount;
    private String status;

    public CashPayment(double amount, LocalDateTime paymentTime, double receivedAmount) {
        super(amount, paymentTime);
        this.receivedAmount = receivedAmount;
        this.status = "PENDING";
    }

    @Override
    public void processPayment() {
        if (receivedAmount < amount) {
            this.status = "FAILED";
            throw new InsufficientPaymentException(amount, receivedAmount);
        } else {
            this.status = "SUCCESS";
        }
    }

    public double calcChange() {
        return Math.max(0.0, receivedAmount - amount);
    }

    @Override
    public String getStatus() {
        return status;
    }

    public double getReceivedAmount() {
        return receivedAmount;
    }

    public void setReceivedAmount(double receivedAmount) {
        this.receivedAmount = receivedAmount;
    }
}
