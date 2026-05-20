package algorithms.divideandconquer.exponentialsearch;

import algorithms.divideandconquer.binarysearch.BinarySearchWithTwoPoints;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExponentialSearchTest {

    @Test
    void mustFind7TermInArrayWith10Size() {
        final var arrayToSearch = createArray(10);
        final var exponentialSearch = new ExponentialSearch(arrayToSearch);

        assertThat(exponentialSearch.search(7)).isEqualTo(7);
    }

    @Test
    void mustFind8TermInArrayWith10Size() {
        final var arrayToSearch = createArray(10);
        final var exponentialSearch = new ExponentialSearch(arrayToSearch);

        assertThat(exponentialSearch.search(8)).isEqualTo(8);
    }

    @Test
    void mustFind1TermInArrayWith10Size() {
        final var arrayToSearch = createArray(10);
        final var exponentialSearch = new ExponentialSearch(arrayToSearch);

        assertThat(exponentialSearch.search(1)).isEqualTo(1);
    }

    @Test
    void mustFind10TermInArrayWith10Size() {
        final var arrayToSearch = createArray(10);
        final var exponentialSearch = new ExponentialSearch(arrayToSearch);

        assertThat(exponentialSearch.search(1)).isEqualTo(1);
    }

    @Test
    void mustFind7TermInArrayWith15Size() {
        final var arrayToSearch = createArray(15);
        final var exponentialSearch = new ExponentialSearch(arrayToSearch);

        assertThat(exponentialSearch.search(7)).isEqualTo(7);
    }

    @Test
    void mustFind7TermInArrayWith13Size() {
        final var arrayToSearch = createArray(13);
        final var exponentialSearch = new ExponentialSearch(arrayToSearch);

        assertThat(exponentialSearch.search(7)).isEqualTo(7);
    }

    @Test
    void mustFind7TermInArrayWith14Size() {
        final var arrayToSearch = createArray(14);
        final var exponentialSearch = new ExponentialSearch(arrayToSearch);

        assertThat(exponentialSearch.search(7)).isEqualTo(7);
    }

    @Test
    void cantFindTermGreaterThanArray() {
        final var arrayToSearch = createArray(14);
        final var exponentialSearch = new ExponentialSearch(arrayToSearch);

        assertThat(exponentialSearch.search(90)).isEqualTo(-1);
    }

    @Test
    void cantFindTermLessThanArray() {
        final var arrayToSearch = createArray(14);
        final var exponentialSearch = new ExponentialSearch(arrayToSearch);

        assertThat(exponentialSearch.search(-5)).isEqualTo(-1);
    }

    @Test
    void compareBinarySearchAndExponentialSearchIsWorseThanBinarySearch() {
        final var arrayToSearch = createArray(1093);
        final var exponentialSearch = new ExponentialSearch(arrayToSearch);
        final var binarySearchWithTwoPoints = new BinarySearchWithTwoPoints(arrayToSearch);

        assertThat(exponentialSearch.search(1025)).isEqualTo(1025);
        System.out.println(exponentialSearch.getSteps());
        assertThat(binarySearchWithTwoPoints.search(1025)).isEqualTo(1025);
        System.out.println(binarySearchWithTwoPoints.getSteps());
    }

    private static int[] createArray(int sizeOfArray) {
        final var array = new int[sizeOfArray];
        for (int i = 1; i <= sizeOfArray - 1; i++) {
            array[i] = i;
        }
        return array;
    }
}
