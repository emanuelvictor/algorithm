package algorithms.rebuildbinarytreefrominordertraversalandpostordertraversal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RebuildBinaryTreeFromInOrderTraversalAndPostOrderTraversalTest {

    @Test
    void mustRebuildBinaryTreeFromInOrderTraversalAndPostOrderTraversal() {
        final var inOrderTraversal = new ArrayList<>(Arrays.asList(9, 3, 15, 20, 7));
        final var postOrderTraversal = new ArrayList<>(Arrays.asList(9, 15, 7, 20, 3));

        final var node = RebuildBinaryTreeFromInOrderTraversalAndPostOrderTraversal.execute(inOrderTraversal, postOrderTraversal);

        assertThat(node).usingRecursiveComparison().isEqualTo(expectedTree());
    }

    private static Node expectedTree() {
        final var root = new Node(3);
        root.left = new Node(9); // Esse nove está aqui propositadamente para mostrar que o algoritmo é apenas para navegação de uma árvore qualquer, e não ordenação.
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        return root;
    }
}
