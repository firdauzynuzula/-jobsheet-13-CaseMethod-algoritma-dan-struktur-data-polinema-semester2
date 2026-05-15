/*
 * Case Method 11 - Linked List
 * Nama   : Firdauzy
 * No Absen : 11
 * NIM (digit terakhir) : 2
 *
 * Implementasi Single Linked List tanpa Java Collections Framework.
 */

class Node {
    int data;
    Node pointer;

    Node(int data) {
        this.data = data;
        this.pointer = null;
    }
}

class SingleLinkedList {
    Node head;
    Node tail;

    SingleLinkedList() {
        head = null;
        tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void addFirst(int data) {
        Node baru = new Node(data);
        if (isEmpty()) {
            head = baru;
            tail = baru;
        } else {
            baru.pointer = head;
            head = baru;
        }
    }

    void addLast(int data) {
        Node baru = new Node(data);
        if (isEmpty()) {
            head = baru;
            tail = baru;
        } else {
            tail.pointer = baru;
            tail = baru;
        }
    }

    void insertAfter(int key, int data) {
        if (isEmpty()) {
            System.out.println("Linked list kosong, tidak dapat menyisipkan setelah " + key);
            return;
        }
        Node bantu = head;
        while (bantu != null && bantu.data != key) {
            bantu = bantu.pointer;
        }
        if (bantu == null) {
            System.out.println("Node dengan data " + key + " tidak ditemukan");
            return;
        }
        Node baru = new Node(data);
        baru.pointer = bantu.pointer;
        bantu.pointer = baru;
        if (bantu == tail) {
            tail = baru;
        }
    }

    void insertAt(int index, int data) {
        if (index < 0) {
            System.out.println("Index tidak valid: " + index);
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node bantu = head;
        int i = 0;
        while (bantu != null && i < index - 1) {
            bantu = bantu.pointer;
            i++;
        }
        if (bantu == null) {
            System.out.println("Index " + index + " di luar jangkauan");
            return;
        }
        Node baru = new Node(data);
        baru.pointer = bantu.pointer;
        bantu.pointer = baru;
        if (bantu == tail) {
            tail = baru;
        }
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked list kosong, tidak dapat menghapus");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.pointer;
        }
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked list kosong, tidak dapat menghapus");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        Node bantu = head;
        while (bantu.pointer != tail) {
            bantu = bantu.pointer;
        }
        bantu.pointer = null;
        tail = bantu;
    }

    void remove(int key) {
        if (isEmpty()) {
            System.out.println("Linked list kosong, tidak dapat menghapus");
            return;
        }
        if (head.data == key) {
            removeFirst();
            return;
        }
        Node prev = head;
        Node cur = head.pointer;
        while (cur != null && cur.data != key) {
            prev = cur;
            cur = cur.pointer;
        }
        if (cur == null) {
            System.out.println("Node dengan data " + key + " tidak ditemukan");
            return;
        }
        prev.pointer = cur.pointer;
        if (cur == tail) {
            tail = prev;
        }
    }

    void removeAt(int index) {
        if (isEmpty()) {
            System.out.println("Linked list kosong, tidak dapat menghapus");
            return;
        }
        if (index < 0) {
            System.out.println("Index tidak valid: " + index);
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        Node prev = head;
        int i = 0;
        while (prev.pointer != null && i < index - 1) {
            prev = prev.pointer;
            i++;
        }
        if (prev.pointer == null) {
            System.out.println("Index " + index + " di luar jangkauan");
            return;
        }
        Node cur = prev.pointer;
        prev.pointer = cur.pointer;
        if (cur == tail) {
            tail = prev;
        }
    }

    void print() {
        if (isEmpty()) {
            System.out.println("[Linked List kosong]");
            return;
        }
        Node bantu = head;
        StringBuilder sb = new StringBuilder("head -> ");
        while (bantu != null) {
            sb.append(bantu.data);
            if (bantu.pointer != null) {
                sb.append(" -> ");
            }
            bantu = bantu.pointer;
        }
        sb.append(" -> null");
        System.out.println(sb.toString());
    }
}

public class CaseMethodFirdauzy11 {
    public static void main(String[] args) {
        final int NO_ABSEN = 11;
        final int NIM_DIGIT = 2;

        SingleLinkedList list = new SingleLinkedList();

        System.out.println("=== Kondisi Awal: Linked List dengan 4 Node ===");
        list.addLast(100);
        list.addLast(200);
        list.addLast(300);
        list.addLast(400);
        list.print();

        System.out.println("\n1. addLast(" + NO_ABSEN + ") -> tambah No Absen di belakang");
        list.addLast(NO_ABSEN);
        list.print();

        System.out.println("\n2. addFirst(" + NIM_DIGIT + ") -> tambah 1 digit terakhir NIM di depan");
        list.addFirst(NIM_DIGIT);
        list.print();

        int dataInsertAfter = NO_ABSEN + 5;
        System.out.println("\n3. insertAfter(200, " + dataInsertAfter + ") -> tambah No Absen+5 setelah node 200");
        list.insertAfter(200, dataInsertAfter);
        list.print();

        int dataInsertAt = NIM_DIGIT + 5;
        System.out.println("\n4. insertAt(1, " + dataInsertAt + ") -> tambah 1 digit terakhir NIM+5 pada indeks ke-1");
        list.insertAt(1, dataInsertAt);
        list.print();

        System.out.println("\n5. removeFirst() -> hapus node depan");
        list.removeFirst();
        list.print();

        System.out.println("\n6. removeLast() -> hapus node belakang");
        list.removeLast();
        list.print();

        System.out.println("\n7. remove(300) -> hapus node dengan data 300");
        list.remove(300);
        list.print();

        System.out.println("\n8. removeAt(3) -> hapus node pada indeks ke-3");
        list.removeAt(3);
        list.print();
    }
}
