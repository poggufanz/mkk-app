package com.mkk_app.JUKIR.services;

import com.mkk_app.JUKIR.models.ParkingTicket;
import com.mkk_app.JUKIR.models.TarifParkir;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author rhaihan aditya
 */
public class TarifCalculator {
    private TarifParkir tarifConfig;

    public TarifCalculator(TarifParkir tarifConfig) {
        this.tarifConfig = tarifConfig;
    }

    public double calculate(int minutes) {
        return calculate(minutes, tarifConfig.getVehicleType());
    }

    public double calculate(LocalDateTime entry, LocalDateTime exit) {
        long minutes = Duration.between(entry, exit).toMinutes();
        return calculate((int) minutes, tarifConfig.getVehicleType());
    }

    public double calculate(ParkingTicket ticket) {
        long minutes = Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toMinutes();
        return calculate((int) minutes, tarifConfig.getVehicleType());
    }

    public double calculate(int minutes, String type) {
        double base = tarifConfig.getBaseRate();
        double hourly = tarifConfig.getHourlyRate();

        if (type != null && type.equalsIgnoreCase("motor")) {
            base *= 0.5;
            hourly *= 0.5;
        }

        if (minutes <= 60) {
            return base;
        } else {
            int jamTambahan = (int) Math.ceil((minutes - 60) / 60.0);
            return base + (jamTambahan * hourly);
        }
    }

    public TarifParkir getTarifConfig() {
        return tarifConfig;
    }

    public void setTarifConfig(TarifParkir tarifConfig) {
        this.tarifConfig = tarifConfig;
    }
}
