package algorithms.selectionsort;

public class MinMaxSelectionSort {

    public static int[] execute(int[] array) {
        for (int k = 0; k < array.length; k++) {
            int positionOfMin = k;
            int positionOfMax = array.length - 1 - k;
            if (positionOfMax == positionOfMin)
                break;
            for (int i = k; i < array.length - k; i++) {
                if (array[i] > array[positionOfMax])
                    positionOfMax = i;
                if (array[i] < array[positionOfMin]) {
                    positionOfMin = i;
                }
            }

            int aux = array[k];
            array[k] = array[positionOfMin];
            array[positionOfMin] = aux;
            if (positionOfMax == k) {
                positionOfMax = positionOfMin;
            }

            aux = array[array.length - 1 - k];
            array[array.length - 1 - k] = array[positionOfMax];
            array[positionOfMax] = aux;

        }
        return array;
    }
}
