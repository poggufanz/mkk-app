package com.mkk_app.JUKIR;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mkk_app.JUKIR.enums.Role;
import com.mkk_app.JUKIR.exceptions.InvalidCredentialsException;
import com.mkk_app.JUKIR.models.User;
import com.mkk_app.JUKIR.services.AuthService;
import org.junit.jupiter.api.Test;

public class AuthServiceTest {

    private final AuthService authService = new AuthService();

    @Test
    void loginSucceedsWithSeededPetugasCredentials() {
        User user = authService.login("petugas", "1234");
        assertEquals(Role.PETUGAS_OPERASIONAL, user.getRole());
    }

    @Test
    void loginSucceedsWithSeededSupervisorCredentials() {
        User user = authService.login("supervisor", "1234");
        assertEquals(Role.SUPERVISOR, user.getRole());
    }

    @Test
    void loginFailsWithWrongPassword() {
        assertThrows(InvalidCredentialsException.class, () -> authService.login("petugas", "wrong"));
    }

    @Test
    void loginFailsWithUnknownUsername() {
        assertThrows(InvalidCredentialsException.class, () -> authService.login("nobody", "1234"));
    }

    @Test
    void supervisorHasPermissionForEveryFeature() {
        User supervisor = authService.login("supervisor", "1234");
        assertTrue(authService.hasPermission(supervisor, "AnyFeature"));
    }

    @Test
    void petugasOnlyHasPermissionForTicketAndValidationFeatures() {
        User petugas = authService.login("petugas", "1234");
        assertTrue(authService.hasPermission(petugas, "ValidasiTiket"));
        assertFalse(authService.hasPermission(petugas, "LaporanKeuangan"));
    }

    @Test
    void stafKeuanganOnlyHasPermissionForLaporanFeatures() {
        User staf = authService.login("staf", "1234");
        assertTrue(authService.hasPermission(staf, "LaporanBulanan"));
        assertFalse(authService.hasPermission(staf, "ValidasiTiket"));
    }
}
