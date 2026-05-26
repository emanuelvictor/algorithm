package algorithms.bubblesort;

/**
 * Pega o maior elemento e coloca no final da lista
 * Complexidade espacial O(1)
 * Complexidade temporal O(n^2)
 * Complexidade temporal no melhor dos casos O(n)
 */
public class BubbleSort {

    public static int[] execute(final int[] shuffledArray) {
        boolean switched = true;
        int pass = 0;
        while (switched) {
            boolean innerSwitched = false;
            for (int i = 0; i < shuffledArray.length - 1 - pass; i++) {
                if (shuffledArray[i] > shuffledArray[i + 1]) {
                    int aux = shuffledArray[i];
                    shuffledArray[i] = shuffledArray[i + 1];
                    shuffledArray[i + 1] = aux;
                    innerSwitched = true;
                }
            }
            if (!innerSwitched)
                switched = false;
            else pass++;
        }
        return shuffledArray;
    }
}
