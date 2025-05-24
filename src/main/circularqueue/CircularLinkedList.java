package main.circularqueue;

// IMPLEMENTASI SINGKAT - Circular Linked list untuk Circular Queue
public class CircularLinkedList<E> implements CircularQueue<E> {
    private Node<E> head, tail;
    private int size = 0;

    public CircularLinkedList() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E data) {
        enqueue(data);
    }

    public boolean addLast(E data) {
        Node<E> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
            tail = head;
            tail.next = head;
        } else {
            newNode.next = head;
            tail.next = newNode;
            tail = tail.next;
        }

        size++;

        return true;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E data = head.data;
        head = head.next;
        tail.next = head;

        size--;

        return data;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        Node<E> first = head;
        StringBuilder sb = new StringBuilder("[");

        while (true) {
            sb.append(first.data);

            if (first.next != head) {
                sb.append(", ");
            } else {
                break;
            }

            first = first.next;
        }

        return sb.append("]").toString();
    }

    // Queue Operations
    @Override
    public E peek() {
        Node<E> first = head;
        return (first == null) ? null : first.data;
    }

    @Override
    public boolean enqueue(E data) {
        return addLast(data);
    }

    @Override
    public E dequeue() {
        return removeFirst();
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] getElements() {
        E[] array = (E[]) new Object[size];

        Node<E> f = head;
        int i = 0;

        while (i == 0 || f != head) {
            array[i++] = f.data;
            f = f.next;
        }

        return array;
    }
}
