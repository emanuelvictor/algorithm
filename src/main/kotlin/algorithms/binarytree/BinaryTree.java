package algorithms.binarytree;

import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTree {

    public static int[] executeAndReturnInOrderTraversal(final int[] array) {
        final var root = new Node();
        root.value = array[0];
        for (int i = 1; i < array.length; i++) {
            insertValue(root, array[i]);
        }
        final int[] sortedArray = new int[array.length];
        inOrderTraversal(root, sortedArray, new AtomicInteger(0));
        return sortedArray;
    }

    public static int[] executeAndReturnPreOrderTraversal(final int[] array) {
        final var root = new Node();
        root.value = array[0];
        for (int i = 1; i < array.length; i++) {
            insertValue(root, array[i]);
        }
        final int[] sortedArray = new int[array.length];
        preOrderTraversal(root, sortedArray, new AtomicInteger(0));
        return sortedArray;
    }

    public static int[] executeAndReturnPostOrderTraversal(final int[] array) {
        final var root = new Node();
        root.value = array[0];
        for (int i = 1; i < array.length; i++) {
            insertValue(root, array[i]);
        }
        final int[] sortedArray = new int[array.length];
        postOrderTraversal(root, sortedArray, new AtomicInteger(0));
        return sortedArray;
    }

    static void insertValue(Node node, int value) {
        if (value >= node.value) {
            if (node.right != null)
                insertValue(node.right, value);
            else {
                node.right = new Node();
                node.right.value = value;
            }
        } else {
            if (node.left != null)
                insertValue(node.left, value);
            else {
                node.left = new Node();
                node.left.value = value;
            }
        }
    }

    static void preOrderTraversal(Node node, final int[] array, final AtomicInteger index) {
        array[index.get()] = node.value;
        index.incrementAndGet();
        if (node.left != null) {
            preOrderTraversal(node.left, array, index);
        }
        if (node.right != null) {
            preOrderTraversal(node.right, array, index);
        }
    }

    static void inOrderTraversal(Node node, final int[] array, final AtomicInteger index) {
        if (node.left != null)
            inOrderTraversal(node.left, array, index);
        array[index.get()] = node.value;
        index.incrementAndGet();
        if (node.right != null) {
            inOrderTraversal(node.right, array, index);
        }
    }

    static void postOrderTraversal(Node node, final int[] array, final AtomicInteger index) {
        if (node.left != null) {
            postOrderTraversal(node.left, array, index);
        }
        if (node.right != null) {
            postOrderTraversal(node.right, array, index);
        }
        array[index.get()] = node.value;
        index.incrementAndGet();
    }
}
