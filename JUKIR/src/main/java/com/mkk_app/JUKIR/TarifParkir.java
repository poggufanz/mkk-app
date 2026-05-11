package com.mkk_app.JUKIR;

import java.time.LocalDate;

/**
 * Konfigurasi tarif parkir progresif berdasarkan jenis kendaraan.
 * Entity Layer 2 — stub untuk kebutuhan Layer 1.
 */
public class TarifParkir {

    private String tarifId;
    private String vehicleType;
    private double baseFee;
    private double firstHourFee;
    private double nextHourFee;
    private double maxDailyFee;
    private LocalDate effectiveDate;
    private Boolean isActive;

    public TarifParkir() {
        this.isActive = false;
    }

    public TarifParkir getTarifByVehicleType(String type) {
        // todo: cari dari ArrayList berdasarkan tipe kendaraan
        return null;
    }

    public void activate() {
        this.isActive = true;
    }

    public void deactivate() {
        this.isActive = false;
    }

    public void updateTarif(double baseFee, double nextHour) {
        this.baseFee = baseFee;
        this.nextHourFee = nextHour;
    }

    // ─── Getters ───────────────────────────────────────────────────────────────

    public String getTarifId() { return tarifId; }
    public String getVehicleType() { return vehicleType; }
    public double getBaseFee() { return baseFee; }
    public double getFirstHourFee() { return firstHourFee; }
    public double getNextHourFee() { return nextHourFee; }
    public double getMaxDailyFee() { return maxDailyFee; }
    public LocalDate getEffectiveDate() { return effectiveDate; }
    public Boolean getIsActive() { return isActive; }

    // ─── Setters ───────────────────────────────────────────────────────────────

    public void setTarifId(String tarifId) { this.tarifId = tarifId; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }
    public void setBaseFee(double baseFee) { this.baseFee = baseFee; }
    public void setFirstHourFee(double firstHourFee) { this.firstHourFee = firstHourFee; }
    public void setNextHourFee(double nextHourFee) { this.nextHourFee = nextHourFee; }
    public void setMaxDailyFee(double maxDailyFee) { this.maxDailyFee = maxDailyFee; }
    public void setEffectiveDate(LocalDate effectiveDate) { this.effectiveDate = effectiveDate; }
    public void setActive(Boolean active) { this.isActive = active; }
}
