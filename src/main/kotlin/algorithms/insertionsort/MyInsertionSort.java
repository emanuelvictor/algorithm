package algorithms.insertionsort;

public class MyInsertionSort {

    public static int[] execute(int[] shuffledArray) {

        for (int i = 0; i < shuffledArray.length; i++) {
            for (int j = i + 1; j < shuffledArray.length; j++) {
                if (shuffledArray[j] < shuffledArray[i]) {
                    final var temp = shuffledArray[j];
                    for (int k = j; k > i; k--) {
                        shuffledArray[k] = shuffledArray[k - 1];
                    }
                    shuffledArray[i] = temp;
                }
            }
        }


        return shuffledArray;
    }
}