package main.three;

import java.util.Queue;
import java.util.LinkedList;

public class Main {
    private static final int[] numbers = new int[]{43, 5, 9, 42, 6, 11, 41, 7, 13, 100, 12, 70, 24, 40, 36, 16, 35, 14, 30, 25};

    public static void main(String[] args) {

        CircularQueue<Integer> arrQueue = new ArrayQueue<>();
        CircularQueue<Integer> qlink = new CircularLinkedList<>();
        CircularLinkedList<Integer> clink = new CircularLinkedList<>();

        Queue<String> q = new LinkedList<>();

        for (int val : numbers) {
            arrQueue.enqueue(val);
        }

        System.out.println(arrQueue);
    }
}
