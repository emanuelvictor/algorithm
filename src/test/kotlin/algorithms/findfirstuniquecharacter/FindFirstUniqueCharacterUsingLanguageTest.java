package algorithms.findfirstuniquecharacter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FindFirstUniqueCharacterUsingLanguageTest {

    @Test
    void findFirstUniqueCharacterForLeetcodeAndReturn0() {
        final String stringToSearchTheFirstUniqueChar = "leetcode";
        final var findFirstUniqueCharacter = new FindFirstUniqueCharacterUsingLanguage(stringToSearchTheFirstUniqueChar);

        assertThat(findFirstUniqueCharacter.searchFirstUniqueCharacter()).isEqualTo(0);
        assertThat(findFirstUniqueCharacter.getSteps()).isEqualTo(stringToSearchTheFirstUniqueChar.length());
    }

    @Test
    void findFirstUniqueCharacterForLoveLeetcodeAndReturn2() {
        final String stringToSearchTheFirstUniqueChar = "loveleetcode";
        final var findFirstUniqueCharacter = new FindFirstUniqueCharacterUsingLanguage(stringToSearchTheFirstUniqueChar);

        assertThat(findFirstUniqueCharacter.searchFirstUniqueCharacter()).isEqualTo(2);
        assertThat(findFirstUniqueCharacter.getSteps()).isEqualTo(stringToSearchTheFirstUniqueChar.length());
    }

    @Test
    void findFirstUniqueCharacterForAabbAndNotFoundIndex() {
        final String stringToSearchTheFirstUniqueChar = "aabb";
        final var findFirstUniqueCharacter = new FindFirstUniqueCharacterUsingLanguage(stringToSearchTheFirstUniqueChar);

        assertThat(findFirstUniqueCharacter.searchFirstUniqueCharacter()).isEqualTo(-1);
        assertThat(findFirstUniqueCharacter.getSteps()).isEqualTo(stringToSearchTheFirstUniqueChar.length());
    }

    @Test
    void findFirstUniqueCharacterForAAndAndReturn0() {
        final String stringToSearchTheFirstUniqueChar = "a";
        final var findFirstUniqueCharacter = new FindFirstUniqueCharacterUsingLanguage(stringToSearchTheFirstUniqueChar);

        assertThat(findFirstUniqueCharacter.searchFirstUniqueCharacter()).isEqualTo(0);
        assertThat(findFirstUniqueCharacter.getSteps()).isEqualTo(stringToSearchTheFirstUniqueChar.length());
    }
}
