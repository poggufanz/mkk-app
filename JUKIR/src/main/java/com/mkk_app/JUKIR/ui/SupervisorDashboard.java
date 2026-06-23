/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mkk_app.JUKIR.ui;

import com.mkk_app.JUKIR.models.DashboardMonitor;
import com.mkk_app.JUKIR.models.Incident;
import com.mkk_app.JUKIR.models.ParkingTicket;
import com.mkk_app.JUKIR.models.Supervisor;
import com.mkk_app.JUKIR.models.Transaction;
import java.awt.Color;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rhaihan aditya
 */
public class SupervisorDashboard extends javax.swing.JFrame {
    
    private Supervisor supervisor;
    private DashboardMonitor monitor;
    private DefaultTableModel modelInsiden;
    private DefaultTableModel modelTx;

    public SupervisorDashboard(Supervisor supervisor) {
        this.supervisor = supervisor;
        this.monitor = new DashboardMonitor();
        initSampleData();
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Dashboard Supervisor - " + supervisor.getUsername());
        loadTableData();
        applyStyle();
    }

    private void applyStyle() {
        setSize(700, 520);
        setLocationRelativeTo(null);

        // Bersihkan layout bawaan NetBeans builder agar bisa ditata ulang
        getContentPane().removeAll();
        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));

        // Panel tab 1: Manajemen Insiden (CRUD)
        javax.swing.JPanel pnlInsiden = new javax.swing.JPanel(new java.awt.BorderLayout(5, 5));
        pnlInsiden.add(tblInsiden, java.awt.BorderLayout.CENTER);

        // Tombol CRUD untuk Insiden
        javax.swing.JPanel pnlCrudInsiden = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 5));
        javax.swing.JButton btnAddIncident = new javax.swing.JButton("Tambah Insiden");
        javax.swing.JButton btnEditIncident = new javax.swing.JButton("Ubah Status");
        javax.swing.JButton btnDeleteIncident = new javax.swing.JButton("Hapus Insiden");

        // Styling tombol CRUD
        Font buttonFont = new Font("Dialog", Font.BOLD, 12);
        btnAddIncident.setFont(buttonFont);
        btnEditIncident.setFont(buttonFont);
        btnDeleteIncident.setFont(buttonFont);

        pnlCrudInsiden.add(btnAddIncident);
        pnlCrudInsiden.add(btnEditIncident);
        pnlCrudInsiden.add(btnDeleteIncident);
        pnlInsiden.add(pnlCrudInsiden, java.awt.BorderLayout.SOUTH);

        // Panel tab 2: Transaksi Aktif
        javax.swing.JPanel pnlTx = new javax.swing.JPanel(new java.awt.BorderLayout(5, 5));
        pnlTx.add(tblTx, java.awt.BorderLayout.CENTER);

        // Panel tab 3: Petugas Aktif
        javax.swing.JPanel pnlPetugas = new javax.swing.JPanel(new java.awt.BorderLayout(5, 5));
        pnlPetugas.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        // Tambahkan ke JTabbedPane
        tabsDashboard.removeAll();
        tabsDashboard.addTab("Manajemen Insiden", pnlInsiden);
        tabsDashboard.addTab("Transaksi Aktif", pnlTx);
        tabsDashboard.addTab("Petugas Aktif", pnlPetugas);

        // Tata letak utama JFrame
        getContentPane().add(tabsDashboard, java.awt.BorderLayout.CENTER);

        // Panel Bawah untuk Refresh
        javax.swing.JPanel pnlBottom = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 10));
        pnlBottom.add(btnRefresh);
        getContentPane().add(pnlBottom, java.awt.BorderLayout.SOUTH);

        // Font & Style
        tabsDashboard.setFont(new Font("Dialog", Font.BOLD, 12));
        btnRefresh.setFont(new Font("Dialog", Font.BOLD, 12));
        jTable1.setRowHeight(24);
        jTable1.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 12));
        jTable1.setFont(new Font("Dialog", Font.PLAIN, 12));
        jTable1.setGridColor(new Color(210, 210, 210));
        jTable2.setRowHeight(24);
        jTable2.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 12));
        jTable2.setFont(new Font("Dialog", Font.PLAIN, 12));
        jTable2.setGridColor(new Color(210, 210, 210));
        listPetugas.setFont(new Font("Dialog", Font.PLAIN, 13));
        listPetugas.setFixedCellHeight(28);

        // Refresh frame
        revalidate();
        repaint();

        // Action Listeners untuk tombol CRUD
        btnAddIncident.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    String id = javax.swing.JOptionPane.showInputDialog(SupervisorDashboard.this, 
                            "Masukkan ID Insiden (contoh: INC-003):", 
                            "Tambah Insiden", javax.swing.JOptionPane.PLAIN_MESSAGE);
                    if (id == null) return;
                    id = id.trim();
                    if (id.isEmpty()) {
                        throw new com.mkk_app.JUKIR.exceptions.ValidationException("ID Insiden tidak boleh kosong!");
                    }
                    for (Incident i : monitor.getIncidents()) {
                        if (i.getIncidentId().equalsIgnoreCase(id)) {
                            throw new com.mkk_app.JUKIR.exceptions.DuplicateDataException("Incident dengan ID " + id + " sudah ada!");
                        }
                    }
                    String desc = javax.swing.JOptionPane.showInputDialog(SupervisorDashboard.this, 
                            "Masukkan Deskripsi Insiden:", 
                            "Tambah Insiden", javax.swing.JOptionPane.PLAIN_MESSAGE);
                    if (desc == null) return;
                    desc = desc.trim();
                    if (desc.isEmpty()) {
                        throw new com.mkk_app.JUKIR.exceptions.ValidationException("Deskripsi tidak boleh kosong!");
                    }
                    Incident newInc = new Incident(id, desc);
                    monitor.addIncident(newInc);
                    loadTableData();
                    javax.swing.JOptionPane.showMessageDialog(SupervisorDashboard.this, 
                            "Insiden berhasil ditambahkan.", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                } catch (com.mkk_app.JUKIR.exceptions.MKKException ex) {
                    javax.swing.JOptionPane.showMessageDialog(SupervisorDashboard.this, 
                            ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEditIncident.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow == -1) {
                        throw new com.mkk_app.JUKIR.exceptions.DataNotFoundException("Pilih insiden dari tabel terlebih dahulu!");
                    }
                    String id = (String) jTable1.getValueAt(selectedRow, 0);
                    Incident target = null;
                    for (Incident i : monitor.getIncidents()) {
                        if (i.getIncidentId().equals(id)) {
                            target = i;
                            break;
                        }
                    }
                    if (target == null) {
                        throw new com.mkk_app.JUKIR.exceptions.DataNotFoundException("Data insiden tidak ditemukan!");
                    }
                    String[] options = {"PENDING", "IN_PROGRESS", "RESOLVED"};
                    String status = (String) javax.swing.JOptionPane.showInputDialog(SupervisorDashboard.this,
                            "Pilih status baru untuk insiden " + id + ":",
                            "Ubah Status",
                            javax.swing.JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            target.getStatus());
                    if (status == null) return;
                    target.setStatus(status);
                    com.mkk_app.JUKIR.services.LocalStorage.getInstance().saveIncidents();
                    loadTableData();
                    javax.swing.JOptionPane.showMessageDialog(SupervisorDashboard.this, 
                            "Status insiden berhasil diperbarui.", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                } catch (com.mkk_app.JUKIR.exceptions.MKKException ex) {
                    javax.swing.JOptionPane.showMessageDialog(SupervisorDashboard.this, 
                            ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnDeleteIncident.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow == -1) {
                        throw new com.mkk_app.JUKIR.exceptions.DataNotFoundException("Pilih insiden dari tabel terlebih dahulu!");
                    }
                    String id = (String) jTable1.getValueAt(selectedRow, 0);
                    Incident target = null;
                    for (Incident i : monitor.getIncidents()) {
                        if (i.getIncidentId().equals(id)) {
                            target = i;
                            break;
                        }
                    }
                    if (target == null) {
                        throw new com.mkk_app.JUKIR.exceptions.DataNotFoundException("Data insiden tidak ditemukan!");
                    }
                    int confirm = javax.swing.JOptionPane.showConfirmDialog(SupervisorDashboard.this,
                            "Apakah Anda yakin ingin menghapus insiden " + id + "?",
                            "Hapus Insiden",
                            javax.swing.JOptionPane.YES_NO_OPTION);
                    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
                        monitor.getIncidents().remove(target);
                        com.mkk_app.JUKIR.services.LocalStorage.getInstance().saveIncidents();
                        loadTableData();
                        javax.swing.JOptionPane.showMessageDialog(SupervisorDashboard.this, 
                                "Insiden berhasil dihapus.", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (com.mkk_app.JUKIR.exceptions.MKKException ex) {
                    javax.swing.JOptionPane.showMessageDialog(SupervisorDashboard.this, 
                            ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void initSampleData() {
        if (monitor.getIncidents().isEmpty()) {
            monitor.addIncident(new Incident("INC-001", "Tiket hilang di Gate-01"));
            monitor.addIncident(new Incident("INC-002", "Gate macet"));
        }
        if (monitor.getActiveTx().isEmpty()) {
            ParkingTicket t = new ParkingTicket("TKT-001");
            monitor.addActiveTransaction(new Transaction("TX-001", 5000, t));
            monitor.addActiveTransaction(new Transaction("TX-002", 8000, t));
        }
    }

    private void loadTableData() {
        modelInsiden = new DefaultTableModel(new Object[]{"ID Insiden","Deskripsi","Status"}, 0);
        for (Incident i : monitor.getIncidents()) {
            modelInsiden.addRow(new Object[]{i.getIncidentId(), i.getDescription(), i.getStatus()});
        }
        jTable1.setModel(modelInsiden);
        modelTx = new DefaultTableModel(new Object[]{"ID Transaksi","Jumlah (Rp)"}, 0);
        for (Transaction tx : monitor.getActiveTx()) {
            modelTx.addRow(new Object[]{tx.getTxId(), tx.getAmount()});
        }
        jTable2.setModel(modelTx);
        javax.swing.DefaultListModel<String> listModel = new javax.swing.DefaultListModel<>();
        for (String p : monitor.getActiveOfficers()) listModel.addElement(p);
        listPetugas.setModel(listModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabsDashboard = new javax.swing.JTabbedPane();
        tblInsiden = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tblTx = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        listPetugas = new javax.swing.JList<>();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        tblInsiden.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTx.setViewportView(jTable2);

        listPetugas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listPetugas);

        btnRefresh.setText("Refresh Dashboard ");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabsDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tblInsiden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tblTx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(tabsDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(tblInsiden, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(tblTx, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(btnRefresh)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        monitor.refresh();
        supervisor.monitorDashboard();
        supervisor.sendNotification("Dashboard diperbarui oleh " + supervisor.getUsername());
        javax.swing.JOptionPane.showMessageDialog(this,
            "Dashboard berhasil diperbarui.", "Info",
            javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnRefreshActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SupervisorDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupervisorDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupervisorDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupervisorDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupervisorDashboard(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JList<String> listPetugas;
    private javax.swing.JTabbedPane tabsDashboard;
    private javax.swing.JScrollPane tblInsiden;
    private javax.swing.JScrollPane tblTx;
    // End of variables declaration//GEN-END:variables
}
