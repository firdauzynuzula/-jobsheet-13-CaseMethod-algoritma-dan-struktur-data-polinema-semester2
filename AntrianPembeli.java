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

    int tambahAntrian(String namaPembeli, String noHp) {
        nomorUrut++;
        Pembeli baru = new Pembeli(nomorUrut, namaPembeli, noHp);
        if (isEmpty()) {
            head = baru;
            tail = baru;
        } else {
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
        System.out.printf("%-12s%-16s%s%n", "No Antrian", "Nama", "No HP");
        Pembeli bantu = head;
        while (bantu != null) {
            System.out.printf("%-12d%-16s%s%n", bantu.noAntrian, bantu.namaPembeli, bantu.noHp);
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
