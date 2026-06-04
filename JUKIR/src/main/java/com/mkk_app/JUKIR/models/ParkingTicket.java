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
public class ParkingTicket {
    private String ticketId;
    private String vehiclePlateNumber;
    private LocalDateTime entryTime;
    private String vehicleType;
    private String status; // AKTIF, SELESAI, HILANG

    public ParkingTicket(String ticketId, String vehiclePlateNumber, String vehicleType) {
        this.ticketId = ticketId;
        this.vehiclePlateNumber = vehiclePlateNumber;
        this.vehicleType = vehicleType;
        this.entryTime = LocalDateTime.now();
        this.status = "AKTIF";
    }

    public String getTicketId() { return ticketId; }
    public String getVehiclePlateNumber() { return vehiclePlateNumber; }
    public LocalDateTime getEntryTime() { return entryTime; }
    public String getVehicleType() { return vehicleType; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
