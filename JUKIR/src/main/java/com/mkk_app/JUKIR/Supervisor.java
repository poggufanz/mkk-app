package com.mkk_app.JUKIR;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Subclass User, supervisor/pengawas operasional.
 * Mengakses dashboard real-time dan log aktivitas petugas.
 */
public class Supervisor extends User {

    private String supervisorId;
    private String divisiArea;
    private ZonedDateTime lastLoginDashboard;

    // ─── Constructor ───────────────────────────────────────────────────────────

    public Supervisor(String userId, String username, String password,
                      String supervisorId, String divisiArea) {
        super(userId, username, password, Role.SUPERVISOR);
        this.supervisorId = supervisorId;
        this.divisiArea = divisiArea;
    }

    public DashboardData viewDashboard() {
        this.lastLoginDashboard = ZonedDateTime.now(ZONE_JAKARTA);
        // TODO: delegate ke DashboardMonitor
        return new DashboardData();
    }

    public List<ActivityLog> getActivityLog(LocalDate startDate, LocalDate endDate) {
        // todo: query dari ArrayList/IncidentLogger
        return new ArrayList<>();
    }

    public List<Incident> getIncidentReport() {
        // todo: delegate ke IncidentLogger
        return new ArrayList<>();
    }

    public OfficerStatus monitorOfficer(String petugasId) {
        // todo: delegate ke DashboardMonitor
        return new OfficerStatus();
    }

    // ─── Getters ───────────────────────────────────────────────────────────────

    public String getSupervisorId() {
        return supervisorId;
    }

    public String getDivisiArea() {
        return divisiArea;
    }

    public ZonedDateTime getLastLoginDashboard() {
        return lastLoginDashboard;
    }

    // ─── Setters ───────────────────────────────────────────────────────────────

    public void setDivisiArea(String divisiArea) {
        this.divisiArea = divisiArea;
    }
}
