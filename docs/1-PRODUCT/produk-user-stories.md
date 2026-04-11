# User Stories — Sistem Parkir MKK

> **Versi**: 1.0 — Java Terminal Application
> **Mata Kuliah**: DPBO (Dasar Pemrograman Berorientasi Objek)
> **Terakhir Diperbarui**: April 2026

---

## Format User Story

```
Sebagai [AKTOR],
Saya ingin [AKSI],
Sehingga [MANFAAT].

Acceptance Criteria:
- [Kriteria 1]
- [Kriteria 2]
```

---

## Aktor 1: Petugas Operasional

### US-PO-01: Login ke Sistem
```
Sebagai Petugas Operasional,
Saya ingin login ke sistem menggunakan username dan password,
Sehingga saya hanya dapat mengakses fitur yang sesuai dengan peran saya.

Acceptance Criteria:
- Sistem menampilkan form login (input username dan password) di terminal
- Jika login berhasil, sistem menampilkan menu Petugas Operasional
- Jika login gagal, sistem menampilkan pesan error dan meminta input ulang
- Password tidak ditampilkan saat diketik (atau diganti dengan asterisk)
- Maksimal 3 kali percobaan login sebelum akun terkunci sementara
```
**Prioritas**: Must Have | **Story Points**: 3

---

### US-PO-02: Registrasi Kendaraan Masuk
```
Sebagai Petugas Operasional,
Saya ingin mencatat kendaraan yang masuk area parkir,
Sehingga data kendaraan tersimpan dan tiket parkir bisa diberikan.

Acceptance Criteria:
- Sistem meminta input: plat nomor dan jenis kendaraan (motor/mobil)
- Sistem secara otomatis mencatat waktu masuk
- Sistem menghasilkan kode tiket unik
- Sistem menampilkan struk masuk berisi: kode tiket, plat nomor, waktu masuk
- Data kendaraan tersimpan di repository in-memory
```
**Prioritas**: Must Have | **Story Points**: 5

---

### US-PO-03: Simulasi Capture Visual Saat Masuk
```
Sebagai Petugas Operasional,
Saya ingin mencatat identitas visual pengendara saat masuk,
Sehingga data ini bisa digunakan untuk verifikasi saat keluar.

Acceptance Criteria:
- Sistem meminta input deskripsi ciri-ciri pengendara (simulasi foto wajah)
- Data visual tersimpan dan terhubung dengan tiket parkir
- Data visual hanya bisa diakses saat proses kendaraan keluar
```
**Prioritas**: Must Have | **Story Points**: 3

---

### US-PO-04: Proses Kendaraan Keluar (Scan Tiket)
```
Sebagai Petugas Operasional,
Saya ingin memproses kendaraan yang akan keluar dengan scan tiket,
Sehingga data kendaraan dan tarif parkir bisa ditampilkan.

Acceptance Criteria:
- Sistem meminta input kode tiket
- Jika tiket valid, sistem menampilkan: plat nomor, jenis kendaraan, waktu masuk, durasi parkir
- Jika tiket tidak ditemukan, sistem menampilkan pesan error
- Sistem menampilkan deskripsi visual pengendara saat masuk untuk perbandingan
```
**Prioritas**: Must Have | **Story Points**: 5

---

### US-PO-05: Auto-Billing (Perhitungan Tarif Otomatis)
```
Sebagai Petugas Operasional,
Saya ingin tarif parkir dihitung otomatis oleh sistem,
Sehingga tidak ada manipulasi tarif secara manual.

Acceptance Criteria:
- Sistem menghitung tarif berdasarkan durasi parkir dan jenis kendaraan
- Tarif motor: Rp 2.000/jam (minimal 1 jam)
- Tarif mobil: Rp 5.000/jam (minimal 1 jam)
- Petugas TIDAK bisa menginput tarif secara manual
- Total tarif ditampilkan sebelum proses pembayaran
```
**Prioritas**: Must Have | **Story Points**: 3

---

### US-PO-06: Validasi Visual Pengendara
```
Sebagai Petugas Operasional,
Saya ingin memverifikasi bahwa pengendara yang keluar sama dengan yang masuk,
Sehingga risiko pencurian kendaraan dapat diminimalisir.

Acceptance Criteria:
- Sistem menampilkan data visual pengendara saat masuk
- Petugas memilih: "Cocok" atau "Tidak Cocok"
- Jika cocok: lanjut ke pembayaran
- Jika tidak cocok: gate ditahan, sistem menampilkan alert "PANGGIL SECURITY"
- Keputusan validasi tercatat di log aktivitas
```
**Prioritas**: Must Have | **Story Points**: 3

---

### US-PO-07: Proses Pembayaran
```
Sebagai Petugas Operasional,
Saya ingin memproses pembayaran parkir,
Sehingga transaksi tercatat dan kendaraan bisa keluar.

Acceptance Criteria:
- Sistem menampilkan total tarif yang harus dibayar
- Petugas menginput jumlah uang yang diterima
- Jika uang kurang: sistem menampilkan "Pembayaran Kurang" dan meminta input ulang
- Jika uang cukup: sistem menghitung kembalian dan menampilkan struk
- Transaksi tercatat otomatis ke data keuangan
- Simulasi gate terbuka ditampilkan di terminal
```
**Prioritas**: Must Have | **Story Points**: 5

---

### US-PO-08: Penanganan Tiket Hilang
```
Sebagai Petugas Operasional,
Saya ingin memproses kendaraan yang kehilangan tiket parkir,
Sehingga kendaraan tetap bisa keluar dengan prosedur khusus.

Acceptance Criteria:
- Sistem meminta input: plat nomor, nomor STNK, nomor KTP pemilik
- Sistem mencari data kendaraan berdasarkan plat nomor
- Jika data ditemukan: sistem menghitung denda (tarif normal + biaya tiket hilang)
- Jika data tidak ditemukan: sistem menolak dan minta konfirmasi manual
- Semua data tiket hilang tercatat di log khusus
- Proses tetap memerlukan validasi visual
```
**Prioritas**: Must Have | **Story Points**: 8

---

### US-PO-09: Logout dari Sistem
```
Sebagai Petugas Operasional,
Saya ingin keluar dari sistem setelah selesai bertugas,
Sehingga akun saya aman dari penggunaan orang lain.

Acceptance Criteria:
- Sistem menampilkan konfirmasi logout (Y/N)
- Jika Y: sistem mencatat waktu logout dan kembali ke halaman login
- Jika N: kembali ke menu utama
```
**Prioritas**: Must Have | **Story Points**: 1

---

## Aktor 2: Supervisor

### US-SV-01: Login & Akses Menu Supervisor
```
Sebagai Supervisor,
Saya ingin masuk ke sistem dan melihat menu khusus supervisor,
Sehingga saya dapat melakukan monitoring tanpa mengakses fitur operasional.

Acceptance Criteria:
- Login menggunakan role Supervisor
- Menu yang tampil: Dashboard, Log Aktivitas, Manajemen User, Kinerja Petugas
- Supervisor TIDAK bisa mengakses fitur operasional (masuk/keluar kendaraan)
```
**Prioritas**: Must Have | **Story Points**: 2

---

### US-SV-02: Melihat Dashboard Statistik
```
Sebagai Supervisor,
Saya ingin melihat statistik operasional parkir hari ini,
Sehingga saya bisa memantau kondisi parkir secara keseluruhan.

Acceptance Criteria:
- Dashboard menampilkan: total kendaraan masuk, total keluar, kendaraan aktif di area
- Dashboard menampilkan: total pendapatan hari ini
- Dashboard menampilkan: jumlah tiket hilang hari ini
- Data diambil real-time dari repository in-memory
```
**Prioritas**: Should Have | **Story Points**: 5

---

### US-SV-03: Melihat Log Aktivitas
```
Sebagai Supervisor,
Saya ingin melihat riwayat semua aktivitas operasional,
Sehingga saya bisa mengidentifikasi aktivitas yang mencurigakan.

Acceptance Criteria:
- Sistem menampilkan daftar log: waktu, petugas, aksi, detail
- Log bisa difilter berdasarkan tanggal dan jenis aksi
- Log tiket hilang ditandai khusus
- Log validasi gagal ditandai sebagai "ALERT"
```
**Prioritas**: Should Have | **Story Points**: 5

---

### US-SV-04: Manajemen Pengguna (Tambah User)
```
Sebagai Supervisor,
Saya ingin menambahkan pengguna baru ke sistem,
Sehingga petugas baru bisa mengakses sistem.

Acceptance Criteria:
- Input: nama, username, password, role (Petugas/Keuangan/Supervisor)
- Validasi: username harus unik
- Password minimal 6 karakter
- User baru langsung tersimpan dan bisa login
```
**Prioritas**: Should Have | **Story Points**: 3

---

### US-SV-05: Manajemen Pengguna (Hapus User)
```
Sebagai Supervisor,
Saya ingin menghapus pengguna dari sistem,
Sehingga akun yang sudah tidak dipakai tidak bisa diakses.

Acceptance Criteria:
- Sistem menampilkan daftar user
- Supervisor memilih user yang akan dihapus
- Konfirmasi sebelum hapus
- User yang sedang login tidak bisa dihapus
- Supervisor tidak bisa menghapus dirinya sendiri
```
**Prioritas**: Could Have | **Story Points**: 3

---

### US-SV-06: Melihat Kinerja Petugas
```
Sebagai Supervisor,
Saya ingin melihat statistik kinerja setiap petugas,
Sehingga saya bisa mengevaluasi performa kerja mereka.

Acceptance Criteria:
- Tampilkan per petugas: total transaksi, total tiket hilang yang diproses
- Tampilkan total pendapatan yang dihasilkan per petugas
- Data diurutkan dari yang paling banyak transaksi
```
**Prioritas**: Could Have | **Story Points**: 5

---

### US-SV-07: Flag Aktivitas Mencurigakan
```
Sebagai Supervisor,
Saya ingin menandai aktivitas yang mencurigakan dalam log,
Sehingga aktivitas tersebut bisa ditindaklanjuti.

Acceptance Criteria:
- Supervisor bisa memilih log tertentu dan menandainya sebagai "Suspicious"
- Log yang ditandai muncul di bagian atas dengan highlight
- Sistem menyimpan catatan siapa yang menandai dan kapan
```
**Prioritas**: Could Have | **Story Points**: 3

---

## Aktor 3: Staff Keuangan

### US-SK-01: Login & Akses Menu Keuangan
```
Sebagai Staff Keuangan,
Saya ingin masuk ke sistem dan melihat menu khusus keuangan,
Sehingga saya dapat mengelola dan mengaudit data keuangan.

Acceptance Criteria:
- Login menggunakan role Staff Keuangan
- Menu yang tampil: Laporan Harian, Detail Transaksi, Laporan Tiket Hilang, Rekonsiliasi
- Staff Keuangan TIDAK bisa mengakses fitur operasional
```
**Prioritas**: Must Have | **Story Points**: 2

---

### US-SK-02: Melihat Laporan Pendapatan Harian
```
Sebagai Staff Keuangan,
Saya ingin melihat ringkasan pendapatan parkir hari ini,
Sehingga saya bisa mencatat laporan keuangan harian.

Acceptance Criteria:
- Laporan menampilkan: total pendapatan, jumlah transaksi, rata-rata per transaksi
- Breakdown per jenis kendaraan (motor vs mobil)
- Breakdown per jenis transaksi (normal vs tiket hilang)
- Total denda tiket hilang ditampilkan terpisah
```
**Prioritas**: Should Have | **Story Points**: 5

---

### US-SK-03: Melihat Detail Semua Transaksi
```
Sebagai Staff Keuangan,
Saya ingin melihat detail setiap transaksi,
Sehingga saya bisa memverifikasi kebenaran data keuangan.

Acceptance Criteria:
- Tabel transaksi berisi: ID, waktu, plat nomor, durasi, tarif, petugas yang memproses
- Bisa difilter berdasarkan jenis transaksi (normal/tiket hilang)
- Total di bagian bawah tabel
```
**Prioritas**: Should Have | **Story Points**: 5

---

### US-SK-04: Melihat Laporan Tiket Hilang
```
Sebagai Staff Keuangan,
Saya ingin melihat ringkasan semua kejadian tiket hilang,
Sehingga saya bisa memantau potensi fraud dan total denda.

Acceptance Criteria:
- Tabel berisi: waktu, plat nomor, nomor STNK, nomor KTP, denda, petugas
- Total denda tiket hilang ditampilkan
- Jumlah kejadian tiket hilang hari ini vs rata-rata
```
**Prioritas**: Should Have | **Story Points**: 3

---

### US-SK-05: Rekonsiliasi Kas
```
Sebagai Staff Keuangan,
Saya ingin membandingkan total transaksi sistem dengan kas fisik,
Sehingga saya bisa mendeteksi perbedaan/kebocoran.

Acceptance Criteria:
- Sistem menampilkan total pendapatan dari transaksi
- Staff menginput total kas fisik yang dihitung manual
- Sistem menghitung selisih
- Jika selisih > 0: tampilkan "SURPLUS" dengan detail
- Jika selisih < 0: tampilkan "DEFISIT — PERLU INVESTIGASI" dengan warning
- Jika selisih = 0: tampilkan "COCOK ✓"
```
**Prioritas**: Could Have | **Story Points**: 5

---

### US-SK-06: Cetak Laporan (Export ke Console)
```
Sebagai Staff Keuangan,
Saya ingin mencetak laporan dalam format yang rapi di terminal,
Sehingga saya bisa mendokumentasikan data keuangan.

Acceptance Criteria:
- Pilih jenis laporan: Harian / Transaksi / Tiket Hilang
- Laporan ditampilkan dalam format terstruktur (tabel ASCII)
- Header berisi: nama perusahaan, tanggal, jenis laporan
- Footer berisi: total dan tanda tangan digital (nama penanggung jawab)
```
**Prioritas**: Could Have | **Story Points**: 3

---

## Story Map

```
┌─────────────────────────────────────────────────────────────────────────────────┐
│                          STORY MAP — SISTEM PARKIR MKK                         │
├─────────────────────────────────────────────────────────────────────────────────┤
│                                                                                 │
│  JOURNEY:  Login ──→ Operasi Harian ──→ Monitoring ──→ Laporan ──→ Logout      │
│                                                                                 │
│  ┌──────────┐  ┌────────────────────────────┐  ┌───────────┐  ┌──────────┐     │
│  │  LOGIN   │  │    OPERASI PARKIR          │  │ MONITORING│  │ KEUANGAN │     │
│  ├──────────┤  ├────────────────────────────┤  ├───────────┤  ├──────────┤     │
│  │ PO-01    │  │ PO-02  PO-04  PO-08       │  │ SV-02     │  │ SK-02    │     │
│  │ SV-01    │  │ PO-03  PO-05  PO-06       │  │ SV-03     │  │ SK-03    │     │
│  │ SK-01    │  │ PO-07                      │  │ SV-04     │  │ SK-04    │     │
│  │          │  │                            │  │ SV-06     │  │ SK-05    │     │
│  │          │  │                            │  │ SV-07     │  │ SK-06    │     │
│  └──────────┘  └────────────────────────────┘  └───────────┘  └──────────┘     │
│                                                                                 │
│  PRIORITAS:  🔴 Must Have    🟡 Should Have    🟢 Could Have                    │
│                                                                                 │
└─────────────────────────────────────────────────────────────────────────────────┘
```

---

## Ringkasan Story Points

| Aktor | Must Have | Should Have | Could Have | Total |
|-------|:--------:|:-----------:|:----------:|:-----:|
| Petugas Operasional | 36 | 0 | 0 | **36** |
| Supervisor | 2 | 10 | 11 | **23** |
| Staff Keuangan | 2 | 13 | 8 | **23** |
| **Total** | **40** | **23** | **19** | **82** |
