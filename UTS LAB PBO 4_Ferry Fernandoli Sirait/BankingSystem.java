import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
public class BankingSystem {

    private ArrayList<BankAccount> bankAccounts;

    public BankingSystem() {
        this.bankAccounts = new ArrayList<>();
    }

    public void showMenu() {
        System.out.println("+----------------------------------------+");
        System.out.println("| Silahkan pilih program yang anda mau   |");
        System.out.println("| 1.Registrasi Akun Baru                 |");
        System.out.println("| 2.Mengirim Uang                        |");
        System.out.println("| 3.Menyimpan Uang                       |");
        System.out.println("| 4.Mengecek Informasi rekening pribadi  |");
        System.out.println("| 5.Keluar                               |");
        System.out.println("+----------------------------------------+");

        System.out.print("Kode anda : ");
        Scanner scanner = new Scanner(System.in);
        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                registrasiAkunBaru();
                break;
            case 2:
                kirimUang();
                break;
            case 3:
                simpanUang();
                break;
            case 4:
                cekInformasiRekening();
                break;
            case 5:
                System.out.println("Terima kasih telah menggunakan Sistem Perbankan CLI!");
                System.exit(0);
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
        
    }

    private void registrasiAkunBaru() {
        System.out.println("===================================================");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan alamat: ");
        String alamat = scanner.nextLine();

        System.out.print("Masukkan nomor telepon: ");
        String nomorTelepon = scanner.nextLine();

        System.out.print("Masukkan saldo awal: ");
        int saldoAwal = scanner.nextInt();

        BankAccount newAccount = new BankAccount(nama, alamat, nomorTelepon, saldoAwal);
        bankAccounts.add(newAccount);

        System.out.println("Akun baru telah dibuat!\nInformasi Akun:");
        newAccount.showDescription();
    }

    private void kirimUang() {
        System.out.println("===================================================");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nomor akun pengirim: ");
        String nomorAkunPengirim = scanner.nextLine();

        System.out.print("Masukkan nomor akun penerima: ");
        String nomorAkunPenerima = scanner.nextLine();

        System.out.print("Masukkan jumlah uang yang akan ditransfer: ");
        int jumlahTransfer = scanner.nextInt();

        BankAccount pengirim = findAccount(nomorAkunPengirim);
        BankAccount penerima = findAccount(nomorAkunPenerima);

        if (pengirim != null && penerima != null) {
            if (pengirim.getSaldo() >= jumlahTransfer) {
                pengirim.transfer(jumlahTransfer);
                penerima.topUp(jumlahTransfer);
                System.out.println("===================================================");
                System.out.println("Transfer berhasil!");
                System.out.printf("Saldo %s: Rp%,d\n", pengirim.getNama(), pengirim.getSaldo());
                System.out.printf("Saldo %s: Rp%,d\n", penerima.getNama(), penerima.getSaldo());
            } else {
                System.out.println("Saldo akun pengirim tidak mencukupi.");
            }
        } else {
            System.out.println("Nomor akun tidak valid.");
        }
    }

    private void simpanUang() {
        System.out.println("===================================================");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nomor akun: ");
        String nomorAkun = scanner.nextLine();

        System.out.print("Masukkan jumlah uang yang akan disimpan: ");
        int jumlahTopUp = scanner.nextInt();

        BankAccount account = findAccount(nomorAkun);
        if (account != null) {
            account.topUp(jumlahTopUp);
            System.out.println("===================================================");
            System.out.println("Uang berhasil disimpan!");
            System.out.printf("Saldo %s: Rp%,d\n", account.getNama(), account.getSaldo());
        } else {
            System.out.println("Nomor akun tidak valid.");
        }
    }
    private void cekInformasiRekening() {
        System.out.println("===================================================");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nomor akun: ");
        String nomorAkun = scanner.nextLine();
    
        BankAccount account = findAccount(nomorAkun);
        if (account != null) {
            account.showDescription();
        } else {
            System.out.println("Nomor akun tidak valid.");
        }
    }
    
    private BankAccount findAccount(String nomorAkun) {
        for (BankAccount account : bankAccounts) {
            if (account.getNomorAkun().equals(nomorAkun)) {
                return account;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        BankingSystem system = new BankingSystem();
    
        while (true) {
            system.showMenu();
        }
    }
    
    }
    
    class BankAccount {
    
        private String nama;
        private String alamat;
        private String nomorTelepon;
        private String nomorAkun;
        private int saldo;
        private LocalDateTime tanggalRegistrasi;
    
        public BankAccount(String nama, String alamat, String nomorTelepon, int saldo) {
            this.nama = nama;
            this.alamat = alamat;
            this.nomorTelepon = nomorTelepon;
            this.nomorAkun = generateNomorAkun();
            this.saldo = saldo;
            this.tanggalRegistrasi = LocalDateTime.now();
        }
    
        public void topUp(int jumlahTopUp) {
            if (jumlahTopUp > 0) {
                this.saldo += jumlahTopUp;
                System.out.println("Saldo berhasil ditambahkan!");
            } else {
                System.out.println("Jumlah top up tidak valid.");
            }
        }
    
        public void transfer(int jumlahTransfer) {
            if (jumlahTransfer > 0 && saldo >= jumlahTransfer) {
                this.saldo -= jumlahTransfer;
                System.out.println("Saldo berhasil ditransfer!");
            } else {
                System.out.println("Saldo tidak mencukupi atau jumlah transfer tidak valid.");
            }
        }
    
        public String generateNomorAkun() {
            StringBuilder nomorAkunBuilder = new StringBuilder();
            Random random = new Random();
    
            for (int i = 0; i < 7; i++) {
                nomorAkunBuilder.append(random.nextInt(10));
            }
    
            return nomorAkunBuilder.toString();
        }
    
        public void showDescription() {
            System.out.println("===================================================");
            System.out.println("Akun bank berhasil dibuat.");
            System.out.println("silahkan menikmati layanan yang kami sediakan");    
            System.out.println("**berikut data registrasi anda**");
            
            
            System.out.println("===================================================");
            System.out.printf("Alamat: %s\n", alamat);
            System.out.printf("Nomor Telepon: %s\n", nomorTelepon);
            System.out.printf("Nomor Akun: %s\n", nomorAkun);
            System.out.printf("Saldo: Rp%,d\n", saldo);
            System.out.printf("Tanggal Registrasi: %s\n", tanggalRegistrasi.toString());
            System.out.println("===================================================");

        }
    
        public String getNama() {
            return nama;
        }
    
        public String getNomorAkun() {
            return nomorAkun;
        }
    
        public int getSaldo() {
            return saldo;
        }
    }