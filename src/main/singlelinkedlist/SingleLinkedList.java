package main.singlelinkedlist;

import java.util.function.Predicate;

// IMPLEMENTASI SINGKAT - Single Linked List
public class SingleLinkedList<T> {
    private Node<T> head, tail;
    private int size = 0;

    public SingleLinkedList() {}

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * @return
     */
    public boolean add(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head = newNode;
        }

        size++;
        return true;
    }

    public boolean addFirst(T data) {
        add(data);
        return true;
    }

    public boolean addLast(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }

        size++;
        return true;
    }

    public boolean addAfter(T data, Predicate<T> condition) {
        Node<T> newNode = new Node<>(data);

        for (Node<T> x = head; x != null; x = x.next) {
            if (condition.test(x.data)) {
                if (x.next == null) {
                    x.next = newNode;
                } else {
                    newNode.next = x.next;
                    x.next = newNode;
                }

                return true;
            }
        }

        return false;
    }

    public boolean removeByValue(T data) {
        for (Node<T> x = head; x.next != null; x = x.next) {
            if (x.next.data != data) continue;

            if (x.next.next == null) {
                x.next = null;
            } else {
                x.next = x.next.next;
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Node<T> x = head; x != null; x = x.next) {
            sb.append(x.data);
            if (x.next != null) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }
}
