package com.mkk_app.JUKIR.models;

/**
 *
 * @author rhaihan aditya
 */
public class TarifParkir {
    private double baseRate;
    private double hourlyRate;
    private String vehicleType;

    public TarifParkir(double baseRate, double hourlyRate, String vehicleType) {
        this.baseRate = baseRate;
        this.hourlyRate = hourlyRate;
        this.vehicleType = vehicleType;
    }

    public void setRate(double base, double hourly) {
        this.baseRate = base;
        this.hourlyRate = hourly;
    }

    public double getEffectiveRate() {
        return baseRate + hourlyRate;
    }

    public void applyDiscount(double pct) {
        this.baseRate -= (baseRate * pct / 100.0);
        this.hourlyRate -= (hourlyRate * pct / 100.0);
    }

    public double getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
