package com.mkk_app.JUKIR.models;

import java.time.LocalDateTime;

/**
 *
 * @author muhammad faiq
 */
public class Incident {
    private String incidentId;
    private String description;
    private LocalDateTime timestamp;
    private String status;

    public Incident(String incidentId, String description) {
        this.incidentId = incidentId;
        this.description = description;
        this.timestamp = LocalDateTime.now();
        this.status = "PENDING";
    }

    public String getIncidentId() {
        return incidentId;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
