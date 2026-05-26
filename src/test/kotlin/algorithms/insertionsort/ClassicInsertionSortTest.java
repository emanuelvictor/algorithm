package algorithms.insertionsort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static algorithms.sortbenchmark.Stub.createBigArray;
import static algorithms.sortbenchmark.Stub.shuffleArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ClassicInsertionSortTest {

    @ParameterizedTest
    @MethodSource("provideShuffleAndSortedArray")
    public void mustSortArray(final int[] arrayToSort, final int[] expectedSortedArray) {

        final var selectionSorted = ClassicInsertionSort.execute(arrayToSort);

        assertArrayEquals(expectedSortedArray, selectionSorted);
    }

    static Stream<Arguments> provideShuffleAndSortedArray() {
        final var sortedBigArray = createBigArray();
        final var shuffledBigArray = shuffleArray(sortedBigArray);
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1}),
                Arguments.of(new int[]{1, 1, 3, 6,1}, new int[]{1, 1,1, 3, 6}),
                Arguments.of(new int[]{64, 25, 12, 3, 22, 11, 1, 2, 4, 5, 6}, new int[]{1, 2, 3, 4, 5, 6, 11, 12, 22, 25, 64}),
                Arguments.of(new int[]{64, 25, 12, 22, 11}, new int[]{11, 12, 22, 25, 64}),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(new int[]{64, 25, 0, 22, 11}, new int[]{0, 11, 22, 25, 64}),
                Arguments.of(new int[]{64, 25, 0, -222, 11}, new int[]{-222, 0, 11, 25, 64}),
                Arguments.of(new int[]{-64, -25, 0, -222, -11}, new int[]{-222, -64, -25, -11, 0}),
                Arguments.of(new int[]{-64, -25, -222, -11}, new int[]{-222, -64, -25, -11}),
                Arguments.of(new int[]{-64, -25, -222, -11, 118}, new int[]{-222, -64, -25, -11, 118}),
                Arguments.of(sortedBigArray, sortedBigArray),
                Arguments.of(shuffledBigArray, sortedBigArray)
        );
    }

}
