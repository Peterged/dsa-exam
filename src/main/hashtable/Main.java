package main.hashtable;

public class Main {
    public static void main(String[] args) {
        HashTable<String> table = new HashTable<>(8);

        String[] arr = { "Anting", "Baju", "Celana", "Gelas", "Gunting", "Handphone", "Buku", "Garpu" };

        for (String str : arr) {
            table.put(str);
        }

        System.out.println(table);
    }
}
