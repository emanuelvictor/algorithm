package algorithms.divideandconquer.binarysearch;

public class BinarySearchWithTwoPoints {

    private int steps;
    private final int[] array;

    public BinarySearchWithTwoPoints(int[] array) {
        steps = 0;
        this.array = array;
    }

    public int search(int termToSearch) {
        return search(termToSearch, array);
    }

    public int getSteps() {
        return steps;
    }

    private int search(int term, final int[] array) {
        var lo = 0;
        var hi = array.length;

        while (lo < hi) {
            steps = steps + 1;
            var mid = (lo + hi) / 2;

            if (array[mid] == term) {
                return mid;
            } else if (array[mid] < term) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return -1;
    }
}
