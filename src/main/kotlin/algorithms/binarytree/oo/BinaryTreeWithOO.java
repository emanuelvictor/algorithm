package algorithms.binarytree.oo;

public class BinaryTreeWithOO {

    public static int[] executeAndReturnInOrderTraversal(final int[] array) {
        final var root = new Node();
        root.value = array[0];
        for (int i = 1; i < array.length; i++) {
            root.insertValue(array[i]);
        }
        return root.inOrderTraversal(new int[array.length]);
    }

    public static int[] executeAndReturnPreOrderTraversal(final int[] array) {
        final var root = new Node();
        root.value = array[0];
        for (int i = 1; i < array.length; i++) {
            root.insertValue(array[i]);
        }
        return root.preOrderTraversal(new int[array.length]);
    }

    public static int[] executeAndReturnPostOrderTraversal(final int[] array) {
        final var root = new Node();
        root.value = array[0];
        for (int i = 1; i < array.length; i++) {
            root.insertValue(array[i]);
        }
        return root.postOrderTraversal(new int[array.length]);
    }

}
