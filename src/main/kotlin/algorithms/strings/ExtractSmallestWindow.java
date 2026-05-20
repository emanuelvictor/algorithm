package algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class ExtractSmallestWindow {

    public String execute(String string, int maxRepeatedValuesPermitted) {
        var maxRepeatedValues = -1;
        var window = "";
        final Map<String, Integer> windowSizes = new HashMap<>();

        var left = 0;
        var right = 1;
        while (left < string.length()) {

            while (left <= right) {
                window = string.substring(left, right);
                final var repeatedChars = countRepeatedChars(window);
                if (maxRepeatedValues < repeatedChars) {
                    maxRepeatedValues = repeatedChars;
                }
                if (!window.isEmpty())
                    windowSizes.put(window, repeatedChars);
                if (right < string.length()) {
                    right++;
                } else {
                    left++;
                }
            }
        }
        return getMaxWindowWithMinRepeatedValues(windowSizes, maxRepeatedValuesPermitted);
    }

    static String getMaxWindowWithMinRepeatedValues(Map<String, Integer> windowSizes, int maxRepeatedValuesPermitted) {
        String greatWindow = null;
        Integer maxSizeOfRepeatedValues = getOneKeyWithMinValue(windowSizes, maxRepeatedValuesPermitted);
        for (final var window : windowSizes.entrySet()) {
            if (window.getValue().equals(maxSizeOfRepeatedValues)) {
                if (greatWindow == null || greatWindow.length() < window.getKey().length()) {
                    greatWindow = window.getKey();
                }
            }
        }

        return greatWindow;
    }

    static int getOneKeyWithMinValue(Map<String, Integer> filtered, int maxRepeatedValuesPermitted) {
        Integer possibleMin = Integer.MAX_VALUE;
        for (final var innerEntry : filtered.entrySet()) {
            if (innerEntry.getValue() < possibleMin && innerEntry.getValue() == maxRepeatedValuesPermitted) {
                possibleMin = innerEntry.getValue();
            }
        }
        return possibleMin;
    }

    static int countRepeatedChars(final String window) {
        final Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < window.length(); i++) {
            var count = 0;
            for (int j = 0; j < window.length(); j++) {
                if (window.charAt(i) == window.charAt(j)) {
                    count = count + 1;
                }
            }
            map.put(window.charAt(i), count);
        }
        var max = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (max < entry.getValue())
                max = entry.getValue();
        }
        return max;
    }
}
