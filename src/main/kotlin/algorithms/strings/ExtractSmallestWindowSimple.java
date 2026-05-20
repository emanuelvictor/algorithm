package algorithms.strings;

import java.util.HashMap;

public class ExtractSmallestWindowSimple {

    public int execute(String string) {
        int left = 0, right = 0;
        var max = 1;
        final var counter = createCounter(string);

        while (right < string.length() - 1) {
            right++;
            if (counter.get(string.charAt(right)) != null) {
                counter.put(string.charAt(right), counter.get(string.charAt(right)) + 1);
            } else  {
                counter.put(string.charAt(right), 1);
            }

            while (counter.get(string.charAt(right)) == 3) {
                counter.put(string.charAt(left), counter.get(string.charAt(left)) - 1);
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    private static HashMap<Character, Integer> createCounter(String string) {
        final var counter = new HashMap<Character, Integer>();
        counter.put(string.charAt(0), 1);
        return counter;
    }

}
