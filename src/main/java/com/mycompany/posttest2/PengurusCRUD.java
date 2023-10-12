package com.mycompany.posttest2;

import PD.Pengurus;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PengurusCRUD {
    private List<Pengurus> penguruses;
    private int nextId = 1;
    private Scanner scanner;

    public PengurusCRUD() {
        penguruses = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void tambahPengurus() {
        System.out.print("Masukkan nama pengurus: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan ulang tahun pengurus: ");
        String ulangTahun = scanner.nextLine();

        Pengurus pengurus = new Pengurus(nextId, nama, ulangTahun);
        penguruses.add(pengurus);

        System.out.println("Data pengurus telah ditambahkan:");
        System.out.println("ID: " + pengurus.getId());
        System.out.println("Nama: " + pengurus.getNama());
        System.out.println("Ulang Tahun: " + pengurus.getUlangTahun());

        nextId++;
    }

    public List<Pengurus> getDaftarPengurus() {
        return penguruses;
    }

    public void editPengurus() {
        System.out.print("Masukkan ID pengurus yang akan diubah: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Pengurus pengurus = cariPengurus(id);
            if (pengurus != null) {
                System.out.print("Masukkan nama baru: ");
                pengurus.setNama(scanner.nextLine());
                System.out.print("Masukkan ulang tahun baru: ");
                pengurus.setUlangTahun(scanner.nextLine());
                System.out.println("Data pengurus telah diubah.");
            } else {
                System.out.println("Pengurus dengan ID tersebut tidak ditemukan.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
        }
    }

    public void hapusPengurus() {
        System.out.print("Masukkan ID pengurus yang akan dihapus: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Pengurus pengurus = cariPengurus(id);
            if (pengurus != null) {
                penguruses.remove(pengurus);
                System.out.println("Data pengurus telah dihapus.");
            } else {
                System.out.println("Pengurus dengan ID tersebut tidak ditemukan.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
        }
    }

    public Pengurus cariPengurus(int id) {
        for (Pengurus pengurus : penguruses) {
            if (pengurus.getId() == id) {
                return pengurus;
            }
        }
        return null;
    }

    public void tampilkanMenu() {
        int pilihan = 0;
        do {
            System.out.println("===== Manajemen Data Ulang Tahun Pengurus =====");
            System.out.println("1. Tambah Pengurus");
            System.out.println("2. Edit Pengurus");
            System.out.println("3. Hapus Pengurus");
            System.out.println("4. Tampilkan Data Pengurus");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            try {
                pilihan = Integer.parseInt(scanner.nextLine());

                switch (pilihan) {
                    case 1:
                        tambahPengurus();
                        break;
                    case 2:
                        editPengurus();
                        break;
                    case 3:
                        hapusPengurus();
                        break;
                    case 4:
                       List<Pengurus> daftarPengurus = getDaftarPengurus();
                        if (daftarPengurus.isEmpty()) {
                            System.out.println("Tidak ada data pengurus.");
                        } else {
                            System.out.println("===== Data Pengurus =====");
                            for (Pengurus pengurus : daftarPengurus) {
                                System.out.println("ID: " + pengurus.getId());
                                System.out.println("Nama: " + pengurus.getNama());
                                System.out.println("Ulang Tahun: " + pengurus.getUlangTahun());
                                System.out.println("---------------------------");
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Terima kasih!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
            }
        } while (pilihan != 5);
    }

    public static void main(String[] args) {
        PengurusCRUD crud = new PengurusCRUD();
        crud.tampilkanMenu();
        crud.scanner.close();
    }
}
