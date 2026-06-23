package com.mkk_app.JUKIR.models;

import com.mkk_app.JUKIR.services.LocalStorage;
import java.util.ArrayList;

public class DashboardMonitor {

    public DashboardMonitor() {
    }

    public void refresh() {
        LocalStorage.getInstance().getIncidents();
        LocalStorage.getInstance().getTransactions();
        System.out.println("Dashboard diperbarui.");
    }

    public void addIncident(Incident i) {
        LocalStorage.getInstance().getIncidents().add(i);
        LocalStorage.getInstance().saveIncidents();
    }

    public ArrayList<String> getActiveOfficers() {
        ArrayList<String> officers = new ArrayList<>();
        officers.add("Petugas-01");
        officers.add("Petugas-02");
        return officers;
    }

    public ArrayList<Incident> getIncidents() {
        return LocalStorage.getInstance().getIncidents();
    }

    public ArrayList<Transaction> getActiveTx() {
        return LocalStorage.getInstance().getTransactions();
    }

    public void addActiveTransaction(Transaction tx) {
        LocalStorage.getInstance().getTransactions().add(tx);
        LocalStorage.getInstance().saveTransactions();
    }
}
