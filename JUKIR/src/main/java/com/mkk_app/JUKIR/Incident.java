package com.mkk_app.JUKIR;

import java.time.ZonedDateTime;

/**
 * Catatan insiden dalam sistem parkir (tiket hilang, aktivitas mencurigakan, dll).
 * Digunakan oleh Supervisor.getIncidentReport() dan IncidentLogger.
 */
public class Incident {

    private String incidentId;
    private String incidentType;
    private String description;
    private String petugasId;
    private ZonedDateTime timestamp;
    private String ticketId;
    private boolean isPermanent;

    public Incident() {}

    public Incident(String incidentId, String incidentType, String description,
                    String petugasId, String ticketId) {
        this.incidentId = incidentId;
        this.incidentType = incidentType;
        this.description = description;
        this.petugasId = petugasId;
        this.ticketId = ticketId;
        this.timestamp = ZonedDateTime.now(java.time.ZoneId.of("Asia/Jakarta"));
        this.isPermanent = true;
    }

    // ─── Getters & Setters ─────────────────────────────────────────────────────

    public String getIncidentId() {
        return incidentId;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public String getDescription() {
        return description;
    }

    public String getPetugasId() {
        return petugasId;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public String getTicketId() {
        return ticketId;
    }

    public boolean isPermanent() {
        return isPermanent;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPetugasId(String petugasId) {
        this.petugasId = petugasId;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setPermanent(boolean permanent) {
        this.isPermanent = permanent;
    }

    @Override
    public String toString() {
        return "Incident{id='" + incidentId + "', type='" + incidentType
                + "', petugas='" + petugasId + "', timestamp=" + timestamp + "}";
    }
}
