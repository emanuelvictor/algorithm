package algorithms.dfs;

/**
 * Utiliza DFS - Dado uma soma, devo verificar se existe um caminho da raiz até uma folha cuja soma dos valores seja igual a soma dada.
 */
public class HasPathSum {

    public static boolean execute(int sum, Node node) {
        if (node == null)
            return false;

        if (node.left == null && node.right == null){
            sum = sum - node.value;
            return sum == 0;
        }

        sum = sum - node.value;

        final var findInLeft = execute(sum, node.left);
        if(findInLeft)
            return true;
        return execute(sum, node.right);

    }
}
