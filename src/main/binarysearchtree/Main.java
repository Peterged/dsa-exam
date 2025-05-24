package main.binarysearchtree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Menambahkan deret angka ke bst
        final int[] array = { 20, 17, 12, 14, 27, 9, 23, 20, 21, 27 };
        for (int value : array) {
            bst.insert(value);
        }

        // Menampilkan bst secara inorder
        System.out.println(bst);

        /* 
         * Menampilkan bst dalam format: 
         * root
         * | ├── node1
         * | | ├── node3
         * | | | └── node7
         * | | └── node4
         * | └── node2
         * | | ├── node5
         * | | └── node6
        */
        System.out.printf("\n%s\n\n", bst.toStringFormatted());

        // Menampilkan tinggi binary search tree
        System.out.printf("height: %d\n", bst.height());
    }
}
