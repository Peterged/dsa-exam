package main.two;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList<Integer> link = new SingleLinkedList<>();

        // a. Menambahkan deret angka
        int[] numbers = new int[]{43, 5, 9, 42, 6, 11, 41, 7, 13, 100, 12, 70, 24, 40, 36, 16, 35, 14, 30, 25};
        for (int i = 0; i < numbers.length; i++) {
            link.addLast(numbers[i]); // Menambahkan ke node terakhir pada linked list
        }

        // b. Insert angka 15 setelah angka 12
        link.addAfter(15, value -> value == 12);

        // c. delete angka 24
        link.removeByValue(24);

        // Output link
        System.out.println(link);
    }
}
