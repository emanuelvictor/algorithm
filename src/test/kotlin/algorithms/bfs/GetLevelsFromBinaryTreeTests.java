package algorithms.bfs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GetLevelsFromBinaryTreeTests {

    @ParameterizedTest
    @MethodSource("provideDataToGetLevels")
    void getLevelsFromBinaryTree(HashMap<Integer, List<Integer>> mapExpected, Node root) {
        assertThat(GetLevelsFromBinaryTree.execute(root)).usingRecursiveAssertion().isEqualTo(mapExpected);
    }

    static Stream<Arguments> provideDataToGetLevels() {
        final var root = createTree();
        final var mapExpected = new HashMap<Integer, List<Integer>>();
        mapExpected.put(1, List.of(3));
        mapExpected.put(2, List.of(9, 20));
        mapExpected.put(3, List.of(15, 7));
        final var treeWithOneLevel = new Node(401);
        final var mapExpectedWithOneLevel = new HashMap<Integer, List<Integer>>();
        mapExpectedWithOneLevel.put(1, List.of(treeWithOneLevel.value));
        return Stream.of(
                Arguments.of(mapExpected, root),
                Arguments.of(new HashMap<Integer, List<Integer>>(), null),
                Arguments.of(mapExpectedWithOneLevel, treeWithOneLevel)
        );
    }

    private static Node createTree() {
        final var root = new Node(3);
        root.left = new Node(9);

        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        return root;
    }
}