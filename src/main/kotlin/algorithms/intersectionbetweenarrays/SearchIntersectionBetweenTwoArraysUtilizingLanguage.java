package algorithms.intersectionbetweenarrays;

import java.util.HashSet;

public class SearchIntersectionBetweenTwoArraysUtilizingLanguage {

    private int steps;
    private final int[] firstArray;
    private final int[] secondArray;

    SearchIntersectionBetweenTwoArraysUtilizingLanguage(int[] firstArray, int[] secondArray) {
        this.firstArray = firstArray;
        this.secondArray = secondArray;
    }

    Integer[] search() {
        final var firstSet = new HashSet<Integer>();
        for (int j : firstArray) {
            steps++;
            firstSet.add(j);
        }

        final var secondSet = new HashSet<Integer>();
        for (int j : secondArray) {
            steps++;
            secondSet.add(j);
        }

        firstSet.retainAll(secondSet);

        return firstSet.toArray(Integer[]::new);
    }

    int getSteps() {
        return steps;
    }

}
