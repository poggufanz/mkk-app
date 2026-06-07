package com.mkk_app.JUKIR.models;

import com.mkk_app.JUKIR.enums.Role;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rhaihan aditya
 */
public class PetugasOperasional extends User {
    private LocalDateTime shiftStart;
    private int posGate;

    public PetugasOperasional(String userId, String username, String password, LocalDateTime shiftStart, int posGate) {
        super(userId, username, password, Role.PETUGAS_OPERASIONAL);
        this.shiftStart = shiftStart;
        this.posGate = posGate;
    }

    public void validateVehicle() {
        System.out.println("Petugas " + username + " melakukan validasi kendaraan.");
    }

    public void handleLostTicket() {
        System.out.println("Petugas " + username + " menangani tiket hilang.");
    }

    public void confirmPayment() {
        System.out.println("Petugas " + username + " mengonfirmasi pembayaran.");
    }

    @Override
    public List getAccessMenu() {
        List<String> menu = new ArrayList<>();
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
