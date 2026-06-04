/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkk_app.JUKIR.models;

import java.time.LocalDateTime;

/**
 *
 * @author muhammad faiq
 */
public class Transaction {
    private String transactionId;
    private String ticketId;
    private double totalAmount;
    private String paymentMethod;
    private LocalDateTime timestamp;

    public Transaction(String transactionId, String ticketId, double totalAmount, String paymentMethod) {
        this.transactionId = transactionId;
        this.ticketId = ticketId;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.timestamp = LocalDateTime.now();
    }

    public String getTransactionId() { return transactionId; }
    public String getTicketId() { return ticketId; }
    public double getTotalAmount() { return totalAmount; }
    public String getPaymentMethod() { return paymentMethod; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
