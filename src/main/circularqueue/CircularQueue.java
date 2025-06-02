package main.circularqueue;

public interface CircularQueue<E> {
    boolean enqueue(E data);
    E dequeue();
    E peek();
    E[] getElements();
}
