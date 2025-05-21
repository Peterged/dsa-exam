package main.three;

public interface CircularQueue<E> {
    boolean enqueue(E data);
    E dequeue();
    E peek();
    E[] getElements();
}
