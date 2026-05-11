package com.mkk_app.JUKIR;

import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Laporan pendapatan parkir (harian/bulanan).
 * Entity Layer 2 — stub untuk kebutuhan Layer 1.
 */
public class RevenueReport {

    private static final ZoneId ZONE_JAKARTA = ZoneId.of("Asia/Jakarta");

    private String reportId;
    private String reportType;
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private double totalRevenue;
    private int totalTransactions;
    private Map<String, Double> breakdown;
    private String generatedBy;
    private ZonedDateTime generatedAt;

    public RevenueReport() {
        this.generatedAt = ZonedDateTime.now(ZONE_JAKARTA);
        this.breakdown = new HashMap<>();
        this.totalRevenue = 0.0;
        this.totalTransactions = 0;
    }

    public File generatePDF() {
        // todo: implementasi PDF generation
        return null;
    }

    public File generateExcel() {
        // todo: implementasi Excel generation
        return null;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public int getTransactionCount() {
        return totalTransactions;
    }

    public Map<String, Double> getRevenueByVehicleType() {
        return breakdown;
    }

    // ─── Getters ───────────────────────────────────────────────────────────────

    public String getReportId() { return reportId; }
    public String getReportType() { return reportType; }
    public LocalDate getPeriodStart() { return periodStart; }
    public LocalDate getPeriodEnd() { return periodEnd; }
    public int getTotalTransactions() { return totalTransactions; }
    public Map<String, Double> getBreakdown() { return breakdown; }
    public String getGeneratedBy() { return generatedBy; }
    public ZonedDateTime getGeneratedAt() { return generatedAt; }

    // ─── Setters ───────────────────────────────────────────────────────────────

    public void setReportId(String reportId) { this.reportId = reportId; }
    public void setReportType(String reportType) { this.reportType = reportType; }
    public void setPeriodStart(LocalDate periodStart) { this.periodStart = periodStart; }
    public void setPeriodEnd(LocalDate periodEnd) { this.periodEnd = periodEnd; }
    public void setTotalRevenue(double totalRevenue) { this.totalRevenue = totalRevenue; }
    public void setTotalTransactions(int totalTransactions) { this.totalTransactions = totalTransactions; }
    public void setBreakdown(Map<String, Double> breakdown) { this.breakdown = breakdown; }
    public void setGeneratedBy(String generatedBy) { this.generatedBy = generatedBy; }
}
