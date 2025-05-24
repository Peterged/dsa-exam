package main.binarysearchtree;

public class BinarySearchTree<E extends Comparable<? super E>> {
    private Node<E> root;

    public BinarySearchTree() {
    }

    /**
     * Mengembalikan tinggi binary search tree
     * 
     * @return tinggi binary search tree
     * 
     * @see {@link #insert}
     * @see {@link #search}
     */
    public int height() {
        return heightHelper(root);
    }

    /**
     * Menelusuri binary search tree sesuai perbandingan nilai Comparable kemudian
     * memasukkan node baru
     * 
     * @param data data yang dimasukkan ke node baru
     * @return E data di node
     * 
     * @see {@link #search}
     * @see {@link #height}
     */
    public E insert(final E data) {
        if (root == null) {
            root = new Node<>(data);
            return root.data;
        }

        Node<E> current = root;
        Node<E> parent = current;

        while (current != null) {
            parent = current;
            if (data.compareTo(current.data) < 0) {
                current = current.left;
            } else if (data.compareTo(current.data) > 0) {
                current = current.right;
            } else {
                return current.data; // Data sudah ada
            }
        }

        Node<E> newNode = new Node<>(data);
        if (data.compareTo(parent.data) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        return newNode.data;
    }

    /**
     * Menelusuri dan mencari nilai target pada binary search tree kemudian
     * mengembalikan true jika ditemukan dan false jika tidak.
     * 
     * @param target nilai yang dicari
     * @return boolean jika nilai ada atau tidak
     * 
     * @see {@link #insert}
     * @see {@link #height}
     */
    public boolean search(final E target) {
        if (root == null) {
            return false;
        }

        Node<E> node = root;

        while (node != null) {
            if (target.compareTo(node.left.data) > 0) {
                node = node.left;
            } else if (target.compareTo(node.right.data) < 0) {
                node = node.right;
            } else {
                return true; // Data ditemukan
            }
        }

        return false; // Data tidak ditemukan
    }

    /**
     * Mengembalikan binary search tree secara inorder dalam format string
     * 
     * @return string [...]
     * 
     * @see {@link #toStringFormatted}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> node = root;
        toStringHelper(sb, node);

        // menghapus string ", " di akhir
        sb = sb.replace(sb.length() - 2, sb.length(), "");

        return sb.append("]").toString();
    }

    /**
     * Menelusuri binary search tree secara inorder kemudian memasukkan nilai node
     * masing-masing ke dalam StringBuilder
     * 
     * @param sb   StringBuilder
     * @param node
     * 
     * @see {@link #toStringFormattedHelper}
     */
    private void toStringHelper(StringBuilder sb, Node<E> node) {
        if (node != null) {
            toStringHelper(sb, node.left);
            sb.append(node.data).append(", ");
            toStringHelper(sb, node.right);
        }
    }

    /**
     * Mengembalikan binary search tree dalam format string yang bisa dibaca.
     * 
     * @return string visualisasi binary search tree
     * 
     * @see {@link #toString}
     */
    public String toStringFormatted() {
        final StringBuilder sb = new StringBuilder();
        toStringFormattedHelper(sb, "", "", root);
        return sb.toString();
    }

    /**
     * Menelusuri binary search tree dan menambahkan string ascii tertentu pada
     * StringBuilder.
     * 
     * @param sb      StringBuilder
     * @param padding ascii jarak (padding)
     * @param pointer ascii penunjuk
     * @param node
     * 
     * @see {@link #toStringHelper}
     */
    private void toStringFormattedHelper(StringBuilder sb, String padding, String pointer, Node<E> node) {
        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.data);
            sb.append("\n");

            String paddingAll = new StringBuilder(padding)
                    .append("| ")
                    .toString();

            String paddingLeft = "└──";
            String paddingRight = node.right != null ? "├──" : "└──";

            toStringFormattedHelper(sb, paddingAll, paddingLeft, node.left);
            toStringFormattedHelper(sb, paddingAll, paddingRight, node.right);
        }
    }

    /**
     * Menelusuri binary search tree dan
     * 
     * @param node
     * @return variable dengan angka terbesar (tertinggi)
     */
    private int heightHelper(final Node<E> node) {
        if (node == null) {
            return 0;
        }

        final int leftHeight = heightHelper(node.left);
        final int rightHeight = heightHelper(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
