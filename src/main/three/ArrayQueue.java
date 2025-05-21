package main.three;

public class ArrayQueue<E> implements CircularQueue<E> {
    protected final E[] array;
    protected final int capacity;
    protected int size = 0;
    protected int top = 0;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        this.capacity = 10;
        this.array = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
    }

    public boolean isFull() {
        return size >= capacity;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] arr = (E[]) new Object[size];

        for (int i = 0; i < size; i++) {
            arr[i] = array[(top + i) % capacity];
        }

        return arr;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[(top + i) % capacity]);

            if (i + 1 < size) {
                sb.append(", ");
            }
        }

        return sb.append("]").toString();
    }



    /* Circular Queue Implementation */

    @Override
    public boolean enqueue(E data) {
        if (isFull()) {
            return false;
        }

        array[(top + size++) % capacity] = data;

        return true;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            return null;
        }

        E data = array[top % capacity];
        array[top++ % capacity] = null;
        top %= capacity;
        size = size > 0 ? size - 1 : 0;

        return data;
    }

    @Override
    public E peek() {
        if (isEmpty()) return null;
        return array[top % capacity]; // top element
    }

    @Override
    public E[] getElements() {
        return array;
    }
}
