package com.mkk_app.JUKIR.services;

import com.mkk_app.JUKIR.interfaces.IGateControllable;

/**
 *
 * @author muhammad faiq
 */
public class GateController implements IGateControllable {
    private String gateId;
    private boolean isOpen;

    public GateController(String gateId) {
        this.gateId = gateId;
        this.isOpen = false;
    }

    @Override
    public void openGate() {
        if (!isOpen) {
            isOpen = true;
            System.out.println("Gate " + gateId + " terbuka.");
        } else {
            System.out.println("Gate " + gateId + " sudah terbuka.");
        }
    }

    @Override
    public void closeGate() {
        if (isOpen) {
            isOpen = false;
            System.out.println("Gate " + gateId + " tertutup.");
        } else {
            System.out.println("Gate " + gateId + " sudah tertutup.");
        }
    }

    public String getStatus() {
        return isOpen ? "OPEN" : "CLOSED";
    }

    public String getGateId() {
        return gateId;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
