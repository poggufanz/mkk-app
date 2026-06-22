package com.mkk_app.JUKIR.models;

import com.mkk_app.JUKIR.enums.Role;
import com.mkk_app.JUKIR.interfaces.INotifiable;
import java.util.ArrayList;
import java.util.Date;

public class Supervisor extends User implements INotifiable {
    private ArrayList<User> teamList;
    private Date shiftDate;
    private ArrayList<String> notifLog;

    public Supervisor(String userId, String username, String password, Date shiftDate) {
        super(userId, username, password, Role.SUPERVISOR);
        this.teamList = new ArrayList<>();
        this.shiftDate = shiftDate;
        this.notifLog = new ArrayList<>();
    }

    public void monitorDashboard() {
        System.out.println("Supervisor " + username + " membuka dashboard.");
    }

    @Override
    public void sendNotification(String msg) {
        notifLog.add(msg);
    }

    @Override
    public ArrayList<String> getNotifLog() {
        return notifLog;
    }

    public void approveIncident() {
        System.out.println("Insiden ditinjau oleh Supervisor: " + username);
    }

    @Override
    public ArrayList<String> getAccessMenu() {
        ArrayList<String> menu = new ArrayList<>();
        menu.add("1. Dashboard Monitor");
        menu.add("2. Log Aktivitas");
        menu.add("3. Manajemen User");
        menu.add("4. Ganti Password");
        menu.add("5. Keluar");
        return menu;
    }

    public ArrayList<User> getTeamList() {
        return teamList;
    }

    public void addTeamMember(User u) {
        teamList.add(u);
    }

    public Date getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(Date shiftDate) {
        this.shiftDate = shiftDate;
    }
}
