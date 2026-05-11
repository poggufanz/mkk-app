package com.mkk_app.JUKIR;

import java.util.ArrayList;
import java.util.List;

/**
 * Data dashboard real-time untuk Supervisor.
 * Digunakan oleh Supervisor.viewDashboard().
 */
public class DashboardData {

    private int activeVehicles;
    private double todayRevenue;
    private int todayTransactions;
    private List<String> activeOfficerIds;

    public DashboardData() {
        this.activeVehicles = 0;
        this.todayRevenue = 0.0;
        this.todayTransactions = 0;
        this.activeOfficerIds = new ArrayList<>();
    }

    // ─── Getters & Setters ─────────────────────────────────────────────────────

    public int getActiveVehicles() {
        return activeVehicles;
    }

    public double getTodayRevenue() {
        return todayRevenue;
    }

    public int getTodayTransactions() {
        return todayTransactions;
    }

    public List<String> getActiveOfficerIds() {
        return activeOfficerIds;
    }

    public void setActiveVehicles(int activeVehicles) {
        this.activeVehicles = activeVehicles;
    }

    public void setTodayRevenue(double todayRevenue) {
        this.todayRevenue = todayRevenue;
    }

    public void setTodayTransactions(int todayTransactions) {
        this.todayTransactions = todayTransactions;
    }

    public void setActiveOfficerIds(List<String> activeOfficerIds) {
        this.activeOfficerIds = activeOfficerIds;
    }
}
