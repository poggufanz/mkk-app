# Skenario Demo — Sistem Parkir MKK

> **Versi**: 1.0 — Java Terminal Application
> **Mata Kuliah**: DPBO (Dasar Pemrograman Berorientasi Objek)
> **Terakhir Diperbarui**: April 2026

---

## Cara Menjalankan Demo

```bash
# Compile
javac -d bin src/**/*.java

# Run
java -cp bin com.mkk.parking.Main
```

> Semua skenario di bawah menunjukkan alur interaksi di terminal Java. Teks dalam `[kurung siku]` adalah input pengguna.

---

## Skenario 1: Alur Normal — Kendaraan Masuk hingga Keluar

**Tujuan**: Menunjukkan alur lengkap kendaraan parkir dari masuk, keluar, bayar, sampai gate terbuka.
**Aktor**: Petugas Operasional

### Langkah Demo

**Step 1 — Login sebagai Petugas**
```
╔══════════════════════════════════════════╗
║     SISTEM PARKIR PT. MKK               ║
║     Mandiri Kreasi Kolaborasi            ║
╚══════════════════════════════════════════╝

Username : [petugas01]
Password : [****]

✓ Login berhasil! Selamat datang, Budi (Petugas Operasional)
```

**Step 2 — Menu Petugas Operasional**
```
═══════════════════════════════════════════
        MENU PETUGAS OPERASIONAL
═══════════════════════════════════════════
  [1] Registrasi Kendaraan Masuk
  [2] Proses Kendaraan Keluar
  [3] Penanganan Tiket Hilang
  [4] Ganti Password
  [5] Logout
═══════════════════════════════════════════
Pilih menu : [1]
```

**Step 3 — Registrasi Kendaraan Masuk**
```
═══════════════════════════════════════════
        REGISTRASI KENDARAAN MASUK
═══════════════════════════════════════════

Nomor Plat Kendaraan    : [B 1234 XYZ]
Jenis Kendaraan (1=Motor, 2=Mobil) : [2]
Deskripsi Pengendara    : [Pria, kacamata, jaket hitam]

═══ TIKET PARKIR ══════════════════════════
  Kode Tiket   : TKT-20260411-001
  Plat Nomor   : B 1234 XYZ
  Jenis        : Mobil
  Waktu Masuk  : 2026-04-11 08:30:15
  Ciri Visual  : Pria, kacamata, jaket hitam
═══════════════════════════════════════════
✓ Kendaraan berhasil diregistrasi!

Tekan Enter untuk kembali ke menu...
```

**Step 4 — Proses Kendaraan Keluar** *(beberapa jam kemudian)*
```
═══════════════════════════════════════════
        PROSES KENDARAAN KELUAR
═══════════════════════════════════════════

Kode Tiket : [TKT-20260411-001]

═══ DATA KENDARAAN ════════════════════════
  Plat Nomor   : B 1234 XYZ
  Jenis        : Mobil
  Waktu Masuk  : 2026-04-11 08:30:15
  Waktu Keluar : 2026-04-11 11:45:30
  Durasi       : 3 jam 15 menit (4 jam dihitung)
═══════════════════════════════════════════

═══ VALIDASI VISUAL ═══════════════════════
  Data saat masuk: "Pria, kacamata, jaket hitam"

  Apakah pengendara saat ini COCOK dengan
  deskripsi di atas? (Y/N) : [Y]
  ✓ Validasi visual: COCOK
═══════════════════════════════════════════

═══ PERHITUNGAN TARIF (AUTO-BILLING) ═════
  Tarif Mobil   : Rp 5.000 / jam
  Durasi        : 4 jam
  TOTAL BAYAR   : Rp 20.000
═══════════════════════════════════════════

Jumlah uang diterima : [50000]

═══ STRUK PEMBAYARAN ═════════════════════
  PT. Mandiri Kreasi Kolaborasi
  ─────────────────────────────
  Tiket        : TKT-20260411-001
  Plat         : B 1234 XYZ
  Total Tarif  : Rp 20.000
  Dibayar      : Rp 50.000
  Kembalian    : Rp 30.000
  Petugas      : Budi
  Waktu        : 2026-04-11 11:45:30
  Status       : LUNAS ✓
═══════════════════════════════════════════

  >>> BARRIER GATE TERBUKA <<<
  Kendaraan B 1234 XYZ boleh keluar.

✓ Transaksi berhasil disimpan!
Tekan Enter untuk kembali ke menu...
```

---

## Skenario 2: Tiket Hilang

**Tujuan**: Menunjukkan prosedur khusus untuk kendaraan yang kehilangan tiket.
**Aktor**: Petugas Operasional

### Langkah Demo

**Step 1 — Pilih Menu Tiket Hilang** (setelah login)
```
Pilih menu : [3]

═══════════════════════════════════════════
        PENANGANAN TIKET HILANG
═══════════════════════════════════════════

⚠ PROSEDUR KHUSUS — Data tambahan diperlukan

Nomor Plat Kendaraan : [D 5678 ABC]

Mencari data kendaraan...
✓ Data ditemukan! Kendaraan masuk pada 2026-04-11 07:00:00
```

**Step 2 — Input Data Pendukung**
```
═══ INPUT DATA PENDUKUNG ══════════════════
  Nomor STNK  : [12345678901234]
  Nomor KTP   : [3201234567890001]
═══════════════════════════════════════════

═══ VALIDASI VISUAL ═══════════════════════
  Data saat masuk: "Wanita, hijab putih, tas merah"

  Apakah pengendara saat ini COCOK dengan
  deskripsi di atas? (Y/N) : [Y]
  ✓ Validasi visual: COCOK
═══════════════════════════════════════════
```

**Step 3 — Perhitungan Denda**
```
═══ PERHITUNGAN DENDA TIKET HILANG ═══════
  Jenis Kendaraan : Motor
  Waktu Masuk     : 2026-04-11 07:00:00
  Waktu Keluar    : 2026-04-11 12:30:00
  Durasi          : 5 jam 30 menit (6 jam)

  Tarif Parkir    : 6 x Rp 2.000 = Rp 12.000
  Denda Tiket Hilang              = Rp 25.000
  ─────────────────────────────────────────
  TOTAL BAYAR                     = Rp 37.000
═══════════════════════════════════════════

Jumlah uang diterima : [50000]

═══ STRUK PEMBAYARAN (TIKET HILANG) ══════
  PT. Mandiri Kreasi Kolaborasi
  ─────────────────────────────
  Plat         : D 5678 ABC
  Jenis        : TIKET HILANG
  Tarif Parkir : Rp 12.000
  Denda        : Rp 25.000
  Total        : Rp 37.000
  Dibayar      : Rp 50.000
  Kembalian    : Rp 13.000
  STNK         : 1234567890****
  KTP          : 320123456789****
  Petugas      : Budi
  Status       : LUNAS ✓
═══════════════════════════════════════════

  ⚠ LOG TIKET HILANG TERSIMPAN
  >>> BARRIER GATE TERBUKA <<<

Tekan Enter untuk kembali ke menu...
```

---

## Skenario 3: Validasi Visual Gagal — Security Alert

**Tujuan**: Menunjukkan apa yang terjadi ketika pengendara yang keluar TIDAK cocok dengan data masuk.
**Aktor**: Petugas Operasional

### Langkah Demo

**Step 1 — Proses Keluar dengan Validasi Gagal**
```
═══════════════════════════════════════════
        PROSES KENDARAAN KELUAR
═══════════════════════════════════════════

Kode Tiket : [TKT-20260411-003]

═══ DATA KENDARAAN ════════════════════════
  Plat Nomor   : B 9999 DEF
  Jenis        : Motor
  Waktu Masuk  : 2026-04-11 09:00:00
  Waktu Keluar : 2026-04-11 13:00:00
  Durasi       : 4 jam
═══════════════════════════════════════════

═══ VALIDASI VISUAL ═══════════════════════
  Data saat masuk: "Pria, helm merah, jaket kulit"

  Apakah pengendara saat ini COCOK dengan
  deskripsi di atas? (Y/N) : [N]

  ╔════════════════════════════════════════╗
  ║  ⚠⚠⚠ ALERT: VALIDASI GAGAL ⚠⚠⚠     ║
  ║                                        ║
  ║  BARRIER GATE DITAHAN                  ║
  ║  SEGERA HUBUNGI SECURITY!              ║
  ║                                        ║
  ║  Kendaraan : B 9999 DEF (Motor)        ║
  ║  Petugas   : Budi                      ║
  ║  Waktu     : 2026-04-11 13:00:00       ║
  ╚════════════════════════════════════════╝

  Log alert telah disimpan ke sistem.
  Menunggu investigasi manual...

Tekan Enter untuk kembali ke menu...
```

---

## Skenario 4: Dashboard Keuangan

**Tujuan**: Menunjukkan fitur laporan untuk Staff Keuangan.
**Aktor**: Staff Keuangan

### Langkah Demo

**Step 1 — Login sebagai Staff Keuangan**
```
Username : [finance01]
Password : [****]

✓ Login berhasil! Selamat datang, Sari (Staff Keuangan)

═══════════════════════════════════════════
        MENU STAFF KEUANGAN
═══════════════════════════════════════════
  [1] Laporan Pendapatan Harian
  [2] Detail Transaksi
  [3] Laporan Tiket Hilang
  [4] Rekonsiliasi Kas
  [5] Ganti Password
  [6] Logout
═══════════════════════════════════════════
Pilih menu : [1]
```

**Step 2 — Laporan Pendapatan Harian**
```
═══════════════════════════════════════════
   LAPORAN PENDAPATAN HARIAN
   PT. Mandiri Kreasi Kolaborasi
   Tanggal: 2026-04-11
═══════════════════════════════════════════

  RINGKASAN PENDAPATAN
  ─────────────────────────────────────────
  Total Transaksi     : 47
  Total Pendapatan    : Rp 1.250.000
  Rata-rata/Transaksi : Rp 26.596
  ─────────────────────────────────────────

  BREAKDOWN PER JENIS KENDARAAN
  ┌────────────┬──────────┬──────────────┐
  │ Jenis      │ Jumlah   │ Pendapatan   │
  ├────────────┼──────────┼──────────────┤
  │ Motor      │ 35       │ Rp   420.000 │
  │ Mobil      │ 12       │ Rp   830.000 │
  ├────────────┼──────────┼──────────────┤
  │ TOTAL      │ 47       │ Rp 1.250.000 │
  └────────────┴──────────┴──────────────┘

  BREAKDOWN PER JENIS TRANSAKSI
  ┌────────────┬──────────┬──────────────┐
  │ Jenis      │ Jumlah   │ Pendapatan   │
  ├────────────┼──────────┼──────────────┤
  │ Normal     │ 44       │ Rp 1.100.000 │
  │ Tiket Hilang│ 3       │ Rp   150.000 │
  ├────────────┼──────────┼──────────────┤
  │ TOTAL      │ 47       │ Rp 1.250.000 │
  └────────────┴──────────┴──────────────┘

Tekan Enter untuk kembali ke menu...
```

**Step 3 — Rekonsiliasi Kas**
```
Pilih menu : [4]

═══════════════════════════════════════════
        REKONSILIASI KAS HARIAN
═══════════════════════════════════════════

  Pendapatan Sistem : Rp 1.250.000

  Masukkan total kas fisik : [1.230.000]

  ╔════════════════════════════════════════╗
  ║  ⚠ DEFISIT — PERLU INVESTIGASI        ║
  ║                                        ║
  ║  Pendapatan Sistem : Rp 1.250.000      ║
  ║  Kas Fisik         : Rp 1.230.000      ║
  ║  SELISIH           : Rp   -20.000      ║
  ║                                        ║
  ║  Selisih melebihi toleransi (Rp 5.000) ║
  ║  Silakan lakukan investigasi.          ║
  ╚════════════════════════════════════════╝

  Log rekonsiliasi telah disimpan.
Tekan Enter untuk kembali ke menu...
```

---

## Skenario 5: Supervisor Monitoring

**Tujuan**: Menunjukkan fitur monitoring dan manajemen untuk Supervisor.
**Aktor**: Supervisor

### Langkah Demo

**Step 1 — Login sebagai Supervisor**
```
Username : [supervisor01]
Password : [****]

✓ Login berhasil! Selamat datang, Andi (Supervisor)

═══════════════════════════════════════════
        MENU SUPERVISOR
═══════════════════════════════════════════
  [1] Dashboard Statistik
  [2] Log Aktivitas
  [3] Manajemen Pengguna
  [4] Kinerja Petugas
  [5] Ganti Password
  [6] Logout
═══════════════════════════════════════════
Pilih menu : [1]
```

**Step 2 — Dashboard Statistik**
```
═══════════════════════════════════════════
        DASHBOARD MONITORING
        Tanggal: 2026-04-11
═══════════════════════════════════════════

  ┌─────────────────────┬──────────────┐
  │ Kendaraan Masuk     │          52  │
  │ Kendaraan Keluar    │          47  │
  │ Kendaraan Aktif     │           5  │
  │ Total Pendapatan    │ Rp 1.250.000 │
  │ Tiket Hilang Hari Ini│          3  │
  │ Validasi Gagal      │           1  │
  └─────────────────────┴──────────────┘

  ⚠ ALERT: 1 kejadian validasi gagal hari ini!
  Gunakan menu Log Aktivitas untuk detail.

Tekan Enter untuk kembali ke menu...
```

**Step 3 — Log Aktivitas**
```
Pilih menu : [2]

═══════════════════════════════════════════
        LOG AKTIVITAS SISTEM
═══════════════════════════════════════════

  No │ Waktu            │ Petugas │ Aksi           │ Detail
  ───┼──────────────────┼─────────┼────────────────┼──────────────────
   1 │ 11-04-26 08:30   │ Budi    │ MASUK          │ B 1234 XYZ (Mobil)
   2 │ 11-04-26 08:45   │ Budi    │ MASUK          │ B 5678 GHI (Motor)
   3 │ 11-04-26 09:00   │ Budi    │ MASUK          │ B 9999 DEF (Motor)
   4 │ 11-04-26 11:45   │ Budi    │ KELUAR         │ B 1234 XYZ - Rp 20.000
   5 │ 11-04-26 12:30   │ Budi    │ TIKET HILANG   │ D 5678 ABC - Rp 37.000 ⚠
   6 │ 11-04-26 13:00   │ Budi    │ VALIDASI GAGAL │ B 9999 DEF 🚨 ALERT
   ...

  Total: 102 log | Halaman 1 dari 5
  [N] Halaman Berikutnya  [F] Filter  [B] Kembali

Pilih : [F]

  Filter berdasarkan:
  [1] Semua  [2] Tiket Hilang  [3] Validasi Gagal

Pilih : [3]

  No │ Waktu            │ Petugas │ Aksi           │ Detail
  ───┼──────────────────┼─────────┼────────────────┼──────────────────
   1 │ 11-04-26 13:00   │ Budi    │ VALIDASI GAGAL │ B 9999 DEF 🚨

  Tandai sebagai "Suspicious"? (Y/N) : [Y]
  ✓ Log telah ditandai sebagai suspicious oleh Andi.

Tekan Enter untuk kembali ke menu...
```

**Step 4 — Manajemen Pengguna (Tambah)**
```
Pilih menu : [3]

═══════════════════════════════════════════
        MANAJEMEN PENGGUNA
═══════════════════════════════════════════
  [1] Lihat Semua User
  [2] Tambah User
  [3] Hapus User
  [4] Reset Password
  [5] Kembali
═══════════════════════════════════════════
Pilih : [2]

═══ TAMBAH USER BARU ═════════════════════
  Nama Lengkap : [Dina Permata]
  Username     : [dina01]
  Password     : [****]
  Role (1=Petugas, 2=Supervisor, 3=Keuangan) : [1]

  ✓ User "Dina Permata" berhasil ditambahkan sebagai Petugas Operasional!

Tekan Enter untuk kembali ke menu...
```

---

## Ringkasan Skenario Demo

| # | Skenario | Aktor | Fitur Utama yang Ditunjukkan | Konsep OOP |
|---|----------|-------|------------------------------|------------|
| 1 | Alur Normal | Petugas | Login, Masuk, Keluar, Bayar, Gate | Inheritance, Factory, Strategy |
| 2 | Tiket Hilang | Petugas | Prosedur tiket hilang, denda | Encapsulation, Inheritance |
| 3 | Validasi Gagal | Petugas | Security alert, gate ditahan | Observer, Polymorphism |
| 4 | Dashboard Keuangan | Keuangan | Laporan harian, rekonsiliasi | Template Method, Abstraction |
| 5 | Supervisor Monitoring | Supervisor | Dashboard, log, manajemen user | DAO Pattern, Singleton |

---

## Data Dummy untuk Demo

Untuk kelancaran demo, sistem akan di-preload dengan data berikut:

### User Default
| Username | Password | Role | Nama |
|----------|----------|------|------|
| petugas01 | petugas123 | Petugas Operasional | Budi |
| petugas02 | petugas123 | Petugas Operasional | Rina |
| supervisor01 | super123 | Supervisor | Andi |
| finance01 | finance123 | Staff Keuangan | Sari |

### Kendaraan Aktif (pre-loaded)
| Kode Tiket | Plat Nomor | Jenis | Waktu Masuk | Deskripsi Visual |
|------------|------------|-------|-------------|-----------------|
| TKT-20260411-001 | B 1234 XYZ | Mobil | 08:30 | Pria, kacamata, jaket hitam |
| TKT-20260411-002 | D 5678 ABC | Motor | 07:00 | Wanita, hijab putih, tas merah |
| TKT-20260411-003 | B 9999 DEF | Motor | 09:00 | Pria, helm merah, jaket kulit |
