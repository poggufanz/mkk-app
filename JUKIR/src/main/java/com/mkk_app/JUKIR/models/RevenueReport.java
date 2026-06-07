package com.mkk_app.JUKIR.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.ZoneId;

/**
 *
 * @author rhaihan aditya
 */
public class RevenueReport {
    private List<Transaction> txList;
    private DateRange period;

    public RevenueReport(DateRange period) {
        this.txList = new ArrayList<>();
        this.period = period;
    }

    public Report generateReport() {
        double total = 0;
        for (Transaction tx : txList) {
            total += tx.getAmount();
        }
        String content = "Laporan Pendapatan untuk periode: " + period.getStart() + " s.d. " + period.getEnd() + 
                         "\nTotal Transaksi: " + txList.size() + 
                         "\nTotal Pendapatan: " + total;
        return new Report("REP-" + System.currentTimeMillis(), "Laporan Pendapatan", content);
    }

    public void exportTo(String format) {
        System.out.println("Laporan Pendapatan diekspor ke: " + format);
    }

    public List<Transaction> filterByDate(Date d) {
        List<Transaction> filtered = new ArrayList<>();
        for (Transaction tx : txList) {
            Date txDate = Date.from(tx.getTimestamp().atZone(ZoneId.systemDefault()).toInstant());
            // Compare dates (ignoring time)
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
        txList.add(tx);
    }

    public List<Transaction> getTxList() {
        return txList;
    }

    public DateRange getPeriod() {
        return period;
    }

    public void setPeriod(DateRange period) {
        this.period = period;
    }
}
