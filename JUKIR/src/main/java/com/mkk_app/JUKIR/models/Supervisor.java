package com.mkk_app.JUKIR.models;

import com.mkk_app.JUKIR.enums.Role;
import com.mkk_app.JUKIR.interfaces.INotifiable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rhaihan aditya
 */
public class Supervisor extends User implements INotifiable {
    private List<User> teamList;
    private Date shiftDate;
    private List<String> notifLog;

    public Supervisor(String userId, String username, String password, Date shiftDate) {
        super(userId, username, password, Role.SUPERVISOR);
        this.teamList = new ArrayList<>();
        this.shiftDate = shiftDate;
        this.notifLog = new ArrayList<>();
    }

    public void monitorDashboard() {
        System.out.println("Supervisor " + username + " sedang memantau dashboard.");
    }

    @Override
    public void sendNotification(String msg) {
        notifLog.add(msg);
        System.out.println("Notifikasi dikirim ke Supervisor " + username + ": " + msg);
    }

    @Override
    public List getNotifLog() {
        return notifLog;
    }

    public void approveIncident() {
        System.out.println("Supervisor " + username + " menyetujui insiden.");
    }

    @Override
    public List getAccessMenu() {
        List<String> menu = new ArrayList<>();
        menu.add("1. Dashboard Monitor");
        menu.add("2. Log Aktivitas");
        menu.add("3. Manajemen User");
        menu.add("4. Ganti Password");
        menu.add("5. Keluar");
        return menu;
    }

    public List<User> getTeamList() {
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
