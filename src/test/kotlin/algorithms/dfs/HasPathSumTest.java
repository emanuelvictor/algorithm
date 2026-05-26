package algorithms.dfs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HasPathSumTest {

    @ParameterizedTest
    @MethodSource("providePathSumsDoSearch")
    void mustReturnTrueWhenThereIsA22PathSum(final int pathSum, final boolean exists, final Node root) {
      assertThat(HasPathSum.execute(pathSum, root)).isEqualTo(exists);
    }

    static Stream<Arguments> providePathSumsDoSearch() {
        final var root = createTree();
        return Stream.of(
                Arguments.of(22, true, root),
                Arguments.of(27, true, root),
                Arguments.of(52, false, root),
                Arguments.of(1, false, root),
                Arguments.of(-1, false, root),
                Arguments.of(22, false, null)
        );
    }

    private static Node createTree(){
        final var root = new Node(5);
        root.left = new Node(4);
        root.left.left = new Node(11);
        root.left.left.right = new Node(2);
        root.left.left.left = new Node(7);

        root.right = new Node(8);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.right = new Node(1);
        return root;
    }
}
