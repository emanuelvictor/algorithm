package algorithms.heuristic.memetic.oo.models;

import algorithms.heuristic.matrix.StaticMatricesInputs;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GenerationTests {

    private static final int[][] MATRIX = StaticMatricesInputs.THIRTY_POINTS_MATRIX;
    private static final int[][] INDIVIDUALS = StaticMatricesInputs.THIRTY_POINTS_MATRIX_FIRST_GENERATION_WITH_EIGHT_INDIVIDUALS;
    private static final int[] BEST_INDIVIDUAL = StaticMatricesInputs.THIRTY_POINTS_MATRIX_BEST_INDIVIDUAL;

    private static final int FITNESS_FROM_BEST_INDIVIDUAL = StaticMatricesInputs.THIRTY_POINTS_MATRIX_FITNESS_FROM_BEST_INDIVIDUAL;
    private static final int[] NEW_BEST_INDIVIDUAL = new int[]
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29};
    private static final int FITNESS_FROM_NEW_BEST_INDIVIDUAL = 465;

    @Test
    public void mustCreateGenerationInstance() {
        final Individual[] individuals = createIndividualsToGeneration();

        final Generation generation = new Generation(individuals);

        assertThat(generation.getIndividuals()).isEqualTo(individuals);
        assertThat(generation.getBestIndividual().getChromosomes()).isEqualTo(BEST_INDIVIDUAL);
        assertThat(generation.getChromosomesFromBestIndividual()).isEqualTo(BEST_INDIVIDUAL);
        assertThat(generation.getBestFitness()).isEqualTo(FITNESS_FROM_BEST_INDIVIDUAL);
    }

    @Test
    public void mustSetTheNewBestIndividual() {
        final Individual[] individuals = createIndividualsToGeneration();
        final Generation generation = new Generation(individuals);
        final Individual newBestIndividual = new Individual(NEW_BEST_INDIVIDUAL, MATRIX);

        generation.setBestIndividual(newBestIndividual);

        assertThat(generation.getIndividuals()).isNotEqualTo(individuals);
        assertThat(generation.getBestIndividual().getChromosomes()).isEqualTo(NEW_BEST_INDIVIDUAL);
        assertThat(generation.getChromosomesFromBestIndividual()).isEqualTo(NEW_BEST_INDIVIDUAL);
        assertThat(generation.getBestFitness()).isEqualTo(FITNESS_FROM_NEW_BEST_INDIVIDUAL);
    }

    private static Individual[] createIndividualsToGeneration() {
        final Individual[] individualsToGeneration = new Individual[GenerationTests.INDIVIDUALS.length];
        for (int i = 0; i < GenerationTests.INDIVIDUALS.length; i++) {
            individualsToGeneration[i] = new Individual(GenerationTests.INDIVIDUALS[i], MATRIX);
        }
        return individualsToGeneration;
    }
}
