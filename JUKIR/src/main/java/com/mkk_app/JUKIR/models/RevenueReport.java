package com.mkk_app.JUKIR.models;

import com.mkk_app.JUKIR.services.LocalStorage;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.time.ZoneId;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RevenueReport {
    private DateRange period;

    public RevenueReport(DateRange period) {
        this.period = period;
    }

    public Report generateReport() {
        double total = 0;
        for (Transaction tx : getTxList()) {
            total += tx.getAmount();
        }
        String content = "Laporan Pendapatan untuk periode: " + period.getStart() + " s.d. " + period.getEnd() +
                         "\nTotal Transaksi: " + getTxList().size() +
                         "\nTotal Pendapatan: " + total;
        return new Report("REP-" + System.currentTimeMillis(), "Laporan Pendapatan", content);
    }

    public void exportTo(String format) {
        Report r = generateReport();
        String fileName = "Laporan_Pendapatan_" + System.currentTimeMillis();
        if (format.equalsIgnoreCase("PDF")) {
            exportPDF(fileName + ".pdf", r.getContent());
        } else if (format.equalsIgnoreCase("Excel")) {
            exportExcel(fileName + ".xlsx");
        }
    }

    private void exportPDF(String fileName, String content) {
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(fileName));
            doc.open();
            doc.add(new Paragraph("LAPORAN PENDAPATAN PARKIR JUKIR"));
            doc.add(new Paragraph("-----------------------------------"));
            doc.add(new Paragraph(content));
            doc.close();
            System.out.println("PDF berhasil disimpan: " + fileName);
        } catch (Exception e) {
            System.out.println("Gagal membuat PDF: " + e.getMessage());
        }
    }

    private void exportExcel(String fileName) {
        try (Workbook wb = new XSSFWorkbook()) {
            Sheet sheet = wb.createSheet("Laporan Pendapatan");
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID Transaksi");
            header.createCell(1).setCellValue("Jumlah (Rp)");
            header.createCell(2).setCellValue("Waktu");
            ArrayList<Transaction> list = getTxList();
            for (int i = 0; i < list.size(); i++) {
                Transaction tx = list.get(i);
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(tx.getTxId());
                row.createCell(1).setCellValue(tx.getAmount());
                row.createCell(2).setCellValue(tx.getTimestamp().toString());
            }
            wb.write(new FileOutputStream(fileName));
            System.out.println("Excel berhasil disimpan: " + fileName);
        } catch (Exception e) {
            System.out.println("Gagal membuat Excel: " + e.getMessage());
        }
    }

    public ArrayList<Transaction> filterByDate(Date d) {
        ArrayList<Transaction> filtered = new ArrayList<>();
        for (Transaction tx : getTxList()) {
            Date txDate = Date.from(tx.getTimestamp().atZone(ZoneId.systemDefault()).toInstant());
            if (isSameDay(txDate, d)) {
                filtered.add(tx);
            }
        }
        return filtered;
    }

    private boolean isSameDay(Date d1, Date d2) {
        return d1.getYear() == d2.getYear() && d1.getMonth() == d2.getMonth() && d1.getDate() == d2.getDate();
    }

    public void addTransaction(Transaction tx) {
        LocalStorage.getInstance().getTransactions().add(tx);
        LocalStorage.getInstance().saveTransactions();
    }

    public ArrayList<Transaction> getTxList() {
        return LocalStorage.getInstance().getTransactions();
    }

    public DateRange getPeriod() {
        return period;
    }

    public void setPeriod(DateRange period) {
        this.period = period;
    }
}
