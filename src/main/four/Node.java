package main.four;

public class Node<T> {
    Node<T> left;
    Node<T> right;
    T data;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
