package com.mkk_app.JUKIR;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mkk_app.JUKIR.models.TarifParkir;
import com.mkk_app.JUKIR.services.TarifCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TarifCalculatorTest {

    private final TarifCalculator calculator =
            new TarifCalculator(new TarifParkir(3000, 2000, "mobil"));

    @ParameterizedTest
    @CsvSource({
        "30, mobil, 3000",
        "60, mobil, 3000",
        "61, mobil, 5000",
        "120, mobil, 5000",
        "121, mobil, 7000",
        "30, motor, 1500",
        "90, motor, 2500"
    })
    void calculatesFareByDurationAndVehicleType(int minutes, String type, double expected) {
        assertEquals(expected, calculator.calculate(minutes, type));
    }
}
