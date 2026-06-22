/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mkk_app.JUKIR.ui;

import com.mkk_app.JUKIR.models.Image;
import com.mkk_app.JUKIR.models.Incident;
import com.mkk_app.JUKIR.models.ParkingTicket;
import com.mkk_app.JUKIR.models.PetugasOperasional;
import com.mkk_app.JUKIR.models.VehicleExitQueue;
import com.mkk_app.JUKIR.services.GateController;
import com.mkk_app.JUKIR.services.IncidentLogger;
import com.mkk_app.JUKIR.services.LostTicketHandler;
import com.mkk_app.JUKIR.exceptions.ParkingException;
import com.mkk_app.JUKIR.exceptions.ValidationException;
import java.awt.Color;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rhaihan aditya
 */
public class ExitGatePanel extends javax.swing.JFrame {
    
    private PetugasOperasional petugas;
    private GateController gate;
    private VehicleExitQueue queue;
    private IncidentLogger incidentLogger;
    private DefaultTableModel tableModel;

    public ExitGatePanel(PetugasOperasional petugas) {
        this.petugas = petugas;
        this.gate = new GateController("GATE-01");
        this.queue = new VehicleExitQueue(20);
        this.incidentLogger = new IncidentLogger("incident.log");
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Gate Keluar - Petugas: " + petugas.getUsername());
        tableModel = new DefaultTableModel(new Object[]{"ID Tiket","Status","Foto"}, 0);
        jTable1.setModel(tableModel);
        initSampleData();
        applyStyle();
    }

    private void applyStyle() {
        setSize(600, 430);
        setLocationRelativeTo(null);
        lblGateStatus.setFont(new Font("Dialog", Font.BOLD, 13));
        lblGateStatus.setForeground(new Color(160, 0, 0));
        btnBukaGate.setFont(new Font("Dialog", Font.BOLD, 12));
        btnTutupGate.setFont(new Font("Dialog", Font.BOLD, 12));
        btnProsesTicket.setFont(new Font("Dialog", Font.BOLD, 12));
        btnTiketHilang.setFont(new Font("Dialog", Font.BOLD, 12));
        jTable1.setRowHeight(26);
        jTable1.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 12));
        jTable1.setFont(new Font("Dialog", Font.PLAIN, 12));
        jTable1.setGridColor(new Color(210, 210, 210));
    }

    private void initSampleData() {
        if (com.mkk_app.JUKIR.services.LocalStorage.getInstance().getTicketQueue().isEmpty()) {
            ParkingTicket t1 = new ParkingTicket("TKT-001");
            t1.addPhoto(new Image("foto/plat_001.jpg"));
            ParkingTicket t2 = new ParkingTicket("TKT-002");
            queue.enqueue(t1);
            queue.enqueue(t2);
        }
        
        tableModel.setRowCount(0);
        for (ParkingTicket t : com.mkk_app.JUKIR.services.LocalStorage.getInstance().getTicketQueue()) {
            String path = (!t.getPhotos().isEmpty()) ? t.getPhotos().get(0).getPath() : "-";
            tableModel.addRow(new Object[]{t.getTicketId(), "ACTIVE", path});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTop = new javax.swing.JPanel();
        lblGateStatus = new javax.swing.JLabel();
        btnBukaGate = new javax.swing.JButton();
        btnTutupGate = new javax.swing.JButton();
        pnlBot = new javax.swing.JPanel();
        btnProsesTicket = new javax.swing.JButton();
        btnTiketHilang = new javax.swing.JButton();
        tblAntrian = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout pnlTopLayout = new javax.swing.GroupLayout(pnlTop);
        pnlTop.setLayout(pnlTopLayout);
        pnlTopLayout.setHorizontalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlTopLayout.setVerticalGroup(
            pnlTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblGateStatus.setText("Status Gate: CLOSED");

        btnBukaGate.setText("Buka Gate");
        btnBukaGate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBukaGateActionPerformed(evt);
            }
        });

        btnTutupGate.setText("Tutup Gate");
        btnTutupGate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupGateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotLayout = new javax.swing.GroupLayout(pnlBot);
        pnlBot.setLayout(pnlBotLayout);
        pnlBotLayout.setHorizontalGroup(
            pnlBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlBotLayout.setVerticalGroup(
            pnlBotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnProsesTicket.setText("Proses Tiket");
        btnProsesTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesTicketActionPerformed(evt);
            }
        });

        btnTiketHilang.setText("Tiket Hilang");
        btnTiketHilang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiketHilangActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAntrian.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblGateStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(btnBukaGate)
                .addGap(6, 6, 6)
                .addComponent(btnTutupGate)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(tblAntrian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTiketHilang)
                .addGap(8, 8, 8)
                .addComponent(btnProsesTicket)
                .addGap(12, 12, 12))
            .addComponent(pnlTop, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlBot, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTop, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGateStatus)
                    .addComponent(btnBukaGate)
                    .addComponent(btnTutupGate))
                .addGap(8, 8, 8)
                .addComponent(tblAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 230, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTiketHilang)
                    .addComponent(btnProsesTicket))
                .addGap(10, 10, 10)
                .addComponent(pnlBot, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTutupGateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupGateActionPerformed
        try {
            gate.closeGate();
            lblGateStatus.setText("Status Gate: " + gate.getStatus());
        } catch (ParkingException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(), "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnTutupGateActionPerformed

    private void btnBukaGateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBukaGateActionPerformed
        try {
            gate.openGate();
            lblGateStatus.setText("Status Gate: " + gate.getStatus());
        } catch (ParkingException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(), "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBukaGateActionPerformed

    private void btnProsesTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesTicketActionPerformed
        ParkingTicket tiket = queue.dequeue();
        if (tiket == null) {
            javax.swing.JOptionPane.showMessageDialog(this,
            "Antrian kosong.", "Info", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        initSampleData();
        int ok = javax.swing.JOptionPane.showConfirmDialog(this,
            "Proses tiket: " + tiket.getTicketId() + "\nLanjut ke pembayaran?",
            "Konfirmasi", javax.swing.JOptionPane.YES_NO_OPTION);
        if (ok == javax.swing.JOptionPane.YES_OPTION) {
            new PaymentDialog(tiket).setVisible(true);
            petugas.confirmPayment();
        }
    }//GEN-LAST:event_btnProsesTicketActionPerformed

    private void btnTiketHilangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiketHilangActionPerformed
        try {
            LostTicketHandler handler = new LostTicketHandler(gate);
            String stnk = javax.swing.JOptionPane.showInputDialog(this,
            "Masukkan nomor STNK (min. 10 karakter):",
            "Tiket Hilang", javax.swing.JOptionPane.PLAIN_MESSAGE);
            if (stnk != null && !stnk.isEmpty()) {
                handler.setStnkNumber(stnk);
                handler.uploadKtp(new Image("ktp/uploaded.jpg"));
                handler.requestGateOpen();
                lblGateStatus.setText("Status Gate: " + gate.getStatus());
                incidentLogger.logIncident(
                    new Incident("INC-" + System.currentTimeMillis(), "Tiket Hilang STNK: " + stnk));
                petugas.handleLostTicket();
                javax.swing.JOptionPane.showMessageDialog(this,
                "Insiden tiket hilang telah dicatat.", "Info",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (ValidationException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Validasi", javax.swing.JOptionPane.ERROR_MESSAGE);
        } catch (ParkingException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Gate", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTiketHilangActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExitGatePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExitGatePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExitGatePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExitGatePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExitGatePanel(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBukaGate;
    private javax.swing.JButton btnProsesTicket;
    private javax.swing.JButton btnTiketHilang;
    private javax.swing.JButton btnTutupGate;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblGateStatus;
    private javax.swing.JPanel pnlBot;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JScrollPane tblAntrian;
    // End of variables declaration//GEN-END:variables
}
