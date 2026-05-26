package algorithms.rebuildbinarytreefrominordertraversalandpostordertraversal;

import java.util.List;

public class RebuildBinaryTreeFromInOrderTraversalAndPostOrderTraversal {

    public static Node execute(final List<Integer> inOrderTraversal, final List<Integer> postOrderTraversal) {
        if (postOrderTraversal.isEmpty() || inOrderTraversal.isEmpty()) {
            return null;
        }
        final var root = new Node(postOrderTraversal.getLast()); // O último é o root no postOrderTraversal
        postOrderTraversal.removeLast();
        final var inOrderIndex = inOrderTraversal.indexOf(root.value); // É necessário armazenar o index do root no inOrderTraversal

        if (inOrderIndex != -1) {
            root.right = execute(inOrderTraversal.subList(inOrderIndex + 1, inOrderTraversal.size()), postOrderTraversal); // Reconstrói recursivamente tudo o que está à direita do root. O que é maior que o root.
            // É como se quebrasse a lista em duas partes, e fosse reconstruíndo a árvore recursivamente.
            root.left = execute(inOrderTraversal.subList(0, inOrderIndex), postOrderTraversal); // Reconstrói recursivamente  tudo o que está à esquerda do root. O que é menor que o root.
        }
        return root;
    }

}
