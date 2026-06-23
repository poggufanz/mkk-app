package com.mkk_app.JUKIR.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Transaction {
    private String txId;
    private double amount;
    private ArrayList<PaymentProcessor> paymentList;
    private LocalDateTime timestamp;
    private ParkingTicket ticket;

    public Transaction(String txId, double amount, ParkingTicket ticket) {
        this.txId = txId;
        this.amount = amount;
        this.ticket = ticket;
        this.paymentList = new ArrayList<>();
        this.timestamp = LocalDateTime.now();
    }

    public void addPayment(PaymentProcessor p) {
        paymentList.add(p);
    }

    public double getTotalAmount() {
        double total = 0;
        for (PaymentProcessor p : paymentList) {
            total += p.getAmount();
        }
        return total;
    }

    public ArrayList<PaymentProcessor> getPaymentByType(String type) {
        ArrayList<PaymentProcessor> result = new ArrayList<>();
        for (PaymentProcessor p : paymentList) {
            if (p.getClass().getSimpleName().equalsIgnoreCase(type)) {
                result.add(p);
            }
        }
        return result;
    }

    public String getTxId() {
        return txId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ArrayList<PaymentProcessor> getPaymentList() {
        return paymentList;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public ParkingTicket getTicket() {
        return ticket;
    }

    public void setTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }
}
