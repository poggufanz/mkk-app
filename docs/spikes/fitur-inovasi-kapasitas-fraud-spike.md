---
title: "Fitur Inovasi: Smart Capacity + Rule-Based Fraud Detection"
category: "Architecture & Design"
status: "🟢 Complete"
priority: "High"
timebox: "1 hari"
created: 2026-04-28
updated: 2026-04-28
owner: "Muhammad Faiq"
tags: ["technical-spike", "architecture", "innovation", "dpbo"]
---

# Fitur Inovasi: Smart Capacity + Rule-Based Fraud Detection

## Summary

**Spike Objective:** Apakah 2 fitur inovasi (Smart Capacity Gate Control & Rule-Based Fraud Detection) konsisten dengan flow dan dokumen yang sudah ada, atau perlu merombak banyak hal?

**Why This Matters:** Dosen meminta fitur yang "inovatif dan berbeda". Tapi kita harus memastikan penambahan ini tidak bertentangan dengan laporan tugas besar PRPL dan 9 dokumen DPBO yang sudah dibuat.

**Timebox:** 1 hari riset

**Decision Deadline:** Sebelum mulai coding

## Research Question(s)

**Primary Question:** Apakah kedua fitur inovasi ini sesuai dengan flow di `laporan_tugas_besar.md` dan dokumen DPBO?

**Secondary Questions:**

- Berapa banyak kelas baru yang perlu ditambahkan?
- Apakah class diagram utama perlu dirombak atau cukup ditambahkan?
- Apakah flow terminal (demo skenario) berubah drastis?

## Investigation Plan

### Research Tasks

- [x] Baca ulang `laporan_tugas_besar.md` — khususnya flowchart, kebutuhan fungsional, dan saran
- [x] Baca ulang `produk-fitur-lengkap.md` — cek apakah sudah ada placeholder untuk fitur ini
- [x] Baca ulang `teknis-arsitektur.md` — cek apakah arsitektur bisa menampung fitur baru
- [x] Baca ulang `teknis-diagram.md` — cek dampak ke class diagram
- [x] Analisis gap: apa yang perlu ditambah vs apa yang harus diubah
- [x] Dokumentasikan rekomendasi final

### Success Criteria

**Spike ini selesai ketika:**

- [x] Ada peta jelas: kelas mana yang baru, kelas mana yang dimodifikasi
- [x] Sudah diverifikasi tidak bertentangan dengan laporan PRPL
- [x] Ada rekomendasi final yang bisa langsung dieksekusi

---

## Research Findings

### 1. Kompatibilitas dengan `laporan_tugas_besar.md`

#### ✅ Smart Capacity Gate Control — SESUAI 100%

| Referensi di Laporan PRPL | Bukti |
|---|---|
| **Bab 1.1 Latar Belakang:** *"...MKK sudah menggunakan sistem pemantauan secara real-time berdasarkan big data"* | Fitur kapasitas = bentuk pemantauan real-time |
| **Bab 1.4 Usulan Solusi:** *"...petugas harus memastikan secara visual melalui sistem sebelum pintu bisa terbuka"* | Gate control adalah otomatisasi "pintu bisa terbuka / tidak" |
| **Bab 3.1 Flowchart:** Flow sudah punya konsep *"Tahan Gate"* saat validasi gagal | Kita menambahkan satu trigger baru untuk tahan gate: **kapasitas penuh** |
| **Bab 5.2 Saran #2:** *"Penambahan fitur laporan otomatis dan dashboard analitik akan sangat membantu... mendeteksi potensi masalah sejak dini"* | Dashboard kapasitas = deteksi dini masalah (parkiran penuh) |

**Kesimpulan:** Fitur ini adalah **ekstensi natural** dari flow yang sudah ada. Laporan PRPL bahkan menyarankannya di Bab 5.2.

#### ✅ Rule-Based Fraud Detection — SESUAI 100%

| Referensi di Laporan PRPL | Bukti |
|---|---|
| **Bab 1.2 Identifikasi Masalah B:** *"Petugas di lapangan sering kali memperbolehkan transaksi manual tanpa pengawasan yang dilakukan secara real-time"* | Fraud detection = pengawasan otomatis real-time |
| **Bab 2.2 No.3:** *"Modus tiket hilang digunakan untuk mencuri motor atau uang denda"* | Rule: "3 tiket hilang oleh petugas yang sama = auto-flag" langsung menjawab masalah ini |
| **Bab 5.2 Saran #3:** *"Sistem dapat dikembangkan lebih lanjut dengan memanfaatkan teknologi kecerdasan buatan untuk membantu mendeteksi aktivitas mencurigakan"* | Kita menjawab saran ini **tanpa AI** — hanya dengan Rule Engine berbasis OOP! |
| **DSB-05 di `produk-fitur-lengkap.md`:** *"Alert Anomali — Menandai aktivitas yang mencurigakan (otomatis)"* | Fitur ini SUDAH ADA di katalog, statusnya `Could Have`. Kita naik-kan ke `Should Have` |

**Kesimpulan:** Fraud Detection bukan fitur baru — **sudah direncanakan** (DSB-05 di katalog fitur) dan **disarankan** di laporan PRPL. Kita hanya mengimplementasikannya secara algoritmik.

---

### 2. Kompatibilitas dengan Dokumen DPBO yang Sudah Ada

#### `teknis-arsitektur.md`

| Komponen | Status | Keterangan |
|---|:---:|---|
| Layered Architecture | ✅ Tetap | Fitur baru masuk di Service Layer |
| `ParkirService` | 🔄 Modifikasi kecil | Tambah pengecekan kapasitas di `registrasiMasuk()` |
| `EventManager` (Observer) | ✅ Tetap | Sudah bisa kirim event `KAPASITAS_PENUH` dan `FRAUD_DETECTED` |
| Package structure | 🔄 Tambah | Tambah sub-package `service/fraud/` |

#### `teknis-diagram.md` (Class Diagram)

| Kelas | Aksi | Keterangan |
|---|:---:|---|
| `KapasitasService` | 🆕 Baru | Cek okupansi, tentukan status parkiran |
| `FraudDetectionService` | 🆕 Baru | Orchestrator — jalankan semua rules |
| `FraudRule` (interface) | 🆕 Baru | Kontrak untuk setiap aturan |
| `TiketHilangFrequencyRule` | 🆕 Baru | Rule: ≥3 tiket hilang/petugas/hari |
| `DurasiAnomalRule` | 🆕 Baru | Rule: durasi < 2 menit tapi bayar penuh |
| `DuplikasiPlatRule` | 🆕 Baru | Rule: plat sama masuk 2x tanpa keluar |
| `StatusParkiran` (enum) | 🆕 Baru | LANCAR / RAMAI / HAMPIR_PENUH / PENUH |
| `FraudAlert` (model) | 🆕 Baru | Value object untuk hasil deteksi |
| `ParkirService` | 🔄 Edit | Tambah cek `KapasitasService` di `registrasiMasuk()` |
| `EventType` (enum) | 🔄 Edit | Tambah `KAPASITAS_PENUH`, `FRAUD_DETECTED` |
| `SupervisorMenuController` | 🔄 Edit | Tambah menu "Status Kapasitas" dan "Fraud Alerts" |
| **Total kelas baru** | **8** | Dari ~52 jadi ~60 kelas |

#### `produk-demo-skenario.md`

| Skenario | Status |
|---|:---:|
| Skenario 1-5 (existing) | ✅ Tidak berubah |
| Skenario 6: Gate Ditolak karena Penuh | 🆕 Tambah baru |
| Skenario 7: Fraud Auto-Detected | 🆕 Tambah baru |

---

### 3. Dampak ke Flow (Yang Paling Penting!)

#### Flow MASUK — Perubahan Kecil

```
SEBELUM (Flow Lama):
  Input plat → jenis → deskripsi → Generate tiket → Simpan → Selesai

SESUDAH (Flow Baru):
  Input plat → jenis → deskripsi
    → 🆕 CEK KAPASITAS (KapasitasService)
      → if PENUH: ❌ TOLAK registrasi, tampilkan alert
      → if OK:    ✅ Lanjut generate tiket → Simpan → Tampilkan info kapasitas
```

**Perubahan: Hanya 1 pengecekan `if` ditambahkan SEBELUM generate tiket.**

#### Flow KELUAR — Perubahan Minimal

```
SEBELUM (Flow Lama):
  Input tiket → Cari → Validasi visual → Hitung tarif → Bayar → Gate terbuka

SESUDAH (Flow Baru):
  Input tiket → Cari → Validasi visual → Hitung tarif → Bayar → Gate terbuka
    → 🆕 POST-TRANSACTION: FraudDetectionService.analyze(transaksi)
      → Cek semua rules secara otomatis
      → Jika ada rule yang terpicu → Auto-flag + Log + Notif Supervisor
```

**Perubahan: Fraud check dilakukan SETELAH transaksi — tidak mengganggu flow utama sama sekali.**

#### Flow SUPERVISOR — Tambahan Menu

```
SEBELUM:
  [1] Dashboard  [2] Log  [3] User  [4] Kinerja  [5] Password  [6] Logout

SESUDAH:
  [1] Dashboard  [2] Log  [3] User  [4] Kinerja
  [5] 🆕 Status Kapasitas
  [6] 🆕 Fraud Alerts
  [7] Password  [8] Logout
```

---

### 4. Kode Inti yang Perlu Ditulis

#### A. KapasitasService.java (Otak kapasitas)

```java
public class KapasitasService {

    private final int kapasitasMaksimal;
    private final TiketParkirRepository tiketRepo;

    public KapasitasService(int kapasitasMaksimal, TiketParkirRepository tiketRepo) {
        this.kapasitasMaksimal = kapasitasMaksimal;
        this.tiketRepo = tiketRepo;
    }

    public StatusParkiran getStatus() {
        int aktif = tiketRepo.countActive();
        double persen = ((double) aktif / kapasitasMaksimal) * 100;

        if (persen >= 95) return StatusParkiran.PENUH;
        if (persen >= 80) return StatusParkiran.HAMPIR_PENUH;
        if (persen >= 50) return StatusParkiran.RAMAI;
        return StatusParkiran.LANCAR;
    }

    public boolean bolehMasuk() {
        return getStatus() != StatusParkiran.PENUH;
    }

    public String getInfoKapasitas() {
        int aktif = tiketRepo.countActive();
        double persen = ((double) aktif / kapasitasMaksimal) * 100;
        StatusParkiran status = getStatus();

        return String.format("Kapasitas: %d/%d (%.0f%%) — %s",
            aktif, kapasitasMaksimal, persen, status.getLabel());
    }
}
```

#### B. FraudRule.java (Interface — Chain of Responsibility)

```java
public interface FraudRule {
    String getNamaRule();
    FraudAlert evaluate(TransaksiContext context);
}
```

#### C. TiketHilangFrequencyRule.java (Contoh 1 Rule)

```java
public class TiketHilangFrequencyRule implements FraudRule {

    private static final int MAX_TIKET_HILANG_PER_HARI = 3;
    private final LogRepository logRepo;

    @Override
    public String getNamaRule() {
        return "Frekuensi Tiket Hilang per Petugas";
    }

    @Override
    public FraudAlert evaluate(TransaksiContext context) {
        // Hitung berapa kali petugas ini proses tiket hilang hari ini
        long count = logRepo.findAllLogsTiketHilang().stream()
            .filter(log -> log.getPetugasId().equals(context.getPetugasId()))
            .filter(log -> log.getWaktuLapor().toLocalDate().equals(LocalDate.now()))
            .count();

        if (count >= MAX_TIKET_HILANG_PER_HARI) {
            return new FraudAlert(
                getNamaRule(),
                "PERINGATAN: Petugas " + context.getNamaPetugas()
                    + " sudah memproses " + count + " tiket hilang hari ini!",
                FraudSeverity.HIGH
            );
        }
        return null; // Tidak ada anomali
    }
}
```

#### D. FraudDetectionService.java (Orchestrator)

```java
public class FraudDetectionService {

    private final List<FraudRule> rules = new ArrayList<>();
    private final EventManager eventManager;

    public FraudDetectionService(EventManager eventManager) {
        this.eventManager = eventManager;
        // Daftarkan semua rules
        rules.add(new TiketHilangFrequencyRule(logRepo));
        rules.add(new DurasiAnomalRule());
        rules.add(new DuplikasiPlatRule(tiketRepo));
    }

    /**
     * Dipanggil SETELAH setiap transaksi selesai.
     * Semua rules dievaluasi satu per satu.
     */
    public List<FraudAlert> analyze(TransaksiContext context) {
        List<FraudAlert> alerts = new ArrayList<>();

        for (FraudRule rule : rules) {
            FraudAlert alert = rule.evaluate(context);
            if (alert != null) {
                alerts.add(alert);
                // Otomatis kirim event ke Observer (log + notif supervisor)
                eventManager.notify(EventType.FRAUD_DETECTED, alert);
            }
        }
        return alerts;
    }
}
```

---

### 5. Pemetaan Konsep OOP (Nilai Tambah untuk Presentasi!)

| Fitur | Design Pattern Baru | Konsep OOP |
|---|---|---|
| Smart Capacity | — (logika kondisional di service) | **Encapsulation**: Semua logika kapasitas terisolasi di `KapasitasService` |
| Fraud Rules | **Chain of Responsibility** | **Polymorphism**: Setiap `FraudRule` punya implementasi `evaluate()` berbeda |
| FraudRule interface | **Strategy-like** | **Abstraction**: Interface kontrak, implementasi bervariasi |
| FraudDetectionService | **Facade** | **Composition**: Mengorkestrasikan banyak rules |
| Event FRAUD_DETECTED | **Observer** (sudah ada) | Reuse pattern yang sudah dibangun |

**Total design patterns setelah penambahan: 7** (Singleton, Factory, Strategy, Observer, DAO, Template Method, **Chain of Responsibility**)

---

## Decision

### Recommendation

**✅ Lanjutkan implementasi kedua fitur.** Alasan:

1. **100% kompatibel** dengan laporan PRPL — bahkan menjawab Saran #2 dan #3 di Bab 5.2
2. **Tidak merombak flow** — hanya menambahkan 1 pengecekan di masuk + 1 post-processing di keluar
3. **Minimal disruption** ke dokumen existing — hanya tambah, tidak ubah
4. **8 kelas baru** dari ~52 kelas existing = pertumbuhan ~15%, sangat wajar
5. **Menambah 1 design pattern baru** (Chain of Responsibility) — semakin kaya secara OOP

### Apa yang TIDAK Berubah

- ❌ Tarif **TETAP STAGNAN** — tidak ada surge pricing / dynamic pricing
- ❌ Flow utama masuk-keluar-bayar **TIDAK BERUBAH**
- ❌ 5 skenario demo existing **TIDAK DIMODIFIKASI**
- ❌ Semua 9 dokumen existing **TIDAK PERLU DIROMBAK** (hanya ditambahkan)

### Apa yang Perlu Ditambahkan ke Dokumen

| Dokumen | Aksi | Estimasi Effort |
|---|---|---|
| `produk-fitur-lengkap.md` | Tambah Modul 8: Smart Capacity, Modul 9: Fraud Detection | Kecil |
| `produk-user-stories.md` | Tambah 4-5 user stories baru | Kecil |
| `produk-demo-skenario.md` | Tambah Skenario 6 dan 7 | Kecil |
| `teknis-arsitektur.md` | Tambah 2 service baru di diagram + ADR-004 | Kecil |
| `teknis-diagram.md` | Tambah 8 kelas baru ke class diagram | Sedang |
| `teknis-database.md` | Tambah entitas FraudAlert + StatusParkiran enum | Kecil |
| `teknis-keamanan-privasi.md` | Tambah bagian "Automated Fraud Detection" | Kecil |
| `bisnis-dampak-model.md` | Update ROI + tambah KPI fraud detection | Kecil |
| `bisnis-roadmap-backlog.md` | Tambah sprint tasks untuk fitur baru | Kecil |

### Follow-up Actions

- [x] Update 9 dokumen DPBO sesuai tabel di atas *(selesai 2026-05-02)*
- [x] Update class diagram utama dengan 8 kelas baru *(selesai 2026-05-02)*
- [x] Tambah FR code references dari elisitasi ke seluruh dokumen *(selesai 2026-05-02)*
- [ ] Tambah 2 skenario demo baru
- [ ] Mulai implementasi kode Java

> **Catatan Elisitasi**: Kedua fitur inovasi ini menjawab langsung temuan dari wawancara stakeholder PT. MKK:
> - Smart Capacity → mendukung FR-06 (Dashboard Real-Time)
> - Fraud Detection → mendukung FR-09 (Auto-Alert Suspicious Activity)

## Status History

| Date | Status | Notes |
|---|---|---|
| 2026-04-28 | 🔴 Not Started | Spike created |
| 2026-04-28 | 🟡 In Progress | Research commenced — review semua dokumen |
| 2026-04-28 | 🟢 Complete | Kedua fitur 100% kompatibel, rekomendasi: lanjutkan |
| 2026-05-02 | 📝 Docs Updated | Seluruh 9 dokumen DPBO + class diagram telah diupdate dengan FR references dari elisitasi |

---

_Last updated: 2026-05-02 by Muhammad Faiq_
