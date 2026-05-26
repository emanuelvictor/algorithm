package algorithms.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GetLevelsFromBinaryTree {

    static HashMap<Integer, List<Integer>> execute(Node root) {
        final HashMap<Integer, List<Integer>> map = new HashMap<>();
        final AtomicInteger level = new AtomicInteger();
        execute(level, map, root);
        return map;
    }

    static void execute(final AtomicInteger level, final HashMap<Integer, List<Integer>> map, final Node node) {
        if (node == null) return;
        level.incrementAndGet();

        final var nodesInThisLevel = map.getOrDefault(level.intValue(), new ArrayList<>());
        nodesInThisLevel.add(node.value);
        map.put(level.intValue(), nodesInThisLevel);

        execute(level, map, node.left);
        execute(level, map, node.right);
        level.decrementAndGet();
    }
}
