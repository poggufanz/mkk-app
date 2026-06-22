package com.mkk_app.JUKIR.models;

import com.mkk_app.JUKIR.enums.TicketStatus;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ParkingTicket {
    private String ticketId;
    private ArrayList<Image> photos;
    private LocalDateTime entryTime;
    private TicketStatus status;

    public ParkingTicket(String ticketId) {
        this.ticketId = ticketId;
        this.photos = new ArrayList<>();
        this.entryTime = LocalDateTime.now();
        this.status = TicketStatus.ACTIVE;
    }

    public void addPhoto(Image img) {
        photos.add(img);
    }

    public ArrayList<Image> getPhotos() {
        return photos;
    }

    public void markAsLost() {
        this.status = TicketStatus.LOST;
    }

    public String getTicketId() {
        return ticketId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
}
