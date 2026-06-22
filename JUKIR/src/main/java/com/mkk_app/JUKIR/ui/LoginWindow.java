/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mkk_app.JUKIR.ui;

import com.mkk_app.JUKIR.enums.Role;
import com.mkk_app.JUKIR.models.PetugasOperasional;
import com.mkk_app.JUKIR.models.Supervisor;
import com.mkk_app.JUKIR.models.StafKeuangan;
import com.mkk_app.JUKIR.models.User;
import com.mkk_app.JUKIR.services.AuthService;
import com.mkk_app.JUKIR.exceptions.InvalidCredentialsException;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author rhaihan aditya
 */
public class LoginWindow extends javax.swing.JFrame {
    
    private AuthService authService;

    public LoginWindow() {
        initComponents();
        authService = new AuthService();
        User petugas = new PetugasOperasional("U001", "petugas", "1234", LocalDateTime.now(), 1);
        User supervisor = new Supervisor("U002", "supervisor", "1234", new Date());
        User staf = new StafKeuangan("U003", "staf", "1234");
        authService.addSession("petugas", petugas);
        authService.addSession("supervisor", supervisor);
        authService.addSession("staf", staf);
        applyStyle();
    }

    private void applyStyle() {
        setTitle("Sistem JUKIR - Login");
        setSize(380, 280);
        setLocationRelativeTo(null);
        lblTitle.setFont(new Font("Dialog", Font.BOLD, 18));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfo.setFont(new Font("Dialog", Font.PLAIN, 12));
        lblInfo.setForeground(Color.DARK_GRAY);
        lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setFont(new Font("Dialog", Font.PLAIN, 13));
        lblPassword.setFont(new Font("Dialog", Font.PLAIN, 13));
        inpUsername.setFont(new Font("Dialog", Font.PLAIN, 13));
        inpPassword.setFont(new Font("Dialog", Font.PLAIN, 13));
        btnLogin.setFont(new Font("Dialog", Font.BOLD, 13));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        inpUsername = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();
        inpPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Sistem JUKIR - Login");

        lblUsername.setText("Username :");

        lblPassword.setText("Password :");

        inpUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpUsernameActionPerformed(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfo.setText("Masukkan username dan password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(inpUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(inpPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitle)
                .addGap(6, 6, 6)
                .addComponent(lblInfo)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(inpUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(inpPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btnLogin)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String username = inpUsername.getText().trim();
        String password = new String(inpPassword.getPassword()).trim();
        if (username.isEmpty() || password.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, 
                    "Username dan password tidak boleh kosong.",
                    "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            User user = authService.login(username, password);
            user.login();
            dispose();
            Role role = user.getRole();
            if (role == Role.PETUGAS_OPERASIONAL){
                new ExitGatePanel((PetugasOperasional) user).setVisible(true);
            } else if (role == Role.SUPERVISOR) {
                new SupervisorDashboard((Supervisor) user).setVisible(true);
            } else if (role == Role.STAF_KEUANGAN) {
                new FinancePanel((StafKeuangan) user).setVisible(true);
            }
        } catch (InvalidCredentialsException ex) {
            lblInfo.setForeground(java.awt.Color.RED);
            lblInfo.setText(ex.getMessage());
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void inpUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpUsernameActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JPasswordField inpPassword;
    private javax.swing.JTextField inpUsername;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables
}
