/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkk_app.JUKIR.models;

import com.mkk_app.JUKIR.interfaces.GateOperable;

/**
 *
 * @author muhammad faiq
 */
public class ParkingGate implements GateOperable {
    private String gateId;
    private boolean isOpen;

    public ParkingGate(String gateId) {
        this.gateId = gateId;
        this.isOpen = false;
    }

    @Override
    public boolean openGate() {
        if (!isOpen) {
            isOpen = true;
            System.out.println("Gate " + gateId + " terbuka.");
            return true;
        }
        return false;
    }

    @Override
    public boolean closeGate() {
        if (isOpen) {
            isOpen = false;
            System.out.println("Gate " + gateId + " tertutup.");
            return true;
        }
        return false;
    }

    @Override
    public String getGateStatus() {
        return isOpen ? "OPEN" : "CLOSED";
    }
}
