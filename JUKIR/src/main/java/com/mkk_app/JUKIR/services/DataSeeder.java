package com.mkk_app.JUKIR.services;

import com.mkk_app.JUKIR.models.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Seeds initial application data (users, tickets, transactions, incidents)
 * into a LocalStorage instance the first time it is empty, so the app has
 * usable data on a fresh checkout without a database.
 */
public class DataSeeder {

    private DataSeeder() {}

    public static void seedIfEmpty(LocalStorage storage) {
        seedUsers(storage);
        seedTickets(storage);
        seedTransactions(storage);
        seedIncidents(storage);
    }

    private static void seedUsers(LocalStorage storage) {
        if (!storage.getUsers().isEmpty()) return;
        storage.getUsers().put("petugas", new PetugasOperasional("U001", "petugas", "1234", LocalDateTime.now(), 1));
        storage.getUsers().put("supervisor", new Supervisor("U002", "supervisor", "1234", new Date()));
        storage.getUsers().put("staf", new StafKeuangan("U003", "staf", "1234"));
    }

    private static void seedTickets(LocalStorage storage) {
        if (!storage.getTicketQueue().isEmpty()) return;
        ParkingTicket t1 = new ParkingTicket("TKT-001");
        t1.addPhoto(new Image("foto/plat_001.jpg"));
        ParkingTicket t2 = new ParkingTicket("TKT-002");
        storage.getTicketQueue().add(t1);
        storage.getTicketQueue().add(t2);
        storage.saveTickets();
    }

    private static void seedTransactions(LocalStorage storage) {
        if (!storage.getTransactions().isEmpty()) return;
        storage.getTransactions().add(new Transaction("TX-001", 5000, new ParkingTicket("TKT-001")));
        storage.saveTransactions();
    }

    private static void seedIncidents(LocalStorage storage) {
        if (!storage.getIncidents().isEmpty()) return;
        Incident sample = new Incident("INC-001", "Kendaraan tidak terdaftar masuk lewat gate utama");
        sample.setStatus("RESOLVED");
        storage.getIncidents().add(sample);
        storage.saveIncidents();
    }
}
