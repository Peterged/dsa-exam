package main.four;



public class BST<E extends Comparable<? super E>> {
    Node<E> root;
    int height = 0;

    public BST() {

    }

    public E insert(E data) {
        root = insertHelper(root, data);
        return data;
    }

    private Node<E> insertHelper(Node<E> node, E data) {
        if (root == null) {
            root = new Node<>(data);
            return root;
        }

        if (data.compareTo(node.data) > 0) {
            node.left = insertHelper(node.left, data);
        } else if (data.compareTo(node.data) < 0) {
            node.right = insertHelper(node.right, data);
        }

        return node;
    }

}
