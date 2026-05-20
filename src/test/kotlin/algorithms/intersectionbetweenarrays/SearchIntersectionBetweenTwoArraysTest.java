package algorithms.intersectionbetweenarrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchIntersectionBetweenTwoArraysTest {

    @Test
    public void mustExtractTheIntersectionWhenAllElementsAreRepeated() {
        final var firstArray = new int[]{1, 2, 3, 4, 5};
        final var secondArray = new int[]{1, 2, 3, 4, 5};
        final var searchIntersectionBetweenTwoArrays = new SearchIntersectionBetweenTwoArrays(firstArray, secondArray);

        assertThat(searchIntersectionBetweenTwoArrays.search()).usingRecursiveAssertion().isEqualTo(new Integer[]{1, 2, 3, 4, 5});
        assertThat(searchIntersectionBetweenTwoArrays.getSteps()).isEqualTo(firstArray.length + secondArray.length);
    }

    @Test
    public void mustExtractTheIntersection() {
        final var firstArray = new int[]{1, 2, 3, 4, 5};
        final var secondArray = new int[]{-1, 2, 3, 4, 15, 0};
        final var searchIntersectionBetweenTwoArrays = new SearchIntersectionBetweenTwoArrays(firstArray, secondArray);

        assertThat(searchIntersectionBetweenTwoArrays.search()).usingRecursiveAssertion().isEqualTo(new Integer[]{2, 3, 4});
        assertThat(searchIntersectionBetweenTwoArrays.getSteps()).isEqualTo(firstArray.length + secondArray.length);
    }

    @Test
    public void mustExtractTheIntersectionAndReturnAnyoneIntersection() {
        final var firstArray = new int[]{1, 2, 3, 4, 5};
        final var secondArray = new int[]{-1, 15, 0};
        final var searchIntersectionBetweenTwoArrays = new SearchIntersectionBetweenTwoArrays(firstArray, secondArray);

        assertThat(searchIntersectionBetweenTwoArrays.search()).usingRecursiveAssertion().isEqualTo(new Integer[]{});
        assertThat(searchIntersectionBetweenTwoArrays.getSteps()).isEqualTo(firstArray.length + secondArray.length);
    }

}
