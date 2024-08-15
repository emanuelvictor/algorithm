package algorithms.heuristic.memetic;

import algorithms.heuristic.Input;
import algorithms.heuristic.Output;
import algorithms.heuristic.matrix.MatricesGeneratorV2;
import algorithms.heuristic.memetic.oo.OOMemetic;
import algorithms.heuristic.memetic.structured.OldStructuredMemetic;
import algorithms.heuristic.memetic.structured.StructuredMemetic;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Dedicated to compare OO Memetic Implementation and Structured Memetic Implementation
 */
public class MemeticLab {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(140);

    static List<Duration> durationsFromOOMemetic = new ArrayList<>();
    static List<Duration> durationsFromOldStructuredMemetic = new ArrayList<>();
    static List<Duration> durationsFromStructuredMemetic = new ArrayList<>();

    public static void main(String[] args) {

        var matrix = MatricesGeneratorV2.generateSupervisedMatrixMatrix(30);
        var rawFirstGeneration = MatricesGeneratorV2.generateRandomPopulation(matrix, 3);
        var fitness = MatricesGeneratorV2.extractTheBestFitnessFromSupervisedMatrix(matrix);

        for (int i = 1; i <= 40; i++) {
            int finalI = i;
            EXECUTOR_SERVICE.submit(() -> {
                var input = Input.builder()
                        .matrix(matrix)
                        .firstGeneration(rawFirstGeneration)
                        .fitnessToFind(fitness)
                        .build();
                final OOMemetic memetic = new OOMemetic(input);
                final Output output = memetic.execute();
                durationsFromOOMemetic.add(output.getDuration());
                System.out.println("OOMemetic DONE: " + durationsFromOOMemetic.size() + ", OldStructuredMemetic DONE: " + durationsFromOldStructuredMemetic.size() + ", StructuredMemetic DONE: " + durationsFromStructuredMemetic.size());
            });
            EXECUTOR_SERVICE.submit(() -> {
                var input = Input.builder()
                        .matrix(matrix)
                        .firstGeneration(rawFirstGeneration)
                        .fitnessToFind(fitness)
                        .build();
                final OldStructuredMemetic oldStructuredMemetic = new OldStructuredMemetic(input);
                final Output output = oldStructuredMemetic.execute();
                durationsFromOldStructuredMemetic.add(output.getDuration());
                System.out.println("OOMemetic DONE: " + durationsFromOOMemetic.size() + ", OldStructuredMemetic DONE: " + durationsFromOldStructuredMemetic.size() + ", StructuredMemetic DONE: " + durationsFromStructuredMemetic.size());
            });
            EXECUTOR_SERVICE.submit(() -> {
                var input = Input.builder()
                        .matrix(matrix)
                        .firstGeneration(rawFirstGeneration)
                        .fitnessToFind(fitness)
                        .build();
                final StructuredMemetic structuredMemetic = new StructuredMemetic(input);
                final Output output = structuredMemetic.execute();
                durationsFromStructuredMemetic.add(output.getDuration());
                System.out.println("OOMemetic DONE: " + durationsFromOOMemetic.size() + ", OldStructuredMemetic DONE: " + durationsFromOldStructuredMemetic.size() + ", StructuredMemetic DONE: " + durationsFromStructuredMemetic.size());
            });
        }

        EXECUTOR_SERVICE.close();

        double averageFromOOMemetic = durationsFromOOMemetic.stream()
                .mapToLong(value -> value.toSeconds())
                .average()
                .orElse(0.0);

        double averageFromOldStructuredMemetic = durationsFromOldStructuredMemetic.stream()
                .mapToLong(value -> value.toSeconds())
                .average()
                .orElse(0.0);

        double averageFromStructuredMemetic = durationsFromStructuredMemetic.stream()
                .mapToLong(value -> value.toSeconds())
                .average()
                .orElse(0.0);
        System.out.println("averageFromOOMemetic: " + averageFromOOMemetic);
        System.out.println("averageFromOldStructuredMemetic: " + averageFromOldStructuredMemetic);
        System.out.println("averageFromStructuredMemetic: " + averageFromStructuredMemetic);

    }
}
