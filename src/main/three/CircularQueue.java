package main.edson.three;

import java.util.Arrays;
import java.util.Collection;

public interface CircularQueue<E> {
    boolean enqueue(E data);
    E dequeue();
    E peek();
}
