package com.mkk_app.JUKIR.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author muhammad faiq
 */
public class Transaction {
    private String txId;
    private double amount;
    private List<PaymentProcessor> paymentList;
    private LocalDateTime timestamp;
    private ParkingTicket ticket; // linked in association: Transaction --> ParkingTicket

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

    public List<PaymentProcessor> getPaymentByType(String type) {
        List<PaymentProcessor> result = new ArrayList<>();
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

    public List<PaymentProcessor> getPaymentList() {
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
