package com.mkk_app.JUKIR.services;

import com.mkk_app.JUKIR.exceptions.ParkingException;
import com.mkk_app.JUKIR.interfaces.IGateControllable;

/**
 *
 * @author muhammad faiq
 */
public class GateController implements IGateControllable {
    private String gateId;

    public GateController(String gateId) {
        this.gateId = gateId;
    }

    @Override
    public void openGate() {
        if (!isOpen()) {
            LocalStorage.getInstance().setGateOpen(true);
        } else {
            throw new ParkingException("Gate " + gateId + " sudah terbuka.");
        }
    }

    @Override
    public void closeGate() {
        if (isOpen()) {
            LocalStorage.getInstance().setGateOpen(false);
        } else {
            throw new ParkingException("Gate " + gateId + " sudah tertutup.");
        }
    }

    public String getStatus() {
        return isOpen() ? "OPEN" : "CLOSED";
    }

    public String getGateId() {
        return gateId;
    }

    public boolean isOpen() {
        return LocalStorage.getInstance().isGateOpen();
    }
}
