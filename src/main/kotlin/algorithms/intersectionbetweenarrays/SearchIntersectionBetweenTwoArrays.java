package algorithms.intersectionbetweenarrays;

import java.util.HashSet;

public class SearchIntersectionBetweenTwoArrays {

    private int steps;
    private final int[] firstArray;
    private final int[] secondArray;

    SearchIntersectionBetweenTwoArrays(int[] firstArray, int[] secondArray) {
        this.firstArray = firstArray;
        this.secondArray = secondArray;
    }

    Integer[] search() {
        final var intersection = new HashSet<Integer>();
        final var seen = new HashSet<Integer>();
        for (int j : firstArray) {
            steps++;
            seen.add(j);
        }

        for (int j : secondArray) {
            steps++;
            if (seen.contains(j)) {
                intersection.add(j);
            }
        }

        return intersection.toArray(Integer[]::new);
    }

    int getSteps() {
        return steps;
    }

}
