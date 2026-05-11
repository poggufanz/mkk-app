package com.mkk_app.JUKIR;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Abstract superclass untuk semua pengguna sistem JUKIR.
 * Menyimpan kredensial autentikasi dan informasi dasar user.
 */
public abstract class User {

    protected static final ZoneId ZONE_JAKARTA = ZoneId.of("Asia/Jakarta");

    private String userId;
    private String username;
    private String passwordHash;
    private Role role;
    private Boolean isActive;
    private ZonedDateTime createdAt;

    // ─── Constructor ───────────────────────────────────────────────────────────

    protected User(String userId, String username, String password, Role role) {
        this.userId = userId;
        this.username = username;
        this.passwordHash = hashPassword(password);
        this.role = role;
        this.isActive = true;
        this.createdAt = ZonedDateTime.now(ZONE_JAKARTA);
    }

    public Boolean login(String username, String password) {
        if (!this.username.equals(username)) {
            return false;
        }
        return validateCredentials(password);
    }

    public void logout() {
        // Invalidasi sesi ditangani oleh AuthService
    }

    public Role getRole() {
        return this.role;
    }

    public Boolean validateCredentials(String password) {
        return this.passwordHash.equals(hashPassword(password));
    }

    public void updatePassword(String newPassword) {
        this.passwordHash = hashPassword(newPassword);
    }

    // ─── Private Helpers ──────────────────────────────────────────────────────

    private String hashPassword(String password) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            // Fallback jika SHA-256 tidak tersedia
            return String.valueOf(password.hashCode());
        }
    }

    // ─── Getters ───────────────────────────────────────────────────────────────

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    // ─── Setters ───────────────────────────────────────────────────────────────

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // ─── Override ──────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{userId='" + userId + "', username='" + username
                + "', role=" + role + ", isActive=" + isActive + "}";
    }
}
