class Pesanan {
    int kodePesanan;
    String namaPesanan;
    int harga;
    String namaPembeli;
    Pesanan prev;
    Pesanan next;

    Pesanan(int kodePesanan, String namaPesanan, int harga, String namaPembeli) {
        this.kodePesanan = kodePesanan;
        this.namaPesanan = namaPesanan;
        this.harga = harga;
        this.namaPembeli = namaPembeli;
        this.prev = null;
        this.next = null;
    }
}
