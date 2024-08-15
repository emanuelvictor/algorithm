package algorithms.heuristic.memetic.structured;

import algorithms.heuristic.Input;
import algorithms.heuristic.matrix.MatricesGeneratorV2;

public class Main {

    public static void main(String[] args) {
        var matrix = MatricesGeneratorV2.generateSupervisedMatrixMatrix(80);
        var firstPopulation = MatricesGeneratorV2.generateRandomPopulation(matrix, 2);
        var fitness = MatricesGeneratorV2.extractTheBestFitnessFromSupervisedMatrix(matrix);

        var input = Input.builder()
                .matrix(matrix)
                .firstGeneration(firstPopulation) //  MENOR O TAMANHO DA POPULAÇÃO MAIS GERAÇÕES, MENOR PROCESSAMENTO ENTRE AS GERAÇÕES, MENOR O TEMPO
                .fitnessToFind(fitness)
                .build();

        var memetic = new StructuredMemetic(input);
        memetic.execute();
    }
}
