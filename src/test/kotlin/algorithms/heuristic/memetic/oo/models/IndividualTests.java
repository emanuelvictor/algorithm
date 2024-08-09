package algorithms.heuristic.memetic.oo.models;

import algorithms.heuristic.matrix.StaticMatricesInputs;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IndividualTests {

    private final int[][] MATRIX = StaticMatricesInputs.THIRTY_POINTS_MATRIX;
    private final int[] CHROMOSOMES_FROM_BEST_INDIVIDUAL = StaticMatricesInputs.THIRTY_POINTS_MATRIX_BEST_INDIVIDUAL;
    private final int FITNESS = StaticMatricesInputs.THIRTY_POINTS_MATRIX_FITNESS_FROM_BEST_INDIVIDUAL;

    @Test
    void mustCreateAInstanceOfIndividual() {
        final Individual individual = new Individual(CHROMOSOMES_FROM_BEST_INDIVIDUAL, MATRIX);

        assertThat(individual.getChromosomes()).isEqualTo(CHROMOSOMES_FROM_BEST_INDIVIDUAL);
        assertThat(individual.getFitness()).isEqualTo(FITNESS);
    }
}
