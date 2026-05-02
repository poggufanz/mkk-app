# Perancangan Kebutuhan Perangkat Lunak

## JUKIR — Sistem Manajemen Parkir Berbasis Web dengan Validasi Visual dan Otomasi Transaksi pada PT. Mandiri Kreasi Kolaborasi

Disusun untuk memenuhi Assessment 1 Mata Kuliah Rekayasa Kebutuhan Perangkat Lunak

| Nama | NIM |
|---|---|
| Rhaihan Aditya Hidayat | 103022500105 |
| Glenn Akhtar Fawwaz | 103022530002 |
| Alvin Bagaskara | 103022530032 |
| Muhammad Faiq | 103022500101 |
| Bagas Luhur Pagundi | 103022500021 |

**Kelas:** SE-49-01  
**Dosen Pengampu:** Fadil Al Afgani, S.Kom., M.Kom. (FLF)

**PROGRAM STUDI S1 REKAYASA PERANGKAT LUNAK**  
**FAKULTAS INFORMATIKA**  
**UNIVERSITAS TELKOM**  
**APRIL 2026**

---

## Daftar Isi

- [BAB I — Deskripsi Studi Kasus](#bab-i--deskripsi-studi-kasus)
  - [1.1 Domain Sistem](#11-domain-sistem)
  - [1.2 Scope / Context Sistem](#12-scope--context-sistem)
  - [1.3 Boundary Sistem](#13-boundary-sistem)
- [BAB II — Aktivitas Requirements Elicitation](#bab-ii--aktivitas-requirements-elicitation)
  - [2.1 Planning](#21-planning)
  - [2.2 Preparation](#22-preparation)
  - [2.3 Perform](#23-perform)
  - [2.4 Hasil](#24-hasil)
- [Lampiran](#lampiran)
- [Tanggung Jawab Anggota](#tanggung-jawab-anggota)

---

## BAB I — Deskripsi Studi Kasus

### 1.1 Domain Sistem

Sistem yang dibuat dalam studi kasus ini berada di bidang Sistem Informasi Manajemen Parkir berbasis teknologi web. Domain ini meliputi pengelolaan informasi mengenai operasional area parkir, terutama pada titik keluarnya kendaraan beserta catatan keuangan yang terkait.

Saat ini, PT. Mandiri Kreasi Kolaborasi (MKK) sebagai perusahaan pengelola parkir masih menggunakan pendekatan operasional lapangan yang bersifat konvensional, dan sangat bergantung pada tindakan manual petugas. Meskipun di lapangan sudah ada kamera pemantau dan titik Petugas Operasional, komponen-komponen tersebut masih berdiri sendiri dan belum terhubung ke dalam sebuah sistem manajemen yang pintar.

Masalah yang dibahas berfokus pada tiga kekurangan utama:

1. Risiko tinggi hilangnya kendaraan karena pemeriksaan tiket tidak dicek secara silang oleh sistem.
2. Penggunaan status 'tiket hilang' yang bisa dimanipulasi karena prosedur pencatatan data digital tidak memadai.
3. Pemantauan laporan keuangan yang rentan terjadi kesalahan dan kebocoran karena data operasional di lapangan tidak terintegrasi dengan akurat ke pusat.

### 1.2 Scope / Context Sistem

Sistem yang akan dibuat bertujuan untuk meningkatkan pengelolaan di titik keluar area parkir yang terhubung ke dalam satu platform situs web manajemen parkir. Sistem ini menggantikan proses yang saat ini masih dilakukan secara semi manual.

Konteks pembuatan sistem mencakup empat proses bisnis utama:

**a. Proses validasi kendaraan keluar**  
Sistem menampilkan gambar wajah serta kendaraan yang diambil saat kendaraan masuk, lalu petugas melakukan pengecekan secara visual sebelum gerbang dibuka otomatis.

**b. Proses perhitungan tarif secara otomatis**  
Sistem menghitung biaya parkir sendiri berdasarkan waktu masuk yang sudah disimpan di server, tanpa perlu bantuan atau intervensi dari Petugas Operasional.

**c. Proses penanganan tiket hilang**  
Sistem memaksa petugas untuk menginput nomor STNK dan memfoto KTP pemilik kendaraan sebagai syarat untuk dapat membuka gerbang keluar.

**d. Proses pemantauan dan pelaporan keuangan**  
Supervisor dan Staf Keuangan bisa menggunakan dashboard real-time untuk memantau kegiatan petugas dan melihat laporan pendapatan harian.

### 1.3 Boundary Sistem

**Batasan Fungsional:**

a. Sistem secara eksklusif berfokus pada pengelolaan alur operasional di pintu keluar, yang meliputi validasi antarmuka visual antrian keluar, perhitungan tarif otomatis, dan pencatatan tiket hilang.  
b. Proses di pintu masuk dianggap sebagai data masukan terpisah dan tidak menjadi fokus pengembangan dalam perancangan antarmuka ini.

**Batasan Pengguna:**

a. Sistem hanya dapat diakses melalui antarmuka web browser berbasis desktop/laptop di pos jaga dan komputer kantor.  
b. Aktor yang terlibat dan memiliki hak akses dibatasi pada tiga peran: Petugas Operasional, Supervisor, dan Staf Keuangan.

**Batasan Teknis:**

a. Sistem difokuskan secara ketat pada pengembangan perangkat lunak untuk menangani logika deteksi dan validasi visual pada web.  
b. Sistem tidak mencakup pembuatan, perakitan, atau instalasi perangkat keras IoT fisik seperti palang otomatis baru, sensor fisik, atau mikrokontroler. Sistem hanya bertugas menerima dan mengolah data dari kamera eksisting sebagai input software.  
c. Data transaksi dan log gambar disimpan di server lokal/pusat perusahaan yang membutuhkan koneksi internet yang stabil untuk menampilkan pembaruan dashboard secara langsung.

---

## BAB II — Aktivitas Requirements Elicitation

### 2.1 Planning

#### 2.1.1 Objective dan Visi

**Objective:** Mengumpulkan kebutuhan fungsional dan non-fungsional yang lengkap dan valid dari seluruh pemangku kepentingan sistem parkir PT. MKK.

**Visi:** Terwujudnya Sistem Informasi Manajemen Parkir yang terintegrasi penuh guna menjamin keamanan operasional, transparansi finansial, dan akuntabilitas sistem secara menyeluruh.

**Business Rules:**

a. Setiap kendaraan yang akan keluar dari area parkir diwajibkan melalui proses validasi visual melalui sistem sebelum gerbang (barrier pintu keluar) dibuka.  
b. Sistem melakukan kalkulasi tarif parkir secara otomatis berdasarkan rekam waktu masuk kendaraan. Petugas lapangan tidak memiliki hak akses untuk mengubah nominal tarif secara manual.  
c. Setiap penyelesaian kasus kehilangan tiket wajib disertai bukti dokumen digital ke dalam sistem, berupa foto KTP pemilik kendaraan dan pencatatan nomor STNK.  
d. Laporan keuangan harian dan data transaksi hanya dapat diakses oleh akun dengan role Supervisor dan Staf Keuangan.  
e. Sistem harus beroperasi secara terus-menerus (24 jam) dengan tingkat ketersediaan layanan minimum sebesar 99,8%.

#### 2.1.2 User Class

| No | User Class | Deskripsi | Kebutuhan Utama | Tingkat Kepentingan |
|---|---|---|---|---|
| 1 | Petugas Operasional | Staf lapangan yang bertugas di pos pintu keluar, melakukan validasi kendaraan dan memproses pembayaran parkir | Kemudahan dan kecepatan proses validasi kendaraan keluar, tampilan foto kendaraan/wajah, penanganan tiket hilang | Tinggi (pengguna yang paling sering berinteraksi dengan sistem) |
| 2 | Supervisor (Divisi Pengawas) | Pengawas operasional yang memantau kinerja petugas di lapangan dan memastikan semua SOP dijalankan dengan benar | Dashboard monitoring real-time, log aktivitas petugas, akses laporan harian | Tinggi (supervisi dan kontrol operasional) |
| 3 | Staf Keuangan (Divisi Finance) | Staf yang memiliki tugas untuk mencatat setiap transaksi, membuat laporan keuangan, serta melakukan pemeriksaan internal | Laporan pendapatan harian yang akurat, konfigurasi tarif parkir, grafik tren pemasukan dalam interval waktu tertentu | Sedang (pengguna pelaporan dan audit) |

#### 2.1.3 Requirement dan Teknik Elisitasi

| No | Kebutuhan | Tipe Requirements | Tipe Teknik Elisitasi | Target Responden |
|---|---|---|---|---|
| 1 | Validasi visual kendaraan saat keluar | Must Have | Wawancara | Petugas Operasional |
| 2 | Penghitungan tarif parkir otomatis | Must Have | Wawancara | Petugas Operasional |
| 3 | Log aktivitas transaksi dan tiket hilang | Must Have | Wawancara | Supervisor, Staf Keuangan |
| 4 | Login dengan otoritas sesuai user class | Must Have | Wawancara, Document Centric | Semua User |
| 5 | Laporan pendapatan dan export data | Must Have | Wawancara, Document Centric | Staf Keuangan |
| 6 | Dashboard monitoring aktivitas real-time | Satisfier | Wawancara | Supervisor |

#### 2.1.4 Jadwal Pelaksanaan Elisitasi

| No | Kegiatan | Teknik | Tanggal | Tempat | PIC |
|---|---|---|---|---|---|
| 1 | Wawancara Head Accountant | Wawancara | 30 April 2026 | Zoom Online | Glenn Akhtar Fawwaz & Muhammad Faiq |
| 2 | Wawancara Supervisor | Wawancara | 30 April 2026 | Zoom Online | Glenn Akhtar Fawwaz & Muhammad Faiq |
| 3 | Wawancara Staf Keuangan | Wawancara | 30 April 2026 | Zoom Online | Glenn Akhtar Fawwaz & Muhammad Faiq |
| 4 | Meninjau Dokumen Company Profile MKK | Document Centric | 29 April 2026 | Online (Diskusi Kelompok) | Rhaihan Aditya Hidayat |
| 5 | Laporan Tugas Besar Manajemen | Document Centric | 29 April 2026 | Online (Diskusi Kelompok) | Rhaihan Aditya Hidayat |

---

### 2.2 Preparation

#### 2.2.1 Daftar Pertanyaan Wawancara

**Wawancara Supervisor (Ibu Runi)**

a. Apakah sistem parkir yang saat ini berjalan sudah cukup aman dari sisi keamanan kendaraan?  
b. Pernahkah terjadi kasus kehilangan kendaraan di area parkir? Bagaimana penanganannya?  
c. Apakah proses pengecekan kendaraan di pintu keluar saat ini sudah efektif di lapangan?  
d. Bagaimana cara Anda memantau kinerja petugas di lapangan saat ini?  
e. Informasi apa yang paling penting untuk bisa dipantau secara real-time?  
f. Fitur apa yang menurut Anda paling membantu jika diterapkan pada sistem parkir yang baru?

**Wawancara Staf Keuangan (Pak Dea)**

a. Apakah sistem pencatatan transaksi parkir saat ini sudah akurat? Apakah sering ditemukan selisih data?  
b. Bagaimana proses rekonsiliasi pendapatan parkir harian yang saat ini berjalan?  
c. Bagaimana cara penghitungan tarif parkir saat ini — apakah flat, progresif, atau campuran?  
d. Apakah pembayaran saat ini sudah mendukung metode cashless? Apa kendalanya?  
e. Apa kendala terbesar dalam sistem parkir yang berjalan saat ini dari sisi keuangan?  
f. Fitur apa yang paling Anda butuhkan untuk mempermudah pekerjaan di bagian keuangan?

#### 2.2.2 Daftar Dokumen yang Ditelaah

| No | Nama Sistem / Dokumen | Jenis | Tujuan Penelaahan | Sumber |
|---|---|---|---|---|
| 1 | Company Profile PT. MKK | Dokumen Internal | Memahami visi, misi, proses bisnis, dan infrastruktur yang sudah ada | Pegawai PT. MKK |
| 2 | SOP Operasional Pintu Keluar PT. MKK | Dokumen Internal | Memahami prosedur baku petugas dan dasar aturan bisnis | Divisi Operasional PT. MKK |
| 3 | Format Laporan Keuangan Harian PT. MKK | Dokumen Internal | Memahami kebutuhan format output laporan yang diharapkan staf keuangan | Divisi Finance PT. MKK |
| 4 | Jukir — Aplikasi Parkir (Android) | Sistem Kompetitor | Benchmarking fitur pencatatan kendaraan masuk/keluar, cetak tiket dengan QR code, tarif progresif, dan laporan per periode waktu | Google Play Store (PT Tekno Sari Indonesia) |
| 5 | PARKEE: Kemudahan dalam Parkir (Android/iOS) | Sistem Kompetitor | Benchmarking fitur pembayaran cashless (QR/e-wallet/RFID Wuzz), reservasi parkir, membership digital, dan integrasi IoT pintu keluar | Google Play Store / App Store (PT Inovasi Anak Indonesia) |

---

### 2.3 Perform

#### 2.3.1 Pelaksanaan Wawancara

Wawancara dilaksanakan pada malam hari. Terdapat dua responden yang berpartisipasi dalam sesi wawancara ini.

| No | Responden | Jabatan | Tanggal | Durasi | Temuan Utama |
|---|---|---|---|---|---|
| 1 | Ibu Runi | Supervisor MKK | 30 April 2026 | ± 10 Menit | Sistem parkir belum aman sepenuhnya, pernah ada kehilangan kendaraan, penanganan saat ini pakai asuransi khusus kehilangan, pembayaran campuran cash dan cashless |
| 2 | Pak Dea | Staf Keuangan | 30 April 2026 | ± 10 Menit | Tiket tidak mencantumkan nomor pelat ini celah utamanya, sistem full cashless pernah dicoba tapi gagal karena settlement 2 hari dan risiko transaksi pending, human error jadi kendala terbesar |

**Notulensi Ringkas:**

**Ibu Runi** menyatakan sistem parkir yang berjalan saat ini belum sepenuhnya aman. Pernah terjadi kehilangan kendaraan di beberapa area, dan penanganannya masih mengandalkan asuransi kehilangan bukan pencegahan dari sisi sistem. Pengecekan di pintu keluar dinilai cukup, tapi masih bergantung penuh pada petugas. Pembayaran saat ini campuran antara cash dan cashless.

**Pak Dea** dari sisi keuangan menyebut celah utama ada di tiket parkir yang tidak memuat nomor pelat, sehingga bisa dimanfaatkan untuk tindak kejahatan. Kendala terbesar dari sisi keuangan adalah human error yang muncul dari komponen manual. Pengujian full cashless sebelumnya bermasalah — dana dari pihak ketiga tidak langsung masuk, butuh jeda settlement sekitar dua hari, dan kalau transaksi gagal dananya pending dan tidak tercatat.

---

### 2.4 Hasil

#### 2.4.1 Resume Semua Aktivitas Elisitasi

**a. Temuan dari Wawancara**

1. Tidak ada sistem yang membantu petugas dalam proses validasi visual di pintu keluar. Semuanya bergantung pada ketelitian masing-masing petugas.
2. Tiket parkir tidak mencantumkan nomor pelat kendaraan. Ini yang jadi celah utama dan dikonfirmasi langsung oleh Staf Keuangan.
3. Pernah terjadi kehilangan kendaraan di beberapa area. Saat ini ditangani dengan asuransi, bukan dengan pencegahan dari sistem.
4. Sistem pembayaran campuran cash dan cashless. Uji coba full cashless sebelumnya gagal karena settlement dana butuh dua hari, dan transaksi yang gagal menyebabkan dana pending yang tidak masuk ke pencatatan.
5. Kendala terbesar: human error dari komponen manual di proses validasi dan transaksi.
6. Fitur yang paling diharapkan: cashless yang andal dan validasi visual kendaraan di pintu keluar.

**b. Temuan dari Telaah Dokumen dan Sistem Kompetitor**

Berdasarkan telaah pada sistem kompetitor (aplikasi Jukir dan PARKEE), standar industri saat ini sudah mengandalkan integrasi perangkat keras (Kamera/IoT) dengan dashboard berbasis cloud. Kompetitor juga sudah mengimplementasikan pembayaran cashless yang terintegrasi langsung dengan gerbang otomatis (tanpa masukan manual petugas), serta menyediakan fitur pelaporan real-time yang dapat ditarik (export) kapan saja oleh pihak manajemen.

#### 2.4.2 Tabel Daftar Kebutuhan Fungsional

| Kode | No | Kebutuhan Fungsional (Format EARS) | Tipe | Teknik Perolehan | Kriteria Keberhasilan | Perspektif |
|---|---|---|---|---|---|---|
| FR-01 | 1 | When a vehicle ticket is scanned at the exit gate, the system shall display the entry photo of the vehicle and the driver within 2 seconds to allow visual verification by the officer. | Must Have | Wawancara Supervisor + Staf Keuangan | Foto ditampilkan ≤ 2 detik setelah scan, petugas bisa membandingkan visual sebelum pintu keluar dibuka. | Sistem |
| FR-02 | 2 | When a vehicle exits, the system shall automatically calculate the parking fee based on the recorded entry timestamp without allowing manual modification by the officer. | Must Have | Wawancara Staf Keuangan | Tarif read-only, tarif dihitung otomatis sesuai durasi dan skema yang berlaku (progresif). | Sistem |
| FR-03 | 3 | When a user reports a lost ticket, the system shall require the officer to input the vehicle's STNK number and upload a photo of the owner's KTP before the exit gate can be opened. | Must Have | Wawancara Supervisor | Tombol buka pintu keluar hanya aktif setelah data STNK dan foto KTP berhasil diunggah. | Sistem |
| FR-04 | 4 | The system shall provide role-based login that grants different access levels to Petugas Operasional, Supervisor, and Staf Keuangan. | Must Have | Wawancara Supervisor + Staf Keuangan | Setiap role hanya bisa akses fitur sesuai haknya, login dengan kredensial salah ditolak sistem. | Sistem |
| FR-05 | 5 | When payment is confirmed, the system shall automatically record the transaction to the central database and trigger the barrier exit gate to open within 1 second. | Must Have | Wawancara Staf Keuangan | Transaksi tersimpan ≤ 1 detik setelah konfirmasi pembayaran, pintu keluar terbuka otomatis tanpa input manual. | Sistem |
| FR-06 | 6 | The system shall display a real-time activity dashboard showing vehicles processed, active officers, and flagged incidents to the Supervisor. | Satisfier | Wawancara Supervisor | Dashboard memuat data terkini ≤ 5 detik, diperbarui otomatis tiap 1 menit tanpa refresh manual. | Sistem |
| FR-07 | 7 | The system shall allow the Staf Keuangan to generate and export daily and monthly revenue reports in PDF and Excel format. | Satisfier | Wawancara Staf Keuangan | Laporan bisa di-generate dan diunduh dalam format .pdf dan .xlsx dalam ≤ 10 detik. | Sistem |
| FR-08 | 8 | When a transaction payment via QRIS or e-wallet is initiated, the system shall confirm the payment status in real-time without relying on third-party settlement delays. | Satisfier | Wawancara Staf Keuangan | Konfirmasi pembayaran muncul ≤ 5 detik, tidak ada jeda settlement, status transaksi langsung tercatat. | Sistem |
| FR-09 | 9 | When suspicious activity is detected, the system shall send an automatic notification to the Supervisor's dashboard and log the incident permanently. | Delighter | Wawancara Supervisor | Notifikasi muncul di dashboard Supervisor ≤ 5 detik setelah insiden ditandai, log tidak bisa dihapus petugas. | Sistem |
| FR-10 | 10 | The system shall allow the Staf Keuangan to configure the base parking rate and progressive hourly rate through the admin settings. | Satisfier | Wawancara Staf Keuangan | Perubahan tarif langsung tersimpan dan otomatis berlaku pada transaksi berikutnya. | Sistem |

#### 2.4.3 Kesimpulan

Dari seluruh kegiatan elisitasi wawancara dengan Supervisor dan Staf Keuangan PT. MKK, dan telaah dokumen, diperoleh beberapa temuan penting. Masalah utama sistem yang berjalan saat ini ada di tiga titik: tidak ada validasi visual berbasis sistem di pintu keluar, tiket tidak memuat identitas kendaraan, dan pencatatan pendapatan tidak akurat karena masih manual.

Kebutuhan paling mendesak (Must Have) mencakup validasi visual di pintu keluar, penghitungan tarif otomatis, dan penanganan tiket hilang yang dikontrol sistem bukan kebijakan petugas per individu. Monitoring real-time untuk supervisor dan pelaporan otomatis untuk staf keuangan masuk kategori Satisfier — dua fitur ini yang akan memangkas habis proses rekonsiliasi manual yang sekarang makan waktu.

Integrasi pembayaran digital yang andal tanpa ketergantungan pihak ketiga dengan jeda settlement masuk Delighter. Ini bukan sekadar fitur tambahan biasa — tim keuangan sudah pernah mengalami sendiri konsekuensi buruknya waktu full cashless dicoba. Sistem baru harus bergeser dari model reaktif (asuransi setelah kehilangan) ke model preventif (validasi sebelum pintu keluar dibuka). Otomasi adalah cara paling realistis untuk menutup celah human error yang jadi akar masalahnya.

---

## Lampiran

### Tabel Penggunaan AI

| No | Tahapan Kegiatan | Tools AI | Bentuk Penggunaan AI | Output dari AI | Modifikasi / Validasi oleh Tim | Keterangan |
|---|---|---|---|---|---|---|
| 1 | Perencanaan (Planning) | Claude (claude.ai/share/43084977-dc55-4570-9afc-91ad5c7f2aae) | Membantu menyusun rencana kegiatan elisitasi | Draft rencana kegiatan | Disesuaikan dengan studi kasus | Digunakan sebagai referensi awal |
| 2 | Cek & Review | Claude (claude.ai/share/11a1cc2e-641a-4399-a786-5476c3d780ca) | Membantu mengecek dan review hasil pengerjaan laporan | Hasil pengecekan dan cara untuk memperbaikinya | Disesuaikan dengan studi kasus | Digunakan sebagai koreksi kesalahan pengerjaan |
| 3 | Penyusunan Bab 2 | Claude (claude.ai/share/26f0ee51-fab0-40be-9aa1-59a8419cb3ff) | Membantu menyusun atau memberikan contoh cara pengerjaan | Hasil pengerjaan kegiatan | Disesuaikan dengan studi kasus | Digunakan sebagai referensi awal |

---

## Tanggung Jawab Anggota

| NIM | Nama | Peran | Tanggung Jawab | Bagian yang Dikerjakan |
|---|---|---|---|---|
| 103022500105 | Rhaihan Aditya Hidayat | Project Manager / Ketua | Mengkoordinasikan seluruh kegiatan | Perencanaan, Bab 1 & Review |
| 103022530002 | Glenn Akhtar Fawwaz | Anggota | Bertanggung jawab atas bagian yang dikerjakannya | Bab 2.3 Perform |
| 103022530032 | Alvin Bagaskara | Anggota | Bertanggung jawab atas bagian yang dikerjakannya | Bab 2.2 Preparation |
| 103022500101 | Muhammad Faiq | Anggota | Bertanggung jawab atas bagian yang dikerjakannya, dan membantu atas pengerjaan dari anggota yang lain | Bab 2.2, 2.3, & 2.4 |
| 103022500021 | Bagas Luhur Pagundi | Anggota | Bertanggung jawab atas bagian yang dikerjakannya | Bab 2.1 Planning |