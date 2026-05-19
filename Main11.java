import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianPembeli antrian = new AntrianPembeli();
        DaftarPesanan daftarPesanan = new DaftarPesanan();

        // Data awal
        antrian.tambahAntrian("Ainra", "08224500000");
        antrian.tambahAntrian("Danra", "08224511111");
        antrian.tambahAntrian("Sanri", "08224522222");
        antrian.tambahAntrian("Rendra", "08224533333");
        antrian.tambahAntrian("Vinka", "08224544444");
        antrian.tambahAntrian("Bayu", "08224555555");

        int pilihan;
        do {
            System.out.println("==============================");
            System.out.println("SISTEM ANTRIAN ROYAL DELISH");
            System.out.println("==============================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian dan Pesan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Nama Pembeli : ");
                    String nama = sc.nextLine();
                    System.out.print("No HP        : ");
                    String hp = sc.nextLine();
                    System.out.print("Prioritas (y/t) : ");
                    String inputPrioritas = sc.nextLine().trim().toLowerCase();
                    boolean prioritas = inputPrioritas.equals("y") || inputPrioritas.equals("ya");
                    int noAntrian = antrian.tambahAntrian(nama, hp, prioritas);
                    System.out.println("Antrian berhasil ditambahkan dengan nomor: " + noAntrian);
                    break;

                case 2:
                    antrian.cetakAntrian();
                    break;

                case 3:
                    if (antrian.isEmpty()) {
                        System.out.println("Antrian kosong.");
                        break;
                    }
                    System.out.print("Nomor Antrian yang dipanggil : ");
                    int noPanggil = sc.nextInt();
                    sc.nextLine();
                    Pembeli terpanggil = antrian.hapusAntrian(noPanggil);
                    if (terpanggil != null) {
                        System.out.print("Kode Pesanan  : ");
                        int kode = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nama Pesanan  : ");
                        String namaPesanan = sc.nextLine();
                        System.out.print("Harga         : ");
                        int harga = sc.nextInt();
                        sc.nextLine();
                        daftarPesanan.tambahPesanan(kode, namaPesanan, harga, terpanggil.namaPembeli);
                        System.out.println(terpanggil.namaPembeli + " telah memesan " + namaPesanan);
                    }
                    break;

                case 4:
                    daftarPesanan.laporanPesanan();
                    break;

                case 0:
                    System.out.println("Terima kasih telah menggunakan Sistem Antrian Royal Delish.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        sc.close();
    }
}
