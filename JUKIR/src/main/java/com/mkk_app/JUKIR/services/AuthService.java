package com.mkk_app.JUKIR.services;

import com.mkk_app.JUKIR.enums.Role;
import com.mkk_app.JUKIR.models.User;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rhaihan aditya
 */
public class AuthService {
    private Map<String, User> sessions;

    public AuthService() {
        this.sessions = new HashMap<>();
    }

    public boolean login(String u, String p) {
        // Simple auth mock for matching signature
        if (u != null && p != null && !u.isEmpty()) {
            System.out.println("Login berhasil untuk pengguna: " + u);
            return true;
        }
        return false;
    }

    public void logout(String userId) {
        sessions.remove(userId);
        System.out.println("Pengguna " + userId + " berhasil logout.");
    }

    public Role checkRole(User u) {
        return u.getRole();
    }

    public boolean hasPermission(User u, String feature) {
        // Simple mock permission check based on role
        if (u.getRole() == Role.SUPERVISOR) {
            return true;
        } else if (u.getRole() == Role.STAF_KEUANGAN && feature.contains("Laporan")) {
            return true;
        } else if (u.getRole() == Role.PETUGAS_OPERASIONAL && (feature.contains("Validasi") || feature.contains("Tiket"))) {
            return true;
        }
        return false;
    }

    public Map<String, User> getSessions() {
        return sessions;
    }

    public void addSession(String token, User user) {
        sessions.put(token, user);
    }
}
