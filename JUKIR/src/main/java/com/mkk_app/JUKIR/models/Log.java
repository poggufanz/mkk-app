package com.mkk_app.JUKIR.models;

import java.time.LocalDateTime;

/**
 *
 * @author muhammad faiq
 */
public class Log {
    private String logId;
    private String activity;
    private LocalDateTime timestamp;

    public Log(String logId, String activity) {
        this.logId = logId;
        this.activity = activity;
        this.timestamp = LocalDateTime.now();
    }

    public String getLogId() {
        return logId;
    }

    public String getActivity() {
        return activity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
