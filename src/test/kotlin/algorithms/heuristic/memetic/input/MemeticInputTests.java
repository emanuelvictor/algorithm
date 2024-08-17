package algorithms.heuristic.memetic.input;

import algorithms.heuristic.aid.Input;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemeticInputTests {

    @Test
    public void mustCreateInputWithDefaultValues() {
        final Input input = MemeticInput.builder().build();

        assertThat(input.getFitnessToFind()).isNotNull();
        assertThat(input.getFirstGeneration()).isNotNull();
        assertThat(input.getMatrix()).isNotNull();
    }

    @Test
    public void mustCreateInputWithCustomMatrixAndWithoutFitnessToFind() {
        final int[][] matrix = new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};

        final Input input = MemeticInput.builder().matrix(matrix).build();

        assertThat(input.getFitnessToFind()).isNull();
        assertThat(input.getFirstGeneration()).isNotNull();
        assertThat(input.getMatrix()).isEqualTo(matrix);
    }

    @Test
    public void mustCreateInputWithAllValues() {
        final int[][] matrix = new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        final int fitnessToFind = 3;
        final int sizeOfFirstPopulation = 3;
        final int[][] firstPopulation = new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};

        final Input input = MemeticInput.builder()
                .matrix(matrix)
                .fitnessToFind(fitnessToFind)
                .sizeOfFirstGeneration(sizeOfFirstPopulation)
                .firstGeneration(firstPopulation)
                .build();

        assertThat(input.getFitnessToFind()).isEqualTo(fitnessToFind);
        assertThat(input.getFirstGeneration()).isEqualTo(firstPopulation);
        assertThat(input.getSizeOfFirstGeneration()).isEqualTo(sizeOfFirstPopulation);
        assertThat(input.getMatrix()).isEqualTo(matrix);
    }

    @Test
    public void inputCannotBeCreatedWithIndividualsSizesFromFirstPopulationGreaterThanMatrix() {
        final int[][] matrix = new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        final int fitnessToFind = 3;
        final int[][] firstPopulation = new int[][]{{1, 2, 3}, {1, 2, 3, 4}, {1, 2, 3}};

        final Throwable throwable = Assertions.catchThrowable(() -> MemeticInput.builder()
                .matrix(matrix).fitnessToFind(fitnessToFind).firstGeneration(firstPopulation)
                .build());

        assertThat(throwable.getMessage()).isEqualTo("The size of individuals from population must be equal to size of matrix");
    }

    // TODO parametrized tests
    @Test
    public void inputCannotBeCreatedWithFitnessToFindEqualsToZero() {
        final int[][] matrix = new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};

        final Throwable throwable = Assertions.catchThrowable(() -> MemeticInput.builder().matrix(matrix).fitnessToFind(0).build());

        assertThat(throwable.getMessage()).isEqualTo("fitnessToFind cannot be less than 0");
    }

    // TODO parametrized tests
    @Test
    public void inputCannotBeCreatedWithFitnessToFindLessThanZero() {
        final int[][] matrix = new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};

        final Throwable throwable = Assertions.catchThrowable(() -> MemeticInput.builder().matrix(matrix).fitnessToFind(-1).build());

        assertThat(throwable.getMessage()).isEqualTo("fitnessToFind cannot be less than 0");
    }

    @Test
    public void mustShowTheMatrix(){
        MemeticInput.builder().build().showMatrix();
    }
}
