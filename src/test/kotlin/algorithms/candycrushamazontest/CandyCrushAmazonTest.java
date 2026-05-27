package algorithms.candycrushamazontest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CandyCrushAmazonTest {

    @ParameterizedTest
    @MethodSource("provideDataToPlayGame")
    public void playCandyGame(List<Integer> listOfCandy, List<Integer> expectedExplodedCandies, int minToRemove) {
        final var candyCrushAmazon = new CandyCrushAmazon();

        final var explodedCandies = candyCrushAmazon.execute(listOfCandy, minToRemove);

        assertThat(explodedCandies).usingRecursiveAssertion().isEqualTo(expectedExplodedCandies);
    }

    static Stream<Arguments> provideDataToPlayGame() {
        return Stream.of(
                Arguments.of(new ArrayList<>(List.of(2, 1, 1, 4, 5, 1, 2, 2)), new ArrayList<>(List.of(2, 1, 1, 4, 5, 1, 2, 2)), 3),
                Arguments.of(new ArrayList<>(List.of(2, 1, 1, 4, 5, 1, 2, 2)), new ArrayList<>(List.of(2, 4, 5, 1)), 2),
                Arguments.of(new ArrayList<>(List.of(2, 1, 1, 4, 5, 1, 2, 2, 2, 1)), new ArrayList<>(List.of(2, 4, 5)), 2)
        );
    }
}
