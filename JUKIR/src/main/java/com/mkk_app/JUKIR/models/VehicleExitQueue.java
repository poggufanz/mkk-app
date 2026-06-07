package com.mkk_app.JUKIR.models;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author muhammad faiq
 */
public class VehicleExitQueue {
    private Queue<ParkingTicket> queue;
    private int maxCapacity;

    public VehicleExitQueue(int maxCapacity) {
        this.queue = new LinkedList<>();
        this.maxCapacity = maxCapacity;
    }

    public void enqueue(ParkingTicket t) {
        if (queue.size() < maxCapacity) {
            queue.add(t);
            System.out.println("Tiket " + t.getTicketId() + " dimasukkan ke antrean keluar.");
        } else {
            System.out.println("Antrean keluar penuh.");
        }
    }

    public ParkingTicket dequeue() {
        return queue.poll();
    }

    public int getQueueSize() {
        return queue.size();
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
