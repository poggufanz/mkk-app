/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mkk_app.JUKIR.services;

import com.mkk_app.JUKIR.interfaces.GateOperable;
import com.mkk_app.JUKIR.exceptions.ValidationException;
import com.mkk_app.JUKIR.exceptions.DataNotFoundException;
import com.mkk_app.JUKIR.models.ParkingGate;

/**
 *
 * @author muhammad faiq
 */
public class ParkirService {
    private GateOperable entryGate;
    private GateOperable exitGate;

    public ParkirService() {
        this.entryGate = new ParkingGate("GATE-IN-01");
        this.exitGate = new ParkingGate("GATE-OUT-01");
    }

    public void prosesMasuk(String platNomor) {
        if (platNomor == null || platNomor.trim().isEmpty()) {
            throw new ValidationException("Plat nomor tidak boleh kosong");
        }
        
        System.out.println("Kendaraan masuk: " + platNomor);
        entryGate.openGate();
        // Simulasi delay
        entryGate.closeGate();
    }

    public void prosesKeluar(String kodeTiket) {
        if (kodeTiket == null || kodeTiket.trim().isEmpty()) {
            throw new ValidationException("Kode tiket tidak boleh kosong");
        }
        
        // Simulasi pencarian tiket
        if (kodeTiket.equals("INVALID")) {
            throw new DataNotFoundException("Tiket tidak ditemukan: " + kodeTiket);
        }
        
        System.out.println("Memproses keluar untuk tiket: " + kodeTiket);
        exitGate.openGate();
        // Simulasi delay
        exitGate.closeGate();
    }
}
