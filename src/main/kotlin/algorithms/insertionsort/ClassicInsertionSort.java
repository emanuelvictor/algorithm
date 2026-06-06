package algorithms.insertionsort;

public class ClassicInsertionSort {

    public static int[] execute(int[] array) {

        for (int i = 1; i < array.length; i++) {

            for (int j = i; j > 0; j--) {

                if (array[j] < array[j - 1]) {

                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;

                } else {
                    break;
                }
            }
        }

        return array;
    }
}