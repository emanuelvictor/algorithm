package algorithms.heuristic.memetic;

import algorithms.heuristic.Input;
import algorithms.heuristic.matrix.MatricesGeneratorV2;
import algorithms.heuristic.memetic.oo.OOMemetic;
import algorithms.heuristic.memetic.structural.StructuralMemetic;

import java.util.concurrent.*;


/**
 * Dedicated to compare OO Memetic Implementation and Structured Memetic Implementation
 */
public class Corrida {

    public static void main(String[] args) {

        var matrix = MatricesGeneratorV2.generateControlledMatrixMatrix(80);
        var rawFirstGeneration = MatricesGeneratorV2.generateRandomPopulation(matrix, 2);
        var fitness = MatricesGeneratorV2.extractTheBestFitnessFromContorlledMatrix(matrix);

        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(40);

        for (int i = 0; i < 2; i++) {
            if (i % 2 == 0) {
                var structuralMemeticInput = Input.builder()
                        .matrix(matrix)
                        .firstGeneration(rawFirstGeneration)
                        .fitnessToFind(fitness)
                        .build();
                threadPoolExecutor.submit(() -> {
                    StructuralMemetic structuralMemetic = new StructuralMemetic(structuralMemeticInput);
                    structuralMemetic.execute();
                });
            } else {
                var ooMemeticInput = Input.builder()
                        .matrix(matrix)
                        .firstGeneration(rawFirstGeneration)
                        .fitnessToFind(fitness)
                        .build();
                threadPoolExecutor.submit(() -> {
                    OOMemetic memetic = new OOMemetic(ooMemeticInput);
                    memetic.execute();
                });
            }
        }
    }
}
