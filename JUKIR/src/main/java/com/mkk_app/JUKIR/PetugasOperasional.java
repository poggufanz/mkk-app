package com.mkk_app.JUKIR;

import java.time.ZonedDateTime;

/**
 * Subclass User, petugas operasional di pos pintu keluar.
 * Memproses validasi kendaraan, tiket hilang, dan pembayaran.
 */
public class PetugasOperasional extends User {

    private String petugasId;
    private String posId;
    private ZonedDateTime shiftStart;
    private ZonedDateTime shiftEnd;
    private int totalTransaksiHarian;

    // ─── Constructor ───────────────────────────────────────────────────────────

    public PetugasOperasional(String userId, String username, String password,
                              String petugasId, String posId) {
        super(userId, username, password, Role.PETUGAS);
        this.petugasId = petugasId;
        this.posId = posId;
        this.totalTransaksiHarian = 0;
    }

    public ValidationResult validateVehicleExit(String ticketId) {
        if (ticketId == null || ticketId.isBlank()) {
            return new ValidationResult(false, "Ticket ID tidak boleh kosong");
        }
        // TODO: integrasi dengan ParkingTicket & VehicleExitQueue
        return new ValidationResult(true, "Validasi berhasil untuk tiket: " + ticketId);
    }

    public Boolean processLostTicket(String stnk, String ktpPhotoPath) {
        if (stnk == null || stnk.isBlank()) {
            return false;
        }
        if (ktpPhotoPath == null || ktpPhotoPath.isBlank()) {
            return false;
        }
        // TODO: delegate ke LostTicketHandler
        return true;
    }

    public Boolean confirmPayment(String transactionId) {
        if (transactionId == null || transactionId.isBlank()) {
            return false;
        }
        // TODO: delegate ke PaymentProcessor
        totalTransaksiHarian++;
        return true;
    }

    public Boolean openExitGate(String ticketId) {
        if (ticketId == null || ticketId.isBlank()) {
            return false;
        }
        // TODO: delegate ke GateController
        return true;
    }

    public ShiftSummary getShiftSummary() {
        ShiftSummary summary = new ShiftSummary();
        summary.setPetugasId(this.petugasId);
        summary.setTotalTransactions(this.totalTransaksiHarian);
        // TODO: hitung total revenue dari transaksi hari ini
        return summary;
    }

    // ─── Shift Management ──────────────────────────────────────────────────────

    public void startShift() {
        this.shiftStart = ZonedDateTime.now(ZONE_JAKARTA);
        this.totalTransaksiHarian = 0;
    }

    public void endShift() {
        this.shiftEnd = ZonedDateTime.now(ZONE_JAKARTA);
    }

    // ─── Getters ───────────────────────────────────────────────────────────────

    public String getPetugasId() {
        return petugasId;
    }

    public String getPosId() {
        return posId;
    }

    public ZonedDateTime getShiftStart() {
        return shiftStart;
    }

    public ZonedDateTime getShiftEnd() {
        return shiftEnd;
    }

    public int getTotalTransaksiHarian() {
        return totalTransaksiHarian;
    }

    // ─── Setters ───────────────────────────────────────────────────────────────

    public void setPosId(String posId) {
        this.posId = posId;
    }
}
