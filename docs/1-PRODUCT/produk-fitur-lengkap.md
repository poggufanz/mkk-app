# Katalog Fitur Lengkap — Sistem Parkir MKK

> **Versi**: 1.0 — Java Terminal Application
> **Mata Kuliah**: DPBO (Dasar Pemrograman Berorientasi Objek)
> **Terakhir Diperbarui**: April 2026

---

## Ringkasan Sistem

Sistem Parkir Terintegrasi MKK adalah aplikasi berbasis terminal Java yang mengelola seluruh proses operasional parkir PT. Mandiri Kreasi Kolaborasi. Aplikasi ini mengimplementasikan konsep OOP (Encapsulation, Inheritance, Polymorphism, Abstraction) dan menggunakan penyimpanan data in-memory (ArrayList/HashMap).

---

## Daftar Modul & Fitur

### Prioritas Fitur (MoSCoW)

| Prioritas | Keterangan |
|-----------|------------|
| **Must Have** | Fitur wajib ada untuk sistem berjalan |
| **Should Have** | Fitur penting tapi sistem tetap bisa jalan tanpanya |
| **Could Have** | Fitur tambahan yang bagus jika ada |
| **Won't Have** | Tidak dikerjakan di versi ini |

---

## Modul 1: Autentikasi & Manajemen Sesi

**Prioritas**: Must Have
**Aktor**: Semua pengguna

| ID | Fitur | Deskripsi | Input | Output | Prioritas |
|----|-------|-----------|-------|--------|-----------|
| AUTH-01 | Login | Pengguna masuk ke sistem dengan username dan password | Username, Password | Menu sesuai role | Must Have |
| AUTH-02 | Logout | Pengguna keluar dari sistem dan kembali ke menu login | Konfirmasi (Y/N) | Kembali ke halaman login | Must Have |
| AUTH-03 | Validasi Role | Sistem menampilkan menu berbeda berdasarkan role pengguna | — (otomatis setelah login) | Menu role-specific | Must Have |
| AUTH-04 | Ganti Password | Pengguna dapat mengganti password sendiri | Password lama, Password baru | Konfirmasi perubahan | Should Have |
| AUTH-05 | Session Tracking | Sistem mencatat waktu login dan logout pengguna | — (otomatis) | Log sesi aktif | Should Have |

**Konsep OOP yang diterapkan**:
- **Inheritance**: Kelas `User` (abstract) → `PetugasOperasional`, `Supervisor`, `StaffKeuangan`
- **Polymorphism**: Method `tampilkanMenu()` berbeda di setiap subclass
- **Encapsulation**: Password di-hash dan disimpan private

---

## Modul 2: Kendaraan Masuk

**Prioritas**: Must Have
**Aktor**: Petugas Operasional

| ID | Fitur | Deskripsi | Input | Output | Prioritas |
|----|-------|-----------|-------|--------|-----------|
| MSK-01 | Registrasi Masuk | Mencatat data kendaraan yang masuk area parkir | Plat nomor, Jenis kendaraan | Tiket parkir (kode unik) | Must Have |
| MSK-02 | Simulasi Scan Plat | Simulasi pembacaan plat nomor kendaraan (input manual di terminal) | Plat nomor | Data plat terverifikasi | Must Have |
| MSK-03 | Simulasi Foto Wajah | Simulasi capture wajah pengendara (input deskripsi di terminal) | Deskripsi ciri wajah/ID referensi | Data identitas visual tersimpan | Must Have |
| MSK-04 | Generate Tiket | Sistem membuat tiket unik dengan barcode simulasi | — (otomatis) | Kode tiket + waktu masuk | Must Have |
| MSK-05 | Cetak Struk Masuk | Menampilkan detail tiket masuk di terminal | — (otomatis setelah registrasi) | Struk berisi plat, waktu, kode tiket | Should Have |

**Konsep OOP yang diterapkan**:
- **Abstraction**: Interface `Scannable` untuk simulasi scan
- **Encapsulation**: Data kendaraan dibungkus dalam objek `Kendaraan`
- **Factory Pattern**: `TiketFactory` untuk membuat tiket baru

---

## Modul 3: Kendaraan Keluar & Pembayaran

**Prioritas**: Must Have
**Aktor**: Petugas Operasional

| ID | Fitur | Deskripsi | Input | Output | Prioritas |
|----|-------|-----------|-------|--------|-----------|
| KLR-01 | Scan Tiket Keluar | Memproses tiket saat kendaraan akan keluar | Kode tiket | Data kendaraan + foto masuk | Must Have |
| KLR-02 | Auto-Billing | Sistem menghitung tarif otomatis berdasarkan durasi parkir | — (otomatis dari data tiket) | Total tarif | Must Have |
| KLR-03 | Validasi Visual | Petugas memverifikasi identitas pengendara vs data masuk | Konfirmasi cocok/tidak cocok | Status validasi | Must Have |
| KLR-04 | Proses Pembayaran | Mencatat pembayaran parkir | Jumlah uang diterima | Kembalian + status lunas | Must Have |
| KLR-05 | Buka Gate | Simulasi pembukaan gate setelah pembayaran lunas dan validasi cocok | — (otomatis) | Notifikasi gate terbuka | Must Have |
| KLR-06 | Tahan Gate | Gate ditahan jika validasi visual gagal | — (otomatis jika tidak cocok) | Alert + panggil security | Must Have |
| KLR-07 | Cetak Struk Keluar | Menampilkan struk pembayaran di terminal | — (otomatis setelah pembayaran) | Struk detail transaksi | Should Have |

**Konsep OOP yang diterapkan**:
- **Strategy Pattern**: `TarifStrategy` — strategi perhitungan tarif berbeda (normal, weekend, hari libur)
- **Polymorphism**: `hitungTarif()` override di setiap strategy
- **Observer Pattern**: Notifikasi ke log saat gate terbuka/ditahan

---

## Modul 4: Penanganan Tiket Hilang

**Prioritas**: Must Have
**Aktor**: Petugas Operasional

| ID | Fitur | Deskripsi | Input | Output | Prioritas |
|----|-------|-----------|-------|--------|-----------|
| TKH-01 | Lapor Tiket Hilang | Petugas mencatat laporan tiket hilang | Plat nomor kendaraan | Form input data pendukung | Must Have |
| TKH-02 | Input Data STNK | Mencatat nomor STNK pemilik kendaraan | Nomor STNK | Data STNK tersimpan | Must Have |
| TKH-03 | Input Data KTP | Mencatat nomor KTP pemilik kendaraan | Nomor KTP | Data KTP tersimpan | Must Have |
| TKH-04 | Hitung Denda Otomatis | Sistem menghitung denda berdasarkan tarif tiket hilang | — (otomatis) | Total denda | Must Have |
| TKH-05 | Simpan Log Tiket Hilang | Semua data tiket hilang dicatat dalam log khusus | — (otomatis) | Record log tiket hilang | Must Have |

**Konsep OOP yang diterapkan**:
- **Inheritance**: `LogTiketHilang extends LogAktivitas`
- **Encapsulation**: Data KTP/STNK sensitif disimpan private dengan getter controlled

---

## Modul 5: Dashboard & Monitoring

**Prioritas**: Should Have
**Aktor**: Supervisor

| ID | Fitur | Deskripsi | Input | Output | Prioritas |
|----|-------|-----------|-------|--------|-----------|
| DSB-01 | Statistik Kendaraan | Menampilkan jumlah kendaraan masuk/keluar hari ini | — | Tabel statistik | Should Have |
| DSB-02 | Statistik Pendapatan | Menampilkan total pendapatan hari ini | — | Total pendapatan | Should Have |
| DSB-03 | Daftar Kendaraan Aktif | Menampilkan kendaraan yang masih di area parkir | — | Tabel kendaraan aktif | Should Have |
| DSB-04 | Log Aktivitas | Menampilkan riwayat semua aktivitas sistem | Filter tanggal (opsional) | Tabel log aktivitas | Should Have |
| DSB-05 | Alert Anomali | Menandai aktivitas yang mencurigakan | — (otomatis) | Highlight anomali | Could Have |
| DSB-06 | Kinerja Petugas | Melihat jumlah transaksi per petugas | — | Tabel kinerja petugas | Could Have |

**Konsep OOP yang diterapkan**:
- **Observer Pattern**: Dashboard subscribe ke event transaksi
- **Abstraction**: Interface `Reportable` untuk format data dashboard

---

## Modul 6: Laporan Keuangan

**Prioritas**: Should Have
**Aktor**: Staff Keuangan

| ID | Fitur | Deskripsi | Input | Output | Prioritas |
|----|-------|-----------|-------|--------|-----------|
| KEU-01 | Laporan Harian | Menampilkan ringkasan pendapatan hari ini | Tanggal (default: hari ini) | Laporan terformat | Should Have |
| KEU-02 | Laporan Per Shift | Menampilkan pendapatan per shift kerja | Shift (pagi/siang/malam) | Laporan per shift | Should Have |
| KEU-03 | Detail Transaksi | Menampilkan semua detail transaksi | Filter tanggal | Tabel transaksi lengkap | Should Have |
| KEU-04 | Rekonsiliasi | Membandingkan transaksi sistem vs pendapatan aktual | Input jumlah kas fisik | Status cocok/tidak cocok | Could Have |
| KEU-05 | Ringkasan Tiket Hilang | Laporan khusus semua kejadian tiket hilang | Filter tanggal | Tabel tiket hilang + total denda | Should Have |
| KEU-06 | Export Laporan | Cetak laporan ke format teks di terminal | Pilih jenis laporan | Output terformat ke console | Could Have |

**Konsep OOP yang diterapkan**:
- **Template Method Pattern**: `AbstractLaporan` → method `generate()` dengan step-step yang bisa di-override
- **Polymorphism**: Tipe laporan berbeda menghasilkan format output berbeda

---

## Modul 7: Manajemen Pengguna

**Prioritas**: Should Have
**Aktor**: Supervisor

| ID | Fitur | Deskripsi | Input | Output | Prioritas |
|----|-------|-----------|-------|--------|-----------|
| USR-01 | Lihat Semua User | Menampilkan daftar semua pengguna sistem | — | Tabel user | Should Have |
| USR-02 | Tambah User | Registrasi pengguna baru | Nama, username, password, role | User baru tersimpan | Should Have |
| USR-03 | Edit User | Mengubah data pengguna | ID user + data baru | Data terupdate | Could Have |
| USR-04 | Hapus User | Menghapus pengguna dari sistem | ID user + konfirmasi | User dihapus | Could Have |
| USR-05 | Reset Password | Reset password pengguna lain | ID user + password baru | Password terupdate | Should Have |

**Konsep OOP yang diterapkan**:
- **CRUD operations** melalui `UserRepository`
- **Encapsulation**: Validasi input sebelum simpan

---

## Matriks Fitur vs Aktor

| Modul | Petugas Operasional | Supervisor | Staff Keuangan |
|-------|:-------------------:|:----------:|:--------------:|
| Autentikasi | ✅ | ✅ | ✅ |
| Kendaraan Masuk | ✅ | ❌ | ❌ |
| Kendaraan Keluar & Bayar | ✅ | ❌ | ❌ |
| Tiket Hilang | ✅ | ❌ | ❌ |
| Dashboard & Monitoring | ❌ | ✅ | ❌ |
| Laporan Keuangan | ❌ | ❌ | ✅ |
| Manajemen Pengguna | ❌ | ✅ | ❌ |

---

## Ringkasan Konsep OOP yang Diterapkan

| Konsep | Penerapan Dalam Sistem |
|--------|----------------------|
| **Encapsulation** | Semua atribut `private` dengan getter/setter, validasi di setter |
| **Inheritance** | `User` → subclass per role, `LogAktivitas` → subclass per jenis log |
| **Polymorphism** | `tampilkanMenu()`, `hitungTarif()`, `generateLaporan()` — override di setiap subclass |
| **Abstraction** | Interface `Scannable`, `Reportable`, `Billable`; Abstract class `User`, `AbstractLaporan` |
| **Singleton** | `AuthService` — satu instance untuk seluruh aplikasi |
| **Factory** | `UserFactory`, `TiketFactory` — pembuatan objek terstandarisasi |
| **Strategy** | `TarifStrategy` — algoritma tarif bisa diganti secara dinamis |
| **Observer** | `AktivitasObserver` — logging otomatis saat event terjadi |
| **DAO Pattern** | Semua Repository class — abstraksi akses data in-memory |
| **Template Method** | `AbstractLaporan` — kerangka laporan yang bisa di-extend |

---

## Teknologi & Batasan

| Aspek | Detail |
|-------|--------|
| **Bahasa** | Java 17+ (LTS) |
| **UI** | Terminal / Console (Scanner + System.out) |
| **Penyimpanan** | In-memory (ArrayList, HashMap) — data hilang saat aplikasi ditutup |
| **Build Tool** | Javac manual atau Maven/Gradle (opsional) |
| **IDE** | Bebas (IntelliJ IDEA / VS Code / Eclipse) |
| **Testing** | Manual testing via terminal |
