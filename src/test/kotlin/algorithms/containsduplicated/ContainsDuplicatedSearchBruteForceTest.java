package algorithms.containsduplicated;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ContainsDuplicatedSearchBruteForceTest {


    @Test
    public void mustSearchDuplicatedAndReturnFalse() {
        final var arrayToFindDuplicated = new int[]{1, 2, 3, 4, 5};
        final var containsDuplicatedSearchBruteForce = new ContainsDuplicatedSearchBruteForce(arrayToFindDuplicated);

        assertThat(containsDuplicatedSearchBruteForce.searchDuplicated()).isEqualTo(false);
        assertThat(containsDuplicatedSearchBruteForce.getSteps())
                .isEqualTo(arrayToFindDuplicated.length * arrayToFindDuplicated.length);
    }

    @Test
    public void mustSearchDuplicatedAndReturnTrue() {
        final var arrayToFindDuplicated = new int[]{1, 2, 2, 4, 5};
        final var containsDuplicatedSearchBruteForce = new ContainsDuplicatedSearchBruteForce(arrayToFindDuplicated);

        assertThat(containsDuplicatedSearchBruteForce.searchDuplicated()).isEqualTo(true);
    }
}
