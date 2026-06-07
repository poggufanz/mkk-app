package com.mkk_app.JUKIR.models;

import com.mkk_app.JUKIR.enums.Role;
import com.mkk_app.JUKIR.interfaces.IReportable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rhaihan aditya
 */
public class StafKeuangan extends User implements IReportable {
    private List<Report> reportHistory;
    private List<Log> auditLogs;

    public StafKeuangan(String userId, String username, String password) {
        super(userId, username, password, Role.STAF_KEUANGAN);
        this.reportHistory = new ArrayList<>();
        this.auditLogs = new ArrayList<>();
    }

    @Override
    public Report generateReport() {
        Report report = new Report("REP-" + System.currentTimeMillis(), "Laporan Pendapatan Keuangan", "Data Pendapatan JUKIR");
        reportHistory.add(report);
        auditLogs.add(new Log("LOG-" + System.currentTimeMillis(), "Generate report: " + report.getReportId()));
        System.out.println("Staf Keuangan " + username + " menghasilkan laporan.");
        return report;
    }

    @Override
    public void exportTo(String format) {
        auditLogs.add(new Log("LOG-" + System.currentTimeMillis(), "Export report in format: " + format));
        System.out.println("Laporan di-ekspor ke format: " + format);
    }

    public void configTarif() {
        auditLogs.add(new Log("LOG-" + System.currentTimeMillis(), "Mengonfigurasi tarif"));
        System.out.println("Staf Keuangan " + username + " mengonfigurasi tarif parkir.");
    }

    @Override
    public List getAccessMenu() {
        List<String> menu = new ArrayList<>();
        menu.add("1. Laporan Pendapatan");
        menu.add("2. Ekspor Laporan");
        menu.add("3. Konfigurasi Tarif");
        menu.add("4. Ganti Password");
        menu.add("5. Keluar");
        return menu;
    }

    public List<Report> getReportHistory() {
        return reportHistory;
    }

    public List<Log> getAuditLogs() {
        return auditLogs;
    }
}
