package com.mkk_app.JUKIR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Data chart untuk visualisasi revenue.
 * Digunakan oleh StafKeuangan.getRevenueChart().
 */
public class ChartData {

    private String chartType;
    private List<String> labels;
    private Map<String, List<Double>> datasets;

    public ChartData() {
        this.chartType = "BAR";
        this.labels = new ArrayList<>();
        this.datasets = new HashMap<>();
    }

    // ─── Getters & Setters ─────────────────────────────────────────────────────

    public String getChartType() { return chartType; }
    public List<String> getLabels() { return labels; }
    public Map<String, List<Double>> getDatasets() { return datasets; }

    public void setChartType(String chartType) { this.chartType = chartType; }
    public void setLabels(List<String> labels) { this.labels = labels; }
    public void setDatasets(Map<String, List<Double>> datasets) { this.datasets = datasets; }
}
