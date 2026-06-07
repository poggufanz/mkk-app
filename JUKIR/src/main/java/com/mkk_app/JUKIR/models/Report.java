package com.mkk_app.JUKIR.models;

import java.time.LocalDateTime;

/**
 *
 * @author muhammad faiq
 */
public class Report {
    private String reportId;
    private String title;
    private LocalDateTime generatedAt;
    private String content;

    public Report(String reportId, String title, String content) {
        this.reportId = reportId;
        this.title = title;
        this.generatedAt = LocalDateTime.now();
        this.content = content;
    }

    public String getReportId() {
        return reportId;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public String getContent() {
        return content;
    }
}
