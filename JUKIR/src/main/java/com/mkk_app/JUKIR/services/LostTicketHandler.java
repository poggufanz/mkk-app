package com.mkk_app.JUKIR.services;

import com.mkk_app.JUKIR.models.Image;

/**
 *
 * @author muhammad faiq
 */
public class LostTicketHandler {
    private String stnkNumber;
    private Image ktpPhoto;
    private GateController gateController; // association: LostTicketHandler --> GateController

    public LostTicketHandler(GateController gateController) {
        this.gateController = gateController;
    }

    public void handleLost() {
        System.out.println("Memproses insiden tiket hilang untuk STNK: " + stnkNumber);
    }

    public void uploadKtp(Image img) {
        this.ktpPhoto = img;
        System.out.println("Foto KTP berhasil diunggah: " + img.getPath());
    }

    public boolean validateSTNK() {
        if (stnkNumber != null && stnkNumber.length() >= 10) {
            System.out.println("STNK valid.");
            return true;
        }
        System.out.println("STNK tidak valid.");
        return false;
    }

    public void requestGateOpen() {
        if (validateSTNK() && ktpPhoto != null) {
            System.out.println("Validasi tiket hilang disetujui. Membuka gate...");
            gateController.openGate();
        } else {
            System.out.println("Gagal membuka gate: data KTP atau STNK tidak lengkap/valid.");
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
