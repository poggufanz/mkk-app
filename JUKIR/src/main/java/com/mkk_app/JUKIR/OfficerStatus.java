package com.mkk_app.JUKIR;

/**
 * Status petugas operasional yang sedang dipantau.
 * Digunakan oleh Supervisor.monitorOfficer().
 */
public class OfficerStatus {

    private String petugasId;
    private boolean isOnDuty;
    private int transactionsToday;
    private String currentPosId;

    public OfficerStatus() {
        this.isOnDuty = false;
        this.transactionsToday = 0;
    }

    // ─── Getters & Setters ─────────────────────────────────────────────────────

    public String getPetugasId() {
        return petugasId;
    }

    public boolean isOnDuty() {
        return isOnDuty;
    }

    public int getTransactionsToday() {
        return transactionsToday;
    }

    public String getCurrentPosId() {
        return currentPosId;
    }

    public void setPetugasId(String petugasId) {
        this.petugasId = petugasId;
    }

    public void setOnDuty(boolean onDuty) {
        this.isOnDuty = onDuty;
    }

    public void setTransactionsToday(int transactionsToday) {
        this.transactionsToday = transactionsToday;
    }

    public void setCurrentPosId(String currentPosId) {
        this.currentPosId = currentPosId;
    }

    @Override
    public String toString() {
        return "OfficerStatus{petugasId='" + petugasId + "', onDuty=" + isOnDuty
                + ", transactions=" + transactionsToday + ", pos='" + currentPosId + "'}";
    }
}
