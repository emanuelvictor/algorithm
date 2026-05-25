package algorithms.heuristic.matrix;

import algorithms.heuristic.aid.matrix.MatrixGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MatricesGeneratorV2Tests {

    @Test
    public void mustGenerateRandomMatrix() {
        MatrixGenerator.getInstance().generateMatrix(100, true);
    }

    @Test
    public void mustGenerateRandomRoute() {
        final int[] array = MatrixGenerator.getInstance().generateRandomRoute(100);
        assertThat(isOrdering(array)).isFalse();
        assertThat(isRandom(array)).isTrue();
    }

    @Test
    public void mustGenerateOrderingRoute() {
        final int[] array = MatrixGenerator.getInstance().generateOrderingRoute(100);
        assertThat(isOrdering(array)).isTrue();
        assertThat(isRandom(array)).isFalse();
    }

    private boolean isRandom(final int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if ((array[i] + 1) != array[i + 1])
                return true;
        }
        return false;
    }

    private boolean isOrdering(final int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if ((array[i] + 1) != array[i + 1])
                return false;
        }
        return true;
    }
}
