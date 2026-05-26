package algorithms.bfs;

public class Bfs {

    static void execute(Node root) {
        if (root == null) return;
        System.out.println(root.value);
        execute(root.left, root.right);
    }

    static void execute(Node left, Node right) {
        if (left != null)
            System.out.println(left.value);
        if (right != null)
            System.out.println(right.value);
        if (left != null)
            execute(left.left, left.right);
        if (right != null)
            execute(right.left, right.right);
    }

}

