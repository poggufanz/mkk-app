package com.mkk_app.JUKIR.models;

import com.mkk_app.JUKIR.enums.Role;
import com.mkk_app.JUKIR.interfaces.IReportable;
import com.mkk_app.JUKIR.services.LocalStorage;
import java.util.ArrayList;

public class StafKeuangan extends User implements IReportable {
    private ArrayList<Report> reportHistory;
    private ArrayList<Log> auditLogs;

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
        return report;
    }

    @Override
    public void exportTo(String format) {
        auditLogs.add(new Log("LOG-" + System.currentTimeMillis(), "Export report in format: " + format));
    }

    public void configTarif(double tarifDasar, double tarifProgresif) {
        TarifParkir tarif = LocalStorage.getInstance().getTarifParkir();
        tarif.setRate(tarifDasar, tarifProgresif);
        LocalStorage.getInstance().setTarifParkir(tarif);
        auditLogs.add(new Log("LOG-" + System.currentTimeMillis(),
            "Tarif diubah: dasar=" + tarifDasar + ", progresif=" + tarifProgresif));
    }

    @Override
    public ArrayList<String> getAccessMenu() {
        ArrayList<String> menu = new ArrayList<>();
        menu.add("1. Laporan Pendapatan");
        menu.add("2. Ekspor Laporan");
        menu.add("3. Konfigurasi Tarif");
        menu.add("4. Ganti Password");
        menu.add("5. Keluar");
        return menu;
    }

    public ArrayList<Report> getReportHistory() {
        return reportHistory;
    }

    public ArrayList<Log> getAuditLogs() {
        return auditLogs;
    }
}
