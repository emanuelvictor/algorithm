package algorithms.intersectionbetweenarrays;

import java.util.ArrayList;

public class SearchIntersectionBetweenTwoArraysBruteForce {

    private int steps;
    private final int[] firstArray;
    private final int[] secondArray;

    SearchIntersectionBetweenTwoArraysBruteForce(int[] firstArray, int[] secondArray) {
        this.firstArray = firstArray;
        this.secondArray = secondArray;
    }

    Integer[] search() {
        final var intersection = new ArrayList<Integer>();
        for (int k : firstArray) {
            for (int i : secondArray) {
                steps++;
                if (k == i) {
                    intersection.add(k);
                }
            }
        }
        return intersection.toArray(Integer[]::new);
    }

    int getSteps() {
        return steps;
    }

}
