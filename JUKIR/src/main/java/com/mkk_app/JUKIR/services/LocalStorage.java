package com.mkk_app.JUKIR.services;

import com.mkk_app.JUKIR.models.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class LocalStorage {
    private static LocalStorage instance;
    
    private ArrayList<Incident> incidents;
    private ArrayList<Transaction> transactions;
    private ArrayList<ParkingTicket> ticketQueue;
    private HashMap<String, User> users;
    private TarifParkir tarifParkir;
    private boolean gateIsOpen;

    private static final String DIR = "storage";
    private static final String FILE_INCIDENTS = DIR + "/incidents.txt";
    private static final String FILE_TRANSACTIONS = DIR + "/transactions.txt";
    private static final String FILE_TARIF = DIR + "/tarif.txt";
    private static final String FILE_GATE = DIR + "/gate.txt";
    private static final String FILE_TICKETS = DIR + "/tickets.txt";

    private LocalStorage() {
        incidents = new ArrayList<>();
        transactions = new ArrayList<>();
        ticketQueue = new ArrayList<>();
        users = new HashMap<>();
        tarifParkir = new TarifParkir(3000, 2000, "mobil");
        gateIsOpen = false;
        
        try {
            Files.createDirectories(Paths.get(DIR));
        } catch (IOException e) {}

        loadAll();
        DataSeeder.seedIfEmpty(this);
    }

    public static synchronized LocalStorage getInstance() {
        if (instance == null) {
            instance = new LocalStorage();
        }
        return instance;
    }

    private void loadAll() {
        loadIncidents();
        loadTransactions();
        loadTarif();
        loadGate();
        loadTickets();
    }

    private void loadIncidents() {
        incidents.clear();
        File f = new File(FILE_INCIDENTS);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 3) {
                    Incident inc = new Incident(parts[0], parts[1]);
                    inc.setStatus(parts[2]);
                    incidents.add(inc);
                }
            }
        } catch (IOException e) {}
    }

    private void loadTransactions() {
        transactions.clear();
        File f = new File(FILE_TRANSACTIONS);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 3) {
                    ParkingTicket t = new ParkingTicket(parts[2]);
                    Transaction tx = new Transaction(parts[0], Double.parseDouble(parts[1]), t);
                    transactions.add(tx);
                }
            }
        } catch (IOException e) {}
    }

    private void loadTarif() {
        File f = new File(FILE_TARIF);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line = br.readLine();
            if (line != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 3) {
                    tarifParkir = new TarifParkir(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]), parts[2]);
                }
            }
        } catch (IOException e) {}
    }

    private void loadGate() {
        File f = new File(FILE_GATE);
        if (!f.exists()) {
            gateIsOpen = false;
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line = br.readLine();
            if (line != null) {
                gateIsOpen = Boolean.parseBoolean(line.trim());
            }
        } catch (IOException e) {}
    }

    private void loadTickets() {
        ticketQueue.clear();
        File f = new File(FILE_TICKETS);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 1) {
                    ParkingTicket t = new ParkingTicket(parts[0]);
                    if (parts.length >= 2 && !parts[1].equals("-")) {
                        t.addPhoto(new Image(parts[1]));
                    }
                    ticketQueue.add(t);
                }
            }
        } catch (IOException e) {}
    }

    public void saveIncidents() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_INCIDENTS))) {
            for (Incident i : incidents) {
                pw.println(i.getIncidentId() + "|" + i.getDescription() + "|" + i.getStatus());
            }
        } catch (IOException e) {}
    }

    public void saveTransactions() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_TRANSACTIONS))) {
            for (Transaction tx : transactions) {
                pw.println(tx.getTxId() + "|" + tx.getAmount() + "|" + tx.getTicket().getTicketId());
            }
        } catch (IOException e) {}
    }

    public void saveTarif() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_TARIF))) {
            pw.println(tarifParkir.getBaseRate() + "|" + tarifParkir.getHourlyRate() + "|" + tarifParkir.getVehicleType());
        } catch (IOException e) {}
    }

    public void saveGate() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_GATE))) {
            pw.println(gateIsOpen);
        } catch (IOException e) {}
    }

    public void saveTickets() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_TICKETS))) {
            for (ParkingTicket t : ticketQueue) {
                String photoPath = (!t.getPhotos().isEmpty()) ? t.getPhotos().get(0).getPath() : "-";
                pw.println(t.getTicketId() + "|" + photoPath);
            }
        } catch (IOException e) {}
    }

    public ArrayList<Incident> getIncidents() {
        return incidents;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public ArrayList<ParkingTicket> getTicketQueue() {
        return ticketQueue;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public TarifParkir getTarifParkir() {
        return tarifParkir;
    }

    public void setTarifParkir(TarifParkir tarifParkir) {
        this.tarifParkir = tarifParkir;
        saveTarif();
    }

    public boolean isGateOpen() {
        return gateIsOpen;
    }

    public void setGateOpen(boolean open) {
        this.gateIsOpen = open;
        saveGate();
    }
}
