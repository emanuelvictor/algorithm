package algorithms.tree.binary.search;

public class BinaryTreeRecursiveSearchReturningNegativeNumberIfNotFoundTerm {

    private final int[] array;

    BinaryTreeRecursiveSearchReturningNegativeNumberIfNotFoundTerm(int[] array) {
        this.array = array;
    }

    int search(int termToSearch) {
        return search(termToSearch, array);
    }

    private int search(int term, final int[] array) {
        if (array.length == 1 && term != array[0]) {
            return -1;
        }
        int half = (array.length) / 2;
        if (array[half] == term) return half;
        else if (array[half] < term) {
            int[] subArray = getSubArray(array, half, array.length);
            int found = search(term, subArray);
            if (found < 0) return found;
            return half + found;
        } else {
            int[] subArray = getSubArray(array, 0, half);
            return search(term, subArray);
        }
    }

    private int[] getSubArray(int[] array, int origin, int dest) {
        int[] arrayToReturn = new int[dest - origin];
        int indexOfArrayToReturn = 0;
        for (int i = origin; i < dest; i++) {
            arrayToReturn[indexOfArrayToReturn] = array[i];
            indexOfArrayToReturn++;
        }
        return arrayToReturn;
    }
}
