package algorithms.tree.binary.search;

public class BinaryTreeRecursiveSearch {

    static final String TERM_CANNOT_BE_FOUND_MESSAGE_ERROR = "Term %s cannot be found";

    private final int[] array;

    BinaryTreeRecursiveSearch(int[] array) {
        this.array = array;
    }

    int search(int termToSearch) {
        return search(termToSearch, array);
    }

    private int search(int value, final int[] array) {
        if (array.length == 1 && value != array[0]) {
            throw new TermCannotBeFound(String.format(TERM_CANNOT_BE_FOUND_MESSAGE_ERROR, value));
        }
        int half = (array.length) / 2;
        if (array[half] == value) return half;
        else if (array[half] < value) {
            int[] subArray = getSubArray(array, half, array.length);
            int found = search(value, subArray);
            return half + found;
        } else {
            int[] subArray = getSubArray(array, 0, half);
            return search(value, subArray);
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

    final class TermCannotBeFound extends RuntimeException {

        public TermCannotBeFound(String message) {
            super(message);
        }
    }

}
