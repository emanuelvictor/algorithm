package algorithms.containsduplicated;

public class ContainsDuplicatedSearchBruteForce {

    private int steps;
    private final int[] array;

    ContainsDuplicatedSearchBruteForce(int[] array) {
        this.array = array;
    }

    boolean searchDuplicated() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                steps++;
                if (j != i) {
                    if (array[i] == array[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    int getSteps() {
        return steps;
    }

}
