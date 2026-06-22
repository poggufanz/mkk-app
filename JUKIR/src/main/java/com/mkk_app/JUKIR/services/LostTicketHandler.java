package com.mkk_app.JUKIR.services;

import com.mkk_app.JUKIR.exceptions.ValidationException;
import com.mkk_app.JUKIR.models.Image;

public class LostTicketHandler {
    private String stnkNumber;
    private Image ktpPhoto;
    private GateController gateController;

    public LostTicketHandler(GateController gateController) {
        this.gateController = gateController;
    }

    public void handleLost() {
        requestGateOpen();
        System.out.println("Tiket hilang berhasil ditangani. Gerbang dibuka.");
    }

    public void uploadKtp(Image img) {
        this.ktpPhoto = img;
    }

    public boolean validateSTNK() {
        if (stnkNumber == null || stnkNumber.trim().length() < 10) {
            throw new ValidationException("Nomor STNK tidak valid! (Harus minimal 10 karakter)");
        }
        return true;
    }

    public void requestGateOpen() {
        validateSTNK();
        if (ktpPhoto == null) {
            throw new ValidationException("Foto KTP belum diunggah!");
        }
        try {
            gateController.openGate();
        } catch (com.mkk_app.JUKIR.exceptions.ParkingException ex) {
        }
    }

    public String getStnkNumber() {
        return stnkNumber;
    }

    public void setStnkNumber(String stnkNumber) {
        this.stnkNumber = stnkNumber;
    }

    public Image getKtpPhoto() {
        return ktpPhoto;
    }
}
