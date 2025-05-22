package main.five;

public class Main {
    public static void main(String[] args) {
        HashTable<String> table = new HashTable<>();

        String[] arr = {"Anting", "Baju", "Celana", "Gelas", "Gunting", "Handphone", "Buku", "Garpu"};

        for (String str : arr) {
            table.put(str);
        }

        System.out.println(table);
    }
}
