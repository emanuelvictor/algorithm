package algorithms.sortbenchmark;

import java.util.Random;

public class Stub {

    public static int[] createBigArray() {
        return createArrayFromSize(100000);
    }

    public static int[] createArrayFromSize(int sizeOfArray) {
        final var bigArray = new int[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            bigArray[i] = i;
        }
        return bigArray;
    }

    public static int[] shuffleArray(int[] array) {
        final int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        for (int i = 1; i < copy.length; i++) {

            int random = new Random().nextInt(0, i);
            int aux = copy[random];
            copy[random] = copy[i];
            copy[i] = aux;
        }
        return copy;
    }
}
