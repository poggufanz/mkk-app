package com.mkk_app.JUKIR.models;

import java.time.LocalDateTime;

/**
 *
 * @author muhammad faiq
 */
public class DateRange {
    private LocalDateTime start;
    private LocalDateTime end;

    public DateRange(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public boolean contains(LocalDateTime dateTime) {
        return (dateTime.isAfter(start) || dateTime.isEqual(start)) && 
               (dateTime.isBefore(end) || dateTime.isEqual(end));
    }
}
