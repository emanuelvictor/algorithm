package algorithms.containsduplicated;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ContainsDuplicatedSearchTest {


    @Test
    public void mustSearchDuplicatedAndReturnFalse() {
        final var arrayToFindDuplicated = new int[]{1, 2, 3, 4, 5};
        final var containsDuplicatedSearch = new ContainsDuplicatedSearch(arrayToFindDuplicated);

        assertThat(containsDuplicatedSearch.searchDuplicated()).isEqualTo(false);
        assertThat(containsDuplicatedSearch.getSteps()).isEqualTo(arrayToFindDuplicated.length);
    }

    @Test
    public void mustSearchDuplicatedAndReturnTrue() {
        final var arrayToFindDuplicated = new int[]{1, 2, 2, 4, 5};
        final var containsDuplicatedSearch = new ContainsDuplicatedSearch(arrayToFindDuplicated);

        assertThat(containsDuplicatedSearch.searchDuplicated()).isEqualTo(true);
        assertThat(containsDuplicatedSearch.getSteps() < arrayToFindDuplicated.length).isTrue();
    }
}
