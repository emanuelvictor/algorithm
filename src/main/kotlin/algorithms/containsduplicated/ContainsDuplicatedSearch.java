package algorithms.containsduplicated;

import java.util.HashSet;

public class ContainsDuplicatedSearch {

    private int steps;
    private final int[] array;

    ContainsDuplicatedSearch(int[] array) {
        this.array = array;
    }

    boolean searchDuplicated() {
        final HashSet<Integer> seen = new HashSet<>();
        for (int i = array.length - 1; i >= 0; i--) {
            steps++;
            if (seen.contains(array[i])) {
                return true;
            } else seen.add(array[i]);
        }
        return false;
    }

    int getSteps() {
        return steps;
    }

}
