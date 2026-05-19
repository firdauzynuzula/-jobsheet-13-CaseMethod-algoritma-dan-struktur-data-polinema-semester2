class AntrianPembeli {
    Pembeli head;
    Pembeli tail;
    int nomorUrut;

    AntrianPembeli() {
        head = null;
        tail = null;
        nomorUrut = 0;
    }

    boolean isEmpty() {
        return head == null;
    }

    // Overload: tambahAntrian tanpa parameter prioritas (default non-prioritas)
    int tambahAntrian(String namaPembeli, String noHp) {
        return tambahAntrian(namaPembeli, noHp, false);
    }

    // Menambahkan pembeli baru ke antrian; jika isPrioritas = true,
    // node disisipkan tepat setelah head (bukan di tail)
    int tambahAntrian(String namaPembeli, String noHp, boolean isPrioritas) {
        nomorUrut++;
        Pembeli baru = new Pembeli(nomorUrut, namaPembeli, noHp, isPrioritas);
        if (isEmpty()) {
            // Kasus 1: antrian masih kosong → node baru jadi head sekaligus tail
            head = baru;
            tail = baru;
        } else if (isPrioritas) {
            // Kasus 2: pembeli prioritas → sisipkan setelah head
            baru.prev = head;            // prev node baru menunjuk ke head
            baru.next = head.next;       // next node baru menunjuk ke node tetangga head
            if (head.next != null) {
                // Update prev pada node tetangga agar menunjuk ke node baru
                head.next.prev = baru;
            } else {
                // Jika sebelumnya hanya ada head, node baru menjadi tail
                tail = baru;
            }
            head.next = baru;            // next head sekarang menunjuk ke node baru
        } else {
            // Kasus 3: pembeli biasa → masuk di belakang (tail)
            baru.prev = tail;
            tail.next = baru;
            tail = baru;
        }
        return nomorUrut;
    }

    void cetakAntrian() {
        System.out.println("==============================");
        System.out.println("Daftar Antrian Pembeli");
        System.out.println("==============================");
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        // Header tabel termasuk kolom Prioritas
        System.out.printf("%-12s%-16s%-15s%s%n", "No Antrian", "Nama", "No HP", "Prioritas");
        Pembeli bantu = head;
        while (bantu != null) {
            // Cetak setiap pembeli; status prioritas ditampilkan sebagai "Ya" atau "Tidak"
            System.out.printf("%-12d%-16s%-15s%s%n", bantu.noAntrian, bantu.namaPembeli, bantu.noHp,
                    bantu.isPrioritas ? "Ya" : "Tidak");
            bantu = bantu.next;
        }
    }

    Pembeli hapusAntrian(int noAntrian) {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return null;
        }
        Pembeli bantu = head;
        while (bantu != null && bantu.noAntrian != noAntrian) {
            bantu = bantu.next;
        }
        if (bantu == null) {
            System.out.println("Nomor antrian " + noAntrian + " tidak ditemukan.");
            return null;
        }
        if (bantu.prev != null) {
            bantu.prev.next = bantu.next;
        } else {
            head = bantu.next;
        }
        if (bantu.next != null) {
            bantu.next.prev = bantu.prev;
        } else {
            tail = bantu.prev;
        }
        bantu.prev = null;
        bantu.next = null;
        return bantu;
    }
}
