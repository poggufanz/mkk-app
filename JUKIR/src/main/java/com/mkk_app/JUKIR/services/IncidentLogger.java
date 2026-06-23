package com.mkk_app.JUKIR.services;

import com.mkk_app.JUKIR.interfaces.INotifiable;
import com.mkk_app.JUKIR.models.Incident;
import java.util.ArrayList;

public class IncidentLogger implements INotifiable {
    private String logFile;
    private ArrayList<Incident> permanentLogs;
    private ArrayList<String> notifications;

    public IncidentLogger(String logFile) {
        this.logFile = logFile;
        this.permanentLogs = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public void logIncident(Incident i) {
        LocalStorage.getInstance().getIncidents().add(i);
        LocalStorage.getInstance().saveIncidents();
    }

    @Override
    public void sendNotification(String msg) {
        notifications.add(msg);
    }

    @Override
    public ArrayList<String> getNotifLog() {
        return notifications;
    }

    public ArrayList<Incident> getLogs() {
        return LocalStorage.getInstance().getIncidents();
    }

    public String getLogFile() {
        return logFile;
    }

    public void setLogFile(String logFile) {
        this.logFile = logFile;
    }

    public void checkSuspiciousActivity() {
        ArrayList<Incident> semuaInsiden = LocalStorage.getInstance().getIncidents();
        int jumlahTiketHilang = 0;
        for (Incident inc : semuaInsiden) {
            if (inc.getDescription().toLowerCase().contains("tiket hilang")) {
                jumlahTiketHilang++;
            }
        }
        if (jumlahTiketHilang > 3) {
            Incident suspicious = new Incident(
                "INC-SUSPICIOUS-" + System.currentTimeMillis(),
                "AKTIVITAS MENCURIGAKAN: Tiket hilang terlalu banyak (" + jumlahTiketHilang + " kali)"
            );
            suspicious.setStatus("FLAGGED");
            logIncident(suspicious);
            sendNotification("PERINGATAN: Aktivitas mencurigakan terdeteksi! Tiket hilang: " + jumlahTiketHilang + " kali.");
        }
    }
}
