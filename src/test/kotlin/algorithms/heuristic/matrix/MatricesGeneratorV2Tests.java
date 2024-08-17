package algorithms.heuristic.matrix;

import algorithms.heuristic.aid.matrix.MatrixGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class MatricesGeneratorV2Tests {

    @Test
    public void mustGenerateRandomMatrix() {
        MatrixGenerator.getInstance().generateMatrix(100, true);
    }

    @Test
    public void mustGenerateRandomRoute() {
        final int[] array = MatrixGenerator.getInstance().generateRandomRoute(100);
        Assert.isTrue(!isOrdering(array), "Is not random");
        Assert.isTrue(isRandom(array), "Is not random");
    }

    @Test
    public void mustGenerateOrderingRoute() {
        final int[] array = MatrixGenerator.getInstance().generateOrderingRoute(100);
        Assert.isTrue(isOrdering(array), "Is random");
        Assert.isTrue(!isRandom(array), "Is random");
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
