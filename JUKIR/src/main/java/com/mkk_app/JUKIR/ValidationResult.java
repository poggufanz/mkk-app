package com.mkk_app.JUKIR;

/**
 * Hasil validasi kendaraan keluar.
 * Digunakan oleh PetugasOperasional.validateVehicleExit().
 */
public class ValidationResult {

    private boolean valid;
    private String message;

    public ValidationResult() {
        this.valid = false;
        this.message = "";
    }

    public ValidationResult(boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }

    // ─── Getters & Setters ─────────────────────────────────────────────────────

    public boolean isValid() {
        return valid;
    }

    public String getMessage() {
        return message;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ValidationResult{valid=" + valid + ", message='" + message + "'}";
    }
}
