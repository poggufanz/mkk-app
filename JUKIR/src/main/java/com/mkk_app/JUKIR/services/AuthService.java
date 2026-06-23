package com.mkk_app.JUKIR.services;

import com.mkk_app.JUKIR.enums.Role;
import com.mkk_app.JUKIR.exceptions.InvalidCredentialsException;
import com.mkk_app.JUKIR.models.User;
import java.util.HashMap;

public class AuthService {
    private HashMap<String, User> sessions;

    public AuthService() {
        this.sessions = LocalStorage.getInstance().getUsers();
    }

    public User login(String username, String password) {
        User user = sessions.get(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new InvalidCredentialsException("Username atau password salah!");
        }
        return user;
    }

    public void logout(String username) {
        sessions.remove(username);
    }

    public Role checkRole(User u) {
        return u.getRole();
    }

    public boolean hasPermission(User u, String feature) {
        if (u.getRole() == Role.SUPERVISOR) {
            return true;
        } else if (u.getRole() == Role.STAF_KEUANGAN && feature.contains("Laporan")) {
            return true;
        } else if (u.getRole() == Role.PETUGAS_OPERASIONAL && (feature.contains("Validasi") || feature.contains("Tiket"))) {
            return true;
        }
        return false;
    }

    public HashMap<String, User> getSessions() {
        return sessions;
    }

    public void addSession(String token, User user) {
        sessions.put(token, user);
    }
}
