package com.mkk_app.JUKIR.models;

import com.mkk_app.JUKIR.exceptions.ValidationException;
import com.mkk_app.JUKIR.services.LocalStorage;
import java.util.ArrayList;

public class VehicleExitQueue {
    private int maxCapacity;

    public VehicleExitQueue(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void enqueue(ParkingTicket t) {
        ArrayList<ParkingTicket> queue = LocalStorage.getInstance().getTicketQueue();
        if (queue.size() < maxCapacity) {
            queue.add(t);
            LocalStorage.getInstance().saveTickets();
        } else {
            throw new ValidationException("Antrean keluar penuh.");
        }
    }

    public ParkingTicket dequeue() {
        ArrayList<ParkingTicket> queue = LocalStorage.getInstance().getTicketQueue();
        if (queue.isEmpty()) {
            return null;
        }
        ParkingTicket t = queue.remove(0);
        LocalStorage.getInstance().saveTickets();
        return t;
    }

    public int getQueueSize() {
        return LocalStorage.getInstance().getTicketQueue().size();
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
