package com.mkk_app.JUKIR;

import java.io.File;
import java.time.LocalDate;
import java.time.ZonedDateTime;

/**
 * Subclass User, staf keuangan PT. MKK.
 * Mengelola konfigurasi tarif dan mengekspor laporan pendapatan.
 */
public class StafKeuangan extends User {

    private String stafId;
    private String divisi;
    private ZonedDateTime lastExportDate;

    // ─── Constructor ───────────────────────────────────────────────────────────

    public StafKeuangan(String userId, String username, String password,
                        String stafId, String divisi) {
        super(userId, username, password, Role.STAF_KEUANGAN);
        this.stafId = stafId;
        this.divisi = divisi;
    }

    public RevenueReport generateDailyReport(LocalDate date) {
        // TODO: aggregate transaksi untuk tanggal tertentu
        RevenueReport report = new RevenueReport();
        report.setReportType("DAILY");
        report.setPeriodStart(date);
        report.setPeriodEnd(date);
        report.setGeneratedBy(this.stafId);
        return report;
    }

    public RevenueReport generateMonthlyReport(int month, int year) {
        // TODO: aggregate transaksi untuk bulan/tahun tertentu
        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

        RevenueReport report = new RevenueReport();
        report.setReportType("MONTHLY");
        report.setPeriodStart(start);
        report.setPeriodEnd(end);
        report.setGeneratedBy(this.stafId);
        return report;
    }

    public File exportReport(String reportId, String format) {
        this.lastExportDate = ZonedDateTime.now(ZONE_JAKARTA);
        // TODO: delegate ke RevenueReport.generatePDF() atau generateExcel()
        return null;
    }

    public Boolean configureTarif(TarifParkir tarifData) {
        if (tarifData == null) {
            return false;
        }
        tarifData.activate();
        // TODO: simpan ke ArrayList
        return true;
    }

    public ChartData getRevenueChart(LocalDate startDate, LocalDate endDate) {
        // TODO: aggregate data revenue untuk chart
        return new ChartData();
    }

    // ─── Getters ───────────────────────────────────────────────────────────────

    public String getStafId() {
        return stafId;
    }

    public String getDivisi() {
        return divisi;
    }

    public ZonedDateTime getLastExportDate() {
        return lastExportDate;
    }

    // ─── Setters ───────────────────────────────────────────────────────────────

    public void setDivisi(String divisi) {
        this.divisi = divisi;
    }
}
