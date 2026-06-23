package com.mkk_app.JUKIR.models;

import com.mkk_app.JUKIR.interfaces.IPayable;
import java.time.LocalDateTime;

/**
 *
 * @author rhaihan aditya
 */
public abstract class PaymentProcessor implements IPayable {
    protected double amount;
    protected LocalDateTime paymentTime;

    public PaymentProcessor(double amount, LocalDateTime paymentTime) {
        this.amount = amount;
        this.paymentTime = paymentTime;
    }

    @Override
    public abstract void processPayment();

    public void validatePayment() {
    }

    @Override
    public abstract String getStatus();

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }
}
