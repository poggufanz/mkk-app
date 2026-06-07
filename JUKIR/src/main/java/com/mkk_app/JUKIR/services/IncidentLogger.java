package com.mkk_app.JUKIR.services;

import com.mkk_app.JUKIR.interfaces.INotifiable;
import com.mkk_app.JUKIR.models.Incident;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author muhammad faiq
 */
public class IncidentLogger implements INotifiable {
    private String logFile;
    private List<Incident> permanentLogs;
    private List<String> notifications;

    public IncidentLogger(String logFile) {
        this.logFile = logFile;
        this.permanentLogs = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public void logIncident(Incident i) {
        permanentLogs.add(i);
        System.out.println("Insiden dicatat secara permanen di " + logFile + ": " + i.getDescription());
    }

    @Override
    public void sendNotification(String msg) {
        notifications.add(msg);
        System.out.println("Notifikasi dikirim ke logger: " + msg);
    }

    @Override
    public List getNotifLog() {
        return notifications;
    }

    public List<Incident> getLogs() {
        return permanentLogs;
    }

    public String getLogFile() {
        return logFile;
    }

    public void setLogFile(String logFile) {
        this.logFile = logFile;
    }
}
