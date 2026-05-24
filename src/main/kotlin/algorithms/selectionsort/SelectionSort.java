package algorithms.selectionsort;

/**
 * O(n^2) time complexity
 * O(1) space complexity
 */
public class SelectionSort {

    public static int[] execute(int[] shuffledArray) {

        for (int i = 0; i < shuffledArray.length; i++) {
            int minorIndex = i;
            for (int j = i + 1; j < shuffledArray.length; j++) {
                if (shuffledArray[j] < shuffledArray[minorIndex]) {
                    minorIndex = j;
                }
            }
            int aux = shuffledArray[i];
            shuffledArray[i] = shuffledArray[minorIndex];
            shuffledArray[minorIndex] = aux;
        }
        return shuffledArray;
    }


}
