class Pembeli {
    int noAntrian;
    String namaPembeli;
    String noHp;
    Pembeli prev;
    Pembeli next;

    Pembeli(int noAntrian, String namaPembeli, String noHp) {
        this.noAntrian = noAntrian;
        this.namaPembeli = namaPembeli;
        this.noHp = noHp;
        this.prev = null;
        this.next = null;
    }
}
