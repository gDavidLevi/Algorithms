package ru.davidlevi.lesson8.cw;

public class Online {
    public static void main(String[] args) {
        HashTable ht = new HashTable(25);
        for (int i = 0; i < 11; i++) {
            ht.insert(new Item(i * 5));
        }
        System.out.println(ht);
        ht.delete(25);
        System.out.println(ht);
        ht.insert(new Item(75));
        System.out.println(ht);
    }
}
