package algorithms.hourglassessum;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HourGlassesSumTest {

    @Test
    void mustHourGlassesSum() {
        assertThat(HourGlassesSum.hourglassSum(createMatrix())).isEqualTo(-6);
    }

    private static List<List<Integer>> createMatrix() {
        final List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(-1, -1, 0, -9, -2, -2));
        matrix.add(Arrays.asList(-2, -1, -6, -8, -2, -5));
        matrix.add(Arrays.asList(-1, -1, -1, -2, -3, -4));
        matrix.add(Arrays.asList(-1, -9, -2, -4, -4, -5));
        matrix.add(Arrays.asList(-7, -3, -3, -2, -9, -9));
        matrix.add(Arrays.asList(-1, -3, -1, -2, -4, -5));
        return matrix;
    }

}