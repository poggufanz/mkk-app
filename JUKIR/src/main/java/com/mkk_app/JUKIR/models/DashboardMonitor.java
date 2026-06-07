package com.mkk_app.JUKIR.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author muhammad faiq
 */
public class DashboardMonitor {
    private List<Incident> incidents;
    private List<Transaction> activeTx;

    public DashboardMonitor() {
        this.incidents = new ArrayList<>();
        this.activeTx = new ArrayList<>();
    }

    public void refresh() {
        System.out.println("Dashboard Monitor disegarkan. Memuat insiden terbaru dan transaksi aktif.");
    }

    public void addIncident(Incident i) {
        incidents.add(i);
        System.out.println("Insiden baru ditambahkan ke dashboard: " + i.getDescription());
    }

    public List<String> getActiveOfficers() {
        // Returns a dummy list of active officers' usernames for visual representation
        List<String> officers = new ArrayList<>();
        officers.add("Petugas-01");
        officers.add("Petugas-02");
        return officers;
    }

    public List<Incident> getIncidents() {
        return incidents;
    }

    public List<Transaction> getActiveTx() {
        return activeTx;
    }

    public void addActiveTransaction(Transaction tx) {
        activeTx.add(tx);
    }
}
