package algorithms.bfs;

import org.junit.jupiter.api.Test;

public class BfsTests {

    @Test
    void mustExecuteBfs() {
        Bfs.execute(createTree());
    }

    private static Node createTree() {
        final var root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(12);

        root.right = new Node(10);
        root.right.left = new Node(7);
        root.right.right = new Node(15);
        root.right.right.right = new Node(17);
        return root;
    }
}
