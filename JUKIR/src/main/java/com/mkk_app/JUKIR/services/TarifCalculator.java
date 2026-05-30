/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkk_app.JUKIR.services;

import com.mkk_app.JUKIR.models.TarifParkir;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author rhaihan aditya
 */
public class TarifCalculator {
    private TarifParkir tarifConfig;
    
    public TarifCalculator (TarifParkir tarifConfig){
        this.tarifConfig = tarifConfig;
    }
    
    public double calculate(int minutes){
        return hitungTarif(minutes, tarifConfig.getVehicleType());
    }
    
    public double calculate(LocalDateTime entryTime, LocalDateTime exitTime) {
        long minutes = Duration.between(entryTime, exitTime).toMinutes();
        return hitungTarif((int) minutes, tarifConfig.getVehicleType());
    }
    
    public double calculate(ParkingTicket ticket){
        long minutes = Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toMinutes();
        return hitungTarif((int) minutes, tarifConfig.getVehicleType());
    }
    
    public double calculate(int minutes, String vehicleType){
        double base = tarifConfig.getBaseRate();
        double hourly = tarifConfig.getHourlyRate();
        
        if (vehicleType != null && vehicleType.equalsIgnoreCase("motor")){
            base *= 0.5;
            hourly *= 0.5;
        }
        
        if (minutes <= 60){
            return base;
        } else {
            int jamTambahan = (int) Math.ceil((minutes - 60) / 60.0);
            return base + (jamTambahan * hourly);
        }
    }
    
    public TarifParkir getTarifConfig(){
        return tarifConfig;
    }
    
    public void setTarifConfig(TarifParkir t){
        this.tarifConfig = t;
    }
}
