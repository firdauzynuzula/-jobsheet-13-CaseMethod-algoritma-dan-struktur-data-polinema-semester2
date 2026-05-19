class Pembeli {
    int noAntrian;
    String namaPembeli;
    String noHp;
    boolean isPrioritas;
    Pembeli prev;
    Pembeli next;

    Pembeli(int noAntrian, String namaPembeli, String noHp) {
        this(noAntrian, namaPembeli, noHp, false);
    }

    Pembeli(int noAntrian, String namaPembeli, String noHp, boolean isPrioritas) {
        this.noAntrian = noAntrian;
        this.namaPembeli = namaPembeli;
        this.noHp = noHp;
        this.isPrioritas = isPrioritas;
        this.prev = null;
        this.next = null;
    }
}
