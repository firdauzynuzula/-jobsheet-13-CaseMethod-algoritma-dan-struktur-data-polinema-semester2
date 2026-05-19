// Class Pembeli merepresentasikan node pada Double Linked List antrian pembeli
class Pembeli {
    int noAntrian;          // Nomor urut antrian pembeli
    String namaPembeli;     // Nama pembeli
    String noHp;            // Nomor HP pembeli
    boolean isPrioritas;    // Status apakah pembeli termasuk antrian prioritas
    Pembeli prev;           // Pointer ke node sebelumnya
    Pembeli next;           // Pointer ke node setelahnya

    // Konstruktor default: pembeli non-prioritas
    Pembeli(int noAntrian, String namaPembeli, String noHp) {
        this(noAntrian, namaPembeli, noHp, false);
    }

    // Konstruktor lengkap dengan parameter status prioritas
    Pembeli(int noAntrian, String namaPembeli, String noHp, boolean isPrioritas) {
        this.noAntrian = noAntrian;
        this.namaPembeli = namaPembeli;
        this.noHp = noHp;
        this.isPrioritas = isPrioritas;
        this.prev = null;
        this.next = null;
    }
}
