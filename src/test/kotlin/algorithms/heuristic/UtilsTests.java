package algorithms.heuristic;

import algorithms.heuristic.matrix.MatricesGeneratorV2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilsTests {

    @Test
    void mustCalculateFitnessFromChromosome(){
        int[][] matrix = MatricesGeneratorV2.generateSupervisedMatrixMatrix(10);
        int[] bestIndividual = new int[]{0, 1,2,3,4,5,6,7,8,9};
        int fitness = Utils.calculateFitness(bestIndividual, matrix);

        Assertions.assertThat(fitness).isEqualTo(55);
    }
}
