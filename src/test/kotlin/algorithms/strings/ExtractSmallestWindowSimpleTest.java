package algorithms.strings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExtractSmallestWindowSimpleTest {

    @Test
    void extractSmallestWindowSimple() {
        final var extractSmallestWindowSimple = new ExtractSmallestWindowSimple();

        // Must return the size of string bcba
        assertThat(extractSmallestWindowSimple.execute("bcbbbcba")).isEqualTo(4);
    }
}
