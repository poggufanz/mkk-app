# Diagram Teknis — Sistem Parkir MKK

> **Versi**: 1.1 — Java Terminal Application
> **Mata Kuliah**: DPBO (Dasar Pemrograman Berorientasi Objek)
> **Terakhir Diperbarui**: Mei 2026
> **Referensi Elisitasi**: FR-01 s/d FR-10 (Laporan Elisitasi RKPL)

---

## Daftar Diagram

1. [Class Diagram (Utama)](#1-class-diagram-utama)
2. [Class Diagram — Model/Entity](#2-class-diagram--modelentity)
3. [Class Diagram — Service Layer](#3-class-diagram--service-layer)
4. [Class Diagram — Repository/DAO Layer](#4-class-diagram--repositorydao-layer)
5. [Class Diagram — Controller Layer](#5-class-diagram--controller-layer)
6. [Class Diagram — Utility & Observer](#6-class-diagram--utility--observer)
7. [Class Diagram — Exception Hierarchy](#7-class-diagram--exception-hierarchy)
8. [Sequence Diagram — Alur Kendaraan Keluar + Fraud Detection](#8-sequence-diagram--alur-kendaraan-keluar--fraud-detection)
9. [Sequence Diagram — Alur Tiket Hilang](#9-sequence-diagram--alur-tiket-hilang)
10. [Sequence Diagram — Alur Kendaraan Masuk + Capacity Check](#10-sequence-diagram--alur-kendaraan-masuk--capacity-check) 🆕
11. [State Diagram — Lifecycle TiketParkir](#11-state-diagram--lifecycle-tiketparkir)
12. [Activity Diagram — Proses Validasi & Pembayaran + Fraud Detection](#12-activity-diagram--proses-validasi--pembayaran--fraud-detection)

---

## 1. Class Diagram (Utama)

Diagram utama yang memuat **seluruh kelas** dan relasi antar kelas dalam sistem.

```mermaid
classDiagram
    direction TB

    %% ─────────────────────────────────────────────
    %% INTERFACES
    %% ─────────────────────────────────────────────

    class IPayable {
        <<interface>>
        + processPayment() void
        + getStatus() String
    }

    class IReportable {
        <<interface>>
        + generateReport() Report
        + exportTo(format String) void
    }

    class INotifiable {
        <<interface>>
        + sendNotification(msg String) void
        + getNotifLog() List
    }

    class IGateControllable {
        <<interface>>
        + openGate() void
        + closeGate() void
    }

    %% ─────────────────────────────────────────────
    %% ABSTRACT CLASSES
    %% ─────────────────────────────────────────────

    class User {
        <<abstract>>
        # userId String
        # username String
        # role Role
        + login() void
        + getAccessMenu() List*
    }

    class PaymentProcessor {
        <<abstract>>
        # amount double
        # paymentTime DateTime
        + processPayment() void*
        + validatePayment() void
        + getStatus() String*
    }

    %% ─────────────────────────────────────────────
    %% CONCRETE USER SUBCLASSES
    %% ─────────────────────────────────────────────

    class PetugasOperasional {
        - shiftStart DateTime
        - posGate int
        + validateVehicle() void
        + handleLostTicket() void
        + confirmPayment() void
        + getAccessMenu() List
    }

    class Supervisor {
        - teamList List~User~
        - shiftDate Date
        + monitorDashboard() void
        + sendNotification(msg String) void
        + approveIncident() void
        + getAccessMenu() List
    }

    class StafKeuangan {
        - reportHistory List~Report~
        - auditLogs List~Log~
        + generateReport() Report
        + exportTo(format String) void
        + configTarif() void
        + getAccessMenu() List
    }

    %% ─────────────────────────────────────────────
    %% CONCRETE PAYMENT SUBCLASSES
    %% ─────────────────────────────────────────────

    class CashPayment {
        - receivedAmount double
        + processPayment() void
        + calcChange() double
        + getStatus() String
    }

    class QrisPayment {
        - qrToken String
        + processPayment() void
        + confirmRealtime() void
        + getStatus() String
    }

    %% ─────────────────────────────────────────────
    %% COLLECTION CLASSES
    %% ─────────────────────────────────────────────

    class Transaction {
        <<collection>>
        - txId String
        - amount double
        - paymentList List~PaymentProcessor~
        - timestamp DateTime
        + addPayment(p PaymentProcessor) void
        + getTotalAmount() double
        + getPaymentByType(t String) List
    }

    class ParkingTicket {
        <<collection>>
        - ticketId String
        - photos List~Image~
        - entryTime DateTime
        - status TicketStatus
        + addPhoto(img Image) void
        + getPhotos() List~Image~
        + markAsLost() void
    }

    class VehicleExitQueue {
        <<collection>>
        - queue Queue~ParkingTicket~
        - maxCapacity int
        + enqueue(t ParkingTicket) void
        + dequeue() ParkingTicket
        + getQueueSize() int
    }

    class RevenueReport {
        <<collection>>
        - txList List~Transaction~
        - period DateRange
        + generateReport() Report
        + exportTo(format String) void
        + filterByDate(d Date) List
    }

    class DashboardMonitor {
        <<collection>>
        - incidents List~Incident~
        - activeTx List~Transaction~
        + refresh() void
        + addIncident(i Incident) void
        + getActiveOfficers() List
    }

    %% ─────────────────────────────────────────────
    %% CONCRETE CLASSES
    %% ─────────────────────────────────────────────

    class TarifCalculator {
        - tarifConfig TarifParkir
        + calculate(minutes int) double
        + calculate(entry DateTime, exit DateTime) double
        + calculate(ticket ParkingTicket) double
        + calculate(minutes int, type String) double
    }

    class GateController {
        - gateId String
        - isOpen boolean
        + openGate() void
        + closeGate() void
        + getStatus() String
    }

    class LostTicketHandler {
        - stnkNumber String
        - ktpPhoto Image
        + handleLost() void
        + uploadKtp(img Image) void
        + validateSTNK() boolean
        + requestGateOpen() void
    }

    class TarifParkir {
        - baseRate double
        - hourlyRate double
        - vehicleType String
        + setRate(base double, hourly double) void
        + getEffectiveRate() double
        + applyDiscount(pct double) void
    }

    class AuthService {
        - sessions Map~String_User~
        + login(u String, p String) boolean
        + logout(userId String) void
        + checkRole(u User) Role
        + hasPermission(u User, feature String) boolean
    }

    class IncidentLogger {
        - logFile String
        - permanentLogs List~Incident~
        + logIncident(i Incident) void
        + sendNotification(msg String) void
        + getLogs() List~Incident~
    }

    %% ─────────────────────────────────────────────
    %% INHERITANCE (User hierarchy)
    %% ─────────────────────────────────────────────
    User <|-- PetugasOperasional
    User <|-- Supervisor
    User <|-- StafKeuangan

    %% INHERITANCE (PaymentProcessor hierarchy)
    PaymentProcessor <|-- CashPayment
    PaymentProcessor <|-- QrisPayment

    %% ─────────────────────────────────────────────
    %% INTERFACE IMPLEMENTATIONS
    %% ─────────────────────────────────────────────
    IPayable <|.. PaymentProcessor
    IReportable <|.. StafKeuangan
    INotifiable <|.. Supervisor
    INotifiable <|.. IncidentLogger
    IGateControllable <|.. GateController

    %% ─────────────────────────────────────────────
    %% ASSOCIATIONS
    %% ─────────────────────────────────────────────
    PetugasOperasional --> PaymentProcessor : uses
    PetugasOperasional --> VehicleExitQueue : manages
    CashPayment ..> Transaction : recorded in
    Transaction --> ParkingTicket : linked to
    TarifCalculator --> TarifParkir : uses config
    LostTicketHandler ..> ParkingTicket : looks up
    LostTicketHandler --> GateController : requests open
    Supervisor --> DashboardMonitor : monitors
    StafKeuangan --> RevenueReport : generates
    StafKeuangan --> TarifParkir : configures
    RevenueReport ..> Transaction : aggregates
    IncidentLogger --> DashboardMonitor : pushes to
    AuthService ..> User : manages sessions
    VehicleExitQueue ..> ParkingTicket : queues
```

---

## 2. Class Diagram — Model/Entity

Fokus pada data domain models, collections, dan relasi pewarisan.

```mermaid
classDiagram
    direction LR

    class User {
        <<abstract>>
        # userId String
        # username String
        # role Role
    }

    class PetugasOperasional {
        - shiftStart DateTime
        - posGate int
    }

    class Supervisor {
        - teamList List~User~
        - shiftDate Date
    }

    class StafKeuangan {
        - reportHistory List~Report~
        - auditLogs List~Log~
    }

    class ParkingTicket {
        - ticketId String
        - photos List~Image~
        - entryTime DateTime
        - status TicketStatus
    }

    class Transaction {
        - txId String
        - amount double
        - paymentList List~PaymentProcessor~
        - timestamp DateTime
    }

    class TarifParkir {
        - baseRate double
        - hourlyRate double
        - vehicleType String
    }

    User <|-- PetugasOperasional
    User <|-- Supervisor
    User <|-- StafKeuangan
    Transaction --> ParkingTicket : references
```

---

## 3. Class Diagram — Service Layer

Fokus pada business logic services, interfaces, dan concrete classes.

```mermaid
classDiagram
    direction TB

    class IPayable {
        <<interface>>
        + processPayment() void
        + getStatus() String
    }

    class IGateControllable {
        <<interface>>
        + openGate() void
        + closeGate() void
    }

    class PaymentProcessor {
        <<abstract>>
        + processPayment() void*
    }

    class CashPayment {
        + processPayment() void
    }

    class QrisPayment {
        + processPayment() void
    }

    class GateController {
        + openGate() void
        + closeGate() void
    }

    class LostTicketHandler {
        + handleLost() void
        + requestGateOpen() void
    }

    class TarifCalculator {
        + calculate() double
    }

    class AuthService {
        + login() boolean
        + logout() void
    }

    class IncidentLogger {
        + logIncident() void
    }

    IPayable <|.. PaymentProcessor
    PaymentProcessor <|-- CashPayment
    PaymentProcessor <|-- QrisPayment
    IGateControllable <|.. GateController
    LostTicketHandler --> GateController : requests open
```

---

## 4. Class Diagram — Repository/DAO Layer

> **Catatan**: Repository/DAO Layer tidak didefinisikan secara eksplisit dalam diagram class arsitektur baru. Penyimpanan data saat ini dikelola dalam memori (in-memory) secara terdistribusi pada objek-objek Collection seperti `VehicleExitQueue`, `RevenueReport`, dan `DashboardMonitor`.

---

## 5. Class Diagram — Controller Layer

> **Catatan**: Controller Layer (seperti menu router CLI) diimplementasikan secara terpisah untuk memicu aksi menu interaktif terminal, yang berinteraksi langsung dengan class `User` (untuk RBAC) dan layer Service (`AuthService`, `GateController`, `LostTicketHandler`).

---

## 6. Class Diagram — Utility & Observer

> **Catatan**: Komponen utility (`DateTimeUtils`, dsb.) bertindak sebagai class pembantu dan tidak digambarkan secara eksplisit pada diagram arsitektur utama untuk menjaga fokus rancangan OOP. Pola notifikasi dan logging diimplementasikan menggunakan interface `INotifiable` yang direalisasikan oleh `Supervisor` dan `IncidentLogger`.

---

## 7. Class Diagram — Exception Hierarchy

```mermaid
classDiagram
    direction TB

    class RuntimeException {
        <<Java Standard Library>>
    }

    class MKKException {
        <<abstract>>
        -String message
        -String errorCode
        +MKKException(String message)
        +MKKException(String message, String errorCode)
        +getErrorCode() String
    }

    class AuthenticationException {
        +AuthenticationException(String message)
    }

    class InvalidCredentialsException {
        +InvalidCredentialsException(String message)
    }

    class AccountLockedException {
        +AccountLockedException(String message)
    }

    class UnauthorizedException {
        +UnauthorizedException(String message)
    }

    class ValidationException {
        +ValidationException(String message)
    }

    class DataNotFoundException {
        +DataNotFoundException(String message)
    }

    class DuplicateDataException {
        +DuplicateDataException(String message)
    }

    class InsufficientPaymentException {
        +InsufficientPaymentException(double required, double received)
    }

    RuntimeException <|-- MKKException
    MKKException <|-- AuthenticationException
    AuthenticationException <|-- InvalidCredentialsException
    AuthenticationException <|-- AccountLockedException
    MKKException <|-- UnauthorizedException
    MKKException <|-- ValidationException
    MKKException <|-- DataNotFoundException
    MKKException <|-- DuplicateDataException
    MKKException <|-- InsufficientPaymentException
```

---

## 8. Sequence Diagram — Alur Kendaraan Keluar + Fraud Detection

```mermaid
sequenceDiagram
    participant U as Petugas (Terminal)
    participant PMC as PetugasMenuController
    participant PS as ParkirService
    participant TPR as TiketParkirRepository
    participant VS as ValidasiService
    participant TS as TarifService
    participant TRS as TransaksiService
    participant TRR as TransaksiRepository
    participant FDS as FraudDetectionService
    participant FR as FraudRule[]
    participant EM as EventManager
    participant AL as AktivitasLogger

    U->>PMC: Pilih "Proses Keluar"
    PMC->>U: Input kode tiket
    U->>PMC: "TKT-20260411-001"
    PMC->>PS: prosesKeluar("TKT-20260411-001")
    PS->>TPR: findByKodeTiket("TKT-20260411-001")
    TPR-->>PS: TiketParkir (status=AKTIF)

    Note over PS,U: FR-01: Foto ditampilkan ≤ 2 detik
    PS->>U: Tampilkan data kendaraan + deskripsi visual
    PS->>VS: validasiVisual(deskripsiMasuk)
    VS->>U: "Cocok? (Y/N)"
    U->>VS: "Y"
    VS-->>PS: true (COCOK)

    Note over PS,TS: FR-02: Tarif read-only, auto-billing
    PS->>TS: hitungTarif(tiketParkir)
    Note over TS: Strategy: TarifNormalStrategy
    TS-->>PS: Rp 20.000

    PS->>U: Tampilkan tarif, input uang
    U->>PS: Rp 50.000

    Note over PS,TRS: FR-05: Transaksi tersimpan otomatis
    PS->>TRS: prosesTransaksi(user, tiket, 50000, NORMAL)
    TRS->>TRR: save(transaksi)
    TRS->>TPR: update(status=KELUAR)

    TRS->>EM: notify(KENDARAAN_KELUAR, data)
    EM->>AL: onEvent(KENDARAAN_KELUAR, data)
    AL->>AL: simpan log

    Note over PS,FDS: FR-09: Post-Transaction Fraud Detection
    rect rgb(255, 240, 240)
        PS->>FDS: analyze(transaksi, petugas)
        FDS->>FR: evaluate(transaksi, petugas) [for each rule]
        FR-->>FDS: FraudAlert (jika anomali)
        alt Ada anomali terdeteksi
            FDS->>EM: notify(FRAUD_DETECTED, alerts)
            Note over FDS: Alert muncul di dashboard Supervisor ≤ 5 detik
        end
        FDS-->>PS: List~FraudAlert~ (bisa kosong)
    end

    Note over PS,U: FR-05: Gate terbuka ≤ 1 detik
    PS->>U: "BARRIER GATE TERBUKA"
    PS-->>PMC: return Transaksi
    PMC->>U: Cetak struk pembayaran
```

---

## 9. Sequence Diagram — Alur Tiket Hilang

```mermaid
sequenceDiagram
    participant U as Petugas (Terminal)
    participant PMC as PetugasMenuController
    participant THS as TiketHilangService
    participant KR as KendaraanRepository
    participant TPR as TiketParkirRepository
    participant TS as TarifService
    participant VS as ValidasiService
    participant TRS as TransaksiService
    participant LR as LogRepository
    participant EM as EventManager

    U->>PMC: Pilih "Tiket Hilang"
    PMC->>U: Input plat nomor
    U->>PMC: "D 5678 ABC"

    PMC->>THS: prosesTiketHilang(user, "D 5678 ABC", stnk, ktp)
    THS->>TPR: findActiveByPlatNomor("D 5678 ABC")
    TPR-->>THS: TiketParkir (ditemukan)

    THS->>VS: validasiVisual(deskripsiMasuk)
    VS->>U: "Cocok? (Y/N)"
    U->>VS: "Y"
    VS-->>THS: true

    THS->>TS: setStrategy(TarifTiketHilangStrategy)
    THS->>TS: hitungTarif(tiketParkir)
    Note over TS: Tarif normal + denda Rp 25.000
    TS-->>THS: Rp 37.000

    THS->>U: Tampilkan total denda, input uang
    U->>THS: Rp 50.000

    THS->>TRS: prosesTransaksi(user, tiket, 50000, TIKET_HILANG)
    THS->>LR: saveLogTiketHilang(logTiketHilang)
    THS->>TPR: update(status=HILANG lalu KELUAR)

    THS->>EM: notify(TIKET_HILANG, data)

    THS->>U: "LOG TERSIMPAN + GATE TERBUKA"
```

---

## 10. Sequence Diagram — Alur Kendaraan Masuk + Capacity Check 🆕

```mermaid
sequenceDiagram
    participant U as Petugas (Terminal)
    participant PMC as PetugasMenuController
    participant PS as ParkirService
    participant KS as KapasitasService
    participant TPR as TiketParkirRepository
    participant KR as KendaraanRepository
    participant EM as EventManager
    participant AL as AktivitasLogger

    U->>PMC: Pilih "Registrasi Masuk"
    PMC->>U: Input plat nomor + jenis kendaraan + deskripsi visual
    U->>PMC: "B 1234 ABC", MOTOR, "Helm hitam, jaket biru"

    PMC->>PS: registrasiMasuk(user, "B 1234 ABC", MOTOR, deskripsi)

    Note over PS,KS: Smart Capacity Check (pre-entry)
    rect rgb(240, 255, 240)
        PS->>KS: isBolehMasuk()
        KS->>TPR: countActive()
        TPR-->>KS: 95 (dari maksimum 100)
        KS->>KS: getPersentaseOkupansi() → 95%
        KS-->>PS: false (PENUH)
        alt Kapasitas PENUH
            PS->>EM: notify(KAPASITAS_PENUH, status)
            PS->>U: "⚠ PARKIRAN PENUH — Tidak bisa menerima kendaraan baru"
            PS-->>PMC: return null
        else Kapasitas tersedia
            PS->>KR: save(kendaraan baru)
            PS->>TPR: save(tiketParkir baru)
            PS->>EM: notify(KENDARAAN_MASUK, data)
            EM->>AL: onEvent(KENDARAAN_MASUK, data)
            AL->>AL: simpan log
            PS->>U: Cetak struk masuk + status kapasitas
            Note over PS: "Status: HAMPIR_PENUH (95%)"
            PS-->>PMC: return TiketParkir
        end
    end
```

---

## 11. State Diagram — Lifecycle TiketParkir

```mermaid
stateDiagram-v2
    [*] --> AKTIF : Kendaraan masuk & tiket dibuat

    AKTIF --> DIBAYAR : Pembayaran berhasil (alur normal)
    AKTIF --> HILANG : Dilaporkan tiket hilang

    HILANG --> DIBAYAR : Denda + tarif dibayar

    DIBAYAR --> KELUAR : Validasi cocok & gate terbuka

    AKTIF --> DITAHAN : Validasi gagal (visual tidak cocok)
    DITAHAN --> AKTIF : Setelah investigasi manual

    KELUAR --> [*] : Kendaraan sudah keluar area

    note right of AKTIF
        Kendaraan masih di area parkir.
        Tiket bisa di-scan untuk keluar.
    end note

    note right of HILANG
        Prosedur khusus: input STNK + KTP.
        Denda otomatis ditambahkan.
    end note

    note right of DITAHAN
        Gate locked.
        Menunggu security.
    end note
```

---

## 12. Activity Diagram — Proses Validasi & Pembayaran + Fraud Detection

```mermaid
flowchart TD
    Start([Petugas pilih Proses Keluar]) --> InputTiket[Input Kode Tiket]
    InputTiket --> CariTiket{Tiket ditemukan?}

    CariTiket -->|Tidak| ErrorTiket[Tampilkan Error: Tiket tidak valid]
    ErrorTiket --> KembaliMenu([Kembali ke Menu])

    CariTiket -->|Ya| TampilData["Tampilkan Data Kendaraan\n(FR-01: ≤ 2 detik)"]
    TampilData --> TampilVisual[Tampilkan Deskripsi Visual Masuk]
    TampilVisual --> InputValidasi{Pengendara cocok?}

    InputValidasi -->|Tidak Cocok| TahanGate[TAHAN GATE]
    TahanGate --> AlertSecurity[Alert: Panggil Security]
    AlertSecurity --> LogAlert[Simpan Log VALIDASI_GAGAL]
    LogAlert --> KembaliMenu

    InputValidasi -->|Cocok| HitungTarif["Hitung Tarif Otomatis\n(FR-02: read-only)"]
    HitungTarif --> TampilTarif[Tampilkan Total Tarif]
    TampilTarif --> InputUang[Input Jumlah Uang]
    InputUang --> CekUang{Uang cukup?}

    CekUang -->|Kurang| PesanKurang[Tampilkan: Uang Kurang]
    PesanKurang --> InputUang

    CekUang -->|Cukup| HitungKembalian[Hitung Kembalian]
    HitungKembalian --> SimpanTransaksi["Simpan Transaksi\n(FR-05: auto-record)"]
    SimpanTransaksi --> UpdateTiket[Update Status Tiket → KELUAR]
    UpdateTiket --> LogTransaksi[Simpan Log KENDARAAN_KELUAR]

    LogTransaksi --> FraudCheck{"Fraud Detection\n(FR-09: post-transaction)"}

    FraudCheck --> Rule1[Rule 1: Tiket Hilang ≥3x]
    FraudCheck --> Rule2[Rule 2: Durasi < 2 menit]
    FraudCheck --> Rule3[Rule 3: Duplikasi Plat]

    Rule1 --> FraudResult{Anomali terdeteksi?}
    Rule2 --> FraudResult
    Rule3 --> FraudResult

    FraudResult -->|Ya| AutoFlag["Auto-Flag + Log\nNotif ke Supervisor ≤ 5 detik"]
    AutoFlag --> CetakStruk[Cetak Struk Pembayaran]

    FraudResult -->|Tidak| CetakStruk

    CetakStruk --> BukaGate["BARRIER GATE TERBUKA\n(FR-05: ≤ 1 detik)"]
    BukaGate --> KembaliMenu
```

---

## Ringkasan Kelas

| Layer | Jumlah Kelas | Kelas |
|-------|:------------:|-------|
| **Model/Entity** | 7 | User*, PetugasOperasional, Supervisor, StaffKeuangan, Kendaraan, TiketParkir, Transaksi |
| **Model/Log** | 2 | LogAktivitas, LogTiketHilang |
| **Model/Enum** | 7 | Role, StatusTiket, JenisKendaraan, JenisTransaksi, EventType, StatusParkiran, FraudSeverity |
| **Interface** | 4 | Reportable, TarifStrategy, EventListener, FraudRule |
| **Service** | 9 | AuthService, ParkirService, TransaksiService, TiketHilangService, LaporanService, ValidasiService, TarifService, KapasitasService, FraudDetectionService |
| **Strategy Impl** | 2 | TarifNormalStrategy, TarifTiketHilangStrategy |
| **Fraud Rule Impl** | 3 | TiketHilangFrequencyRule, DurasiAnomalRule, DuplikasiPlatRule |
| **Repository** | 5 | UserRepository, KendaraanRepository, TiketParkirRepository, TransaksiRepository, LogRepository |
| **Controller** | 4 | MenuController, PetugasMenuController, SupervisorMenuController, KeuanganMenuController |
| **Utility** | 5 | ConsoleHelper, PasswordHasher, DateTimeHelper, IdGenerator, DataMasker |
| **Validator** | 1 | InputValidator |
| **Observer** | 2 | EventManager, AktivitasLogger |
| **Factory** | 1 | UserFactory |
| **Value Object** | 1 | FraudAlert |
| **Exception** | 8 | MKKException*, AuthenticationException, InvalidCredentialsException, AccountLockedException, UnauthorizedException, ValidationException, DataNotFoundException, DuplicateDataException, InsufficientPaymentException |
| **Entry Point** | 1 | Main |
| | | |
| **TOTAL** | **~62 kelas** | |

*\* = abstract class*

> *Catatan: Penambahan ~10 kelas baru (∶19% growth) dari fitur inovasi (Smart Capacity + Fraud Detection) sesuai rekomendasi spike dan menjawab FR-06 dan FR-09 dari elisitasi.*
