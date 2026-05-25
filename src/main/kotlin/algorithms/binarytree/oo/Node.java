package algorithms.binarytree.oo;

import java.util.concurrent.atomic.AtomicInteger;

public class Node {

    public int value;
    public Node left;
    public Node right;

    void insertValue(int value) {
        if (value >= this.value) {
            if (right != null)
                right.insertValue(value);
            else {
                this.right = new Node();
                this.right.value = value;
            }
        } else {
            if (left != null)
                left.insertValue(value);
            else {
                this.left = new Node();
                this.left.value = value;
            }
        }
    }

    int[] inOrderTraversal(final int[] array) {
        this.inOrderTraversal(array, new AtomicInteger(0));
        return array;
    }

    void inOrderTraversal(final int[] array, final AtomicInteger index) {
        if (this.left != null)
            this.left.inOrderTraversal(array, index);
        array[index.get()] = this.value;
        index.incrementAndGet();
        if (this.right != null)
            this.right.inOrderTraversal(array, index);
    }

    int[] preOrderTraversal(final int[] array) {
        this.preOrderTraversal(array, new AtomicInteger(0));
        return array;
    }

    void preOrderTraversal(final int[] array, final AtomicInteger index) {
        array[index.get()] = this.value;
        index.incrementAndGet();
        if (this.left != null)
            this.left.preOrderTraversal(array, index);
        if (this.right != null)
            this.right.preOrderTraversal(array, index);
    }

    int[] postOrderTraversal(final int[] array) {
        this.postOrderTraversal(array, new AtomicInteger(0));
        return array;
    }

    void postOrderTraversal(final int[] array, final AtomicInteger index) {
        if (this.left != null)
            this.left.postOrderTraversal(array, index);
        if (this.right != null)
            this.right.postOrderTraversal(array, index);
        array[index.get()] = this.value;
        index.incrementAndGet();
    }
}
