package com.mkk_app.JUKIR;

/**
 * Ringkasan shift petugas operasional.
 * Digunakan oleh PetugasOperasional.getShiftSummary().
 */
public class ShiftSummary {

    private String petugasId;
    private int totalTransactions;
    private double totalRevenue;

    public ShiftSummary() {
        this.totalTransactions = 0;
        this.totalRevenue = 0.0;
    }

    // ─── Getters & Setters ─────────────────────────────────────────────────────

    public String getPetugasId() {
        return petugasId;
    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setPetugasId(String petugasId) {
        this.petugasId = petugasId;
    }

    public void setTotalTransactions(int totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    @Override
    public String toString() {
        return "ShiftSummary{petugasId='" + petugasId + "', transactions=" + totalTransactions
                + ", revenue=" + totalRevenue + "}";
    }
}
