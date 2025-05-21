package main.three;

public class Main {
    private static final int[] numbers = new int[]{43, 5, 9, 42, 6, 11, 41, 7, 13, 100, 12, 70, 24, 40, 36, 16, 35, 14, 30, 25};

    public static void main(String[] args) {

        CircularQueue<Integer> arrQueue = new ArrayQueue<>(numbers.length);
        CircularQueue<Integer> queueCircularLink = new CircularLinkedList<>();

        for (int val : numbers) {
            arrQueue.enqueue(val);
            queueCircularLink.enqueue(val);
        }

        System.out.printf("Array Circular Queue: \n\t%s\n\n", arrQueue);
        System.out.printf("Circular Linked List Queue: \n\t%s\n", queueCircularLink);
    }
}
