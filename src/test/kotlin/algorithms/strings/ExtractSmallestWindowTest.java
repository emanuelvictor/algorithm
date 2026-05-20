package algorithms.strings;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExtractSmallestWindowTest {

    @Test
    void mustCountRepeatedCharsToStringBabbAndReturn3() {
        assertThat(ExtractSmallestWindow.countRepeatedChars("babb")).isEqualTo(3);
    }

    @Test
    void mustCountRepeatedCharsToStringBbabAndReturn3() {
        assertThat(ExtractSmallestWindow.countRepeatedChars("bbab")).isEqualTo(3);
    }

    @Test
    void mustCountRepeatedCharsToStringBAndReturn1() {
        assertThat(ExtractSmallestWindow.countRepeatedChars("b")).isEqualTo(1);
    }

    @Test
    void mustCountRepeatedCharsToStringAbcAndReturn1() {
        assertThat(ExtractSmallestWindow.countRepeatedChars("abc")).isEqualTo(1);
    }

    @Test
    void mustReturnTheGreatestWindowWithMinorRepeatedValues() {
        final Map<String, Integer> windowsWithRepeatedValues = new HashMap<>();
        windowsWithRepeatedValues.put("a", 1);
        windowsWithRepeatedValues.put("ab", 1);
        windowsWithRepeatedValues.put("abb", 2);
        windowsWithRepeatedValues.put("abc", 1);
        windowsWithRepeatedValues.put("abcd", 1);
        windowsWithRepeatedValues.put("bbb", 3);
        windowsWithRepeatedValues.put("bbba", 3);
        windowsWithRepeatedValues.put("bbbaac", 3);
        windowsWithRepeatedValues.put("adcc", 2);
        windowsWithRepeatedValues.put("aaaa", 4);

        assertThat(ExtractSmallestWindow.getMaxWindowWithMinRepeatedValues(windowsWithRepeatedValues, 1)).isEqualTo("abcd");
    }

    @Test
    void mustReturnTheSmallestWindowWhenWeCanRepeatOneCharacterTwoTime() {
        final var extractSmallestWindow = new ExtractSmallestWindow();

        final String greatestWindowWithoutRepeatedValues = extractSmallestWindow.execute("bcbbbcba", 2);

        assertThat(greatestWindowWithoutRepeatedValues).isEqualTo("bcba");
    }

    @Test
    void mustReturnTheSmallestWindowWhenWeCanRepeatOneCharacterThreeTimes() {
        final var extractSmallestWindow = new ExtractSmallestWindow();

        final String greatestWindowWithoutRepeatedValues = extractSmallestWindow.execute("bcbbbcba", 3);

        assertThat(greatestWindowWithoutRepeatedValues).isEqualTo("bbcba");
    }

    @Test
    void mustReturnTheSmallestWindowWhenWeCanRepeatOneCharacterFourTimes() {
        final var extractSmallestWindow = new ExtractSmallestWindow();

        final String greatestWindowWithoutRepeatedValues = extractSmallestWindow.execute("bcbbbcba", 4);

        assertThat(greatestWindowWithoutRepeatedValues).isEqualTo("cbbbcba");
    }

    @Test
    void mustReturnTheSmallestWindowWhenWeCanRepeatOneCharacterEightTimes() {
        final var extractSmallestWindow = new ExtractSmallestWindow();

        final String greatestWindowWithoutRepeatedValues = extractSmallestWindow.execute("bcbbbbcbbbcba", 8);

        assertThat(greatestWindowWithoutRepeatedValues).isEqualTo("cbbbbcbbbcba");
    }

    @Test
    void mustReturnTheSmallestWindowWhenWeCantRepeatAnyCharacter() {
        final var extractSmallestWindow = new ExtractSmallestWindow();

        final String greatestWindowWithoutRepeatedValues = extractSmallestWindow.execute("bcbbbcba", 1);

        assertThat(greatestWindowWithoutRepeatedValues).isEqualTo("cba");
    }

}
