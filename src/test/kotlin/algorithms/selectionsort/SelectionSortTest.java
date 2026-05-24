package algorithms.selectionsort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectionSortTest {

    @ParameterizedTest
    @MethodSource("provideShuffleAndSortedArray")
    public void mustSortArray(final int[] arrayToSort, final int[] expectedSortedArray) {

        final var selectionSorted = SelectionSort.execute(arrayToSort);

        assertArrayEquals(expectedSortedArray, selectionSorted);
    }

    static Stream<Arguments> provideShuffleAndSortedArray() {
        final var sortedBigArray = createBigArray();
        final var shuffledBigArray = shuffleArray(sortedBigArray);
        return Stream.of(
                Arguments.of(new int[]{64, 25, 12, 22, 11}, new int[]{11, 12, 22, 25, 64}),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(new int[]{64, 25, 0, 22, 11}, new int[]{0, 11, 22, 25, 64}),
                Arguments.of(new int[]{64, 25, 0, -222, 11}, new int[]{-222, 0, 11, 25, 64}),
                Arguments.of(new int[]{-64, -25, 0, -222, -11}, new int[]{-222, -64, -25, -11, 0}),
                Arguments.of(new int[]{-64, -25, -222, -11}, new int[]{-222, -64, -25, -11}),
                Arguments.of(new int[]{-64, -25, -222, -11, 118}, new int[]{-222, -64, -25, -11, 118}),
                Arguments.of(shuffledBigArray, sortedBigArray)
        );
    }

    public static int[] createBigArray() {
        final var bigArray = new int[100000];
        for (int i = 0; i < 100000; i++) {
            bigArray[i] = 100000 - i;
        }
        return bigArray;
    }

    public static int[] shuffleArray(final int[] array) {
        for (int i = 0; i < array.length; i++) {
            int random = new Random().nextInt(i, array.length);

            int aux = array[i];
            array[i] = array[random];
            array[random] = aux;
        }
        return array;
    }
}
