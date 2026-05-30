/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkk_app.JUKIR.models;

/**
 *
 * @author rhaihan aditya
 */
public abstract class PaymentProcessor {
    protected double amount;
    protected DateTime paymentTime;
    
    public PaymentProcessor(double amount, DateTime paymentTime){
        this.amount = amount; 
        this.paymentTime = paymentTime;
    }
    
    public void processPayment(){
        
    }
    
    public void validatePayment(){
        
    }
    
    public abstract String getStatus();
}
