package algorithms.findfirstuniquecharacter;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstUniqueCharacterUsingLanguage {

    private int steps;
    private final String string;

    FindFirstUniqueCharacterUsingLanguage(String string) {
        this.string = string;
    }

    int searchFirstUniqueCharacter() {
        final Map<Character, Integer> unique = new LinkedHashMap<>();
        final HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            steps++;
            if (seen.contains(string.charAt(i)))
                unique.remove(string.charAt(i));
            else {
                unique.put(string.charAt(i), i);
                seen.add(string.charAt(i));
            }
        }
        return unique.values().stream().findFirst().orElse(-1);
    }

    int getSteps() {
        return steps;
    }

}
