package com.mkk_app.JUKIR.models;

import com.mkk_app.JUKIR.enums.Role;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PetugasOperasional extends User {
    private LocalDateTime shiftStart;
    private int posGate;

    public PetugasOperasional(String userId, String username, String password, LocalDateTime shiftStart, int posGate) {
        super(userId, username, password, Role.PETUGAS_OPERASIONAL);
        this.shiftStart = shiftStart;
        this.posGate = posGate;
    }

    public void validateVehicle() {
        System.out.println("Validasi kendaraan dilakukan oleh: " + username);
    }

    public void handleLostTicket() {
        System.out.println("Penanganan tiket hilang dimulai oleh: " + username);
    }

    public void confirmPayment() {
        System.out.println("Pembayaran dikonfirmasi oleh: " + username);
    }

    @Override
    public ArrayList<String> getAccessMenu() {
        ArrayList<String> menu = new ArrayList<>();
        menu.add("1. Registrasi Masuk");
        menu.add("2. Proses Keluar");
        menu.add("3. Tiket Hilang");
        menu.add("4. Ganti Password");
        menu.add("5. Keluar");
        return menu;
    }

    public LocalDateTime getShiftStart() {
        return shiftStart;
    }

    public void setShiftStart(LocalDateTime shiftStart) {
        this.shiftStart = shiftStart;
    }

    public int getPosGate() {
        return posGate;
    }

    public void setPosGate(int posGate) {
        this.posGate = posGate;
    }
}
