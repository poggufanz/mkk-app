package com.mkk_app.JUKIR;

import java.time.ZonedDateTime;

/**
 * Log aktivitas pengguna dalam sistem.
 * Digunakan oleh Supervisor.getActivityLog().
 */
public class ActivityLog {

    private String logId;
    private String userId;
    private String action;
    private ZonedDateTime timestamp;

    public ActivityLog() {}

    public ActivityLog(String logId, String userId, String action, ZonedDateTime timestamp) {
        this.logId = logId;
        this.userId = userId;
        this.action = action;
        this.timestamp = timestamp;
    }

    // ─── Getters & Setters ─────────────────────────────────────────────────────

    public String getLogId() {
        return logId;
    }

    public String getUserId() {
        return userId;
    }

    public String getAction() {
        return action;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ActivityLog{logId='" + logId + "', userId='" + userId
                + "', action='" + action + "', timestamp=" + timestamp + "}";
    }
}
