/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mkk_app.JUKIR.ui;

import com.mkk_app.JUKIR.models.CashPayment;
import com.mkk_app.JUKIR.models.ParkingTicket;
import com.mkk_app.JUKIR.models.QrisPayment;
import com.mkk_app.JUKIR.models.TarifParkir;
import com.mkk_app.JUKIR.models.Transaction;
import com.mkk_app.JUKIR.services.TarifCalculator;
import com.mkk_app.JUKIR.exceptions.InsufficientPaymentException;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDateTime;

/**
 *
 * @author rhaihan aditya
 */
public class PaymentDialog extends javax.swing.JFrame {
    
    private ParkingTicket ticket;
    private TarifCalculator tarifCalculator;
    private double tarifTotal;

    public PaymentDialog(ParkingTicket ticket) {
        this.ticket = ticket;
        TarifParkir tarif = new TarifParkir(3000, 2000, "mobil");
        this.tarifCalculator = new TarifCalculator(tarif);
        this.tarifTotal = tarifCalculator.calculate(ticket);
        initComponents();
        setLocationRelativeTo(null);
        lblTarif.setText("Total Tarif: Rp " + (long)tarifTotal);
        applyStyle();
    }

    private void applyStyle() {
        setTitle("Pembayaran Tiket Parkir");
        setSize(400, 280);
        setLocationRelativeTo(null);
        lblTarif.setFont(new Font("Dialog", Font.BOLD, 15));
        lblTarif.setForeground(new Color(0, 80, 180));
        lblTarif.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMetode.setFont(new Font("Dialog", Font.PLAIN, 13));
        lblBayar.setFont(new Font("Dialog", Font.PLAIN, 13));
        lblStatus.setFont(new Font("Dialog", Font.BOLD, 12));
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inpBayar.setFont(new Font("Dialog", Font.PLAIN, 13));
        cmbMetode.setFont(new Font("Dialog", Font.PLAIN, 13));
        btnProses.setFont(new Font("Dialog", Font.BOLD, 13));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTarif = new javax.swing.JLabel();
        lblMetode = new javax.swing.JLabel();
        lblBayar = new javax.swing.JLabel();
        cmbMetode = new javax.swing.JComboBox<>();
        inpBayar = new javax.swing.JTextField();
        btnProses = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTarif.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTarif.setText("Total Tarif: Rp -");

        lblMetode.setText("Metode Bayar:");

        lblBayar.setText("Jumlah Bayar (Rp):");

        cmbMetode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "QRIS" }));

        inpBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpBayarActionPerformed(evt);
            }
        });

        btnProses.setText("Proses Pembayaran");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTarif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblMetode, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cmbMetode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(inpBayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnProses, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTarif)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMetode)
                    .addComponent(cmbMetode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBayar)
                    .addComponent(inpBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(lblStatus)
                .addGap(16, 16, 16)
                .addComponent(btnProses)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inpBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpBayarActionPerformed

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        double bayar;
        try {
            bayar = Double.parseDouble(inpBayar.getText().trim());
        } catch (NumberFormatException ex) {
            lblStatus.setForeground(Color.RED);
            lblStatus.setText("Jumlah tidak valid");
            return;
        }
        String metode = (String) cmbMetode.getSelectedItem();
        Transaction tx = new Transaction("TX-" + System.currentTimeMillis(), tarifTotal, ticket);
        try {
            if ("Cash".equals(metode)) {
                CashPayment cash = new CashPayment(tarifTotal, LocalDateTime.now(), bayar);
                cash.processPayment();
                tx.addPayment(cash);
                lblStatus.setForeground(new Color(0, 150, 0));
                lblStatus.setText("Bayar OK. Kembalian: Rp " + (long) cash.calcChange());
            } else {
                String token = "QR-" + System.currentTimeMillis();
                QrisPayment qris = new QrisPayment(tarifTotal, LocalDateTime.now(), token);
                qris.processPayment();
                tx.addPayment(qris);
                lblStatus.setForeground(new Color(0, 150, 0));
                lblStatus.setText("QRIS OK. Status: " + qris.getStatus());
            }
            com.mkk_app.JUKIR.services.LocalStorage.getInstance().getTransactions().add(tx);
            com.mkk_app.JUKIR.services.LocalStorage.getInstance().saveTransactions();
        } catch (InsufficientPaymentException ex) {
            lblStatus.setForeground(Color.RED);
            lblStatus.setText("Uang kurang! Kekurangan: Rp " + (long)(tarifTotal - bayar));
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage(), "Pembayaran Gagal", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnProsesActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaymentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentDialog(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProses;
    private javax.swing.JComboBox<String> cmbMetode;
    private javax.swing.JTextField inpBayar;
    private javax.swing.JLabel lblBayar;
    private javax.swing.JLabel lblMetode;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTarif;
    // End of variables declaration//GEN-END:variables
}
