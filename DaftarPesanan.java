class DaftarPesanan {
    Pesanan head;
    Pesanan tail;

    DaftarPesanan() {
        head = null;
        tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void tambahPesanan(int kodePesanan, String namaPesanan, int harga, String namaPembeli) {
        Pesanan baru = new Pesanan(kodePesanan, namaPesanan, harga, namaPembeli);
        if (isEmpty()) {
            head = baru;
            tail = baru;
        } else {
            baru.prev = tail;
            tail.next = baru;
            tail = baru;
        }
    }

    void sortByNamaPesanan() {
        if (isEmpty() || head == tail) return;

        boolean swapped;
        do {
            swapped = false;
            Pesanan bantu = head;
            while (bantu.next != null) {
                if (bantu.namaPesanan.compareToIgnoreCase(bantu.next.namaPesanan) > 0) {
                    int tempKode = bantu.kodePesanan;
                    String tempNama = bantu.namaPesanan;
                    int tempHarga = bantu.harga;
                    String tempNamaPembeli = bantu.namaPembeli;

                    bantu.kodePesanan = bantu.next.kodePesanan;
                    bantu.namaPesanan = bantu.next.namaPesanan;
                    bantu.harga = bantu.next.harga;
                    bantu.namaPembeli = bantu.next.namaPembeli;

                    bantu.next.kodePesanan = tempKode;
                    bantu.next.namaPesanan = tempNama;
                    bantu.next.harga = tempHarga;
                    bantu.next.namaPembeli = tempNamaPembeli;

                    swapped = true;
                }
                bantu = bantu.next;
            }
        } while (swapped);
    }

    void laporanPesanan() {
        System.out.println("======================================");
        System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println("======================================");
        if (isEmpty()) {
            System.out.println("Belum ada pesanan.");
            return;
        }
        sortByNamaPesanan();
        System.out.printf("%-14s%-20s%s%n", "Kode Pesanan", "Nama Pesanan", "Harga");
        Pesanan bantu = head;
        long total = 0;
        while (bantu != null) {
            System.out.printf("%-14d%-20s%d%n", bantu.kodePesanan, bantu.namaPesanan, bantu.harga);
            total += bantu.harga;
            bantu = bantu.next;
        }
        System.out.println("--------------------------------------");
        System.out.printf("%-34s%d%n", "Total Pendapatan:", total);
    }
}
