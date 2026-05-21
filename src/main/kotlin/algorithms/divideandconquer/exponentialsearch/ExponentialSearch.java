package algorithms.divideandconquer.exponentialsearch;

public class ExponentialSearch {

    private int steps;
    private final int[] array;

    ExponentialSearch(int[] array) {
        this.array = array;
    }

    int getSteps() {
        return steps;
    }

    int search(int termToSearch) {
        return search(termToSearch, array);
    }

    private int search(int value, final int[] array) {
        if (array[0] == value) return 0;
        int right = 1;
        while (right < array.length && array[right] < value) {
            // Avança o right
            right = right * 2;
        }

        // O menor valor entre o tamanho do array e o right. Pois pode ser que o right tenha passado do tamanho do array
        var min = Math.min(right, array.length - 1);

        // Realiza a busca binária no array restante.
        return binarySearch(value, array, right/2, array.length);
    }

    private int binarySearch(int value, final int[] array, int lo, int hi) {

        while (lo < hi) {
            var mid = (lo + hi) / 2;
            steps = steps + 1;
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return -1;
    }

}
