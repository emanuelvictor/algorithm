package algorithms.heuristic;

import algorithms.heuristic.memetic.input.MemeticInput;
import algorithms.heuristic.aid.Output;
import algorithms.heuristic.aid.matrix.MatricesGeneratorV2;
import algorithms.heuristic.memetic.v1.MemeticV1;
import algorithms.heuristic.memetic.v2.MemeticV2;
import algorithms.heuristic.memetic.v3.MemeticV3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Dedicated to compare OO Memetic Implementation and Structured Memetic Implementation
 */
public class TimeAverageOfExecutionLab {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(470);

    static List<Duration> durationsFromOOMemetic = new ArrayList<>();
    static List<Duration> durationsFromStructuredMemetic = new ArrayList<>();
    static List<Duration> durationsFromOldStructuredMemetic = new ArrayList<>();
 // TODO precisamos de mais dados estatísticos como:
    // Qual terminou a primeira execução primeiro.
    // Qual teve a execução mais demorada e menos demorada.
    public static void main(String[] args) {

        printHeader();

        var matrix = MatricesGeneratorV2.generateSupervisedMatrixMatrix(30);
        var rawFirstGeneration = MatricesGeneratorV2.generateRandomPopulation(matrix, 3);
        var fitness = MatricesGeneratorV2.extractTheBestFitnessFromSupervisedMatrix(matrix);

        var input = MemeticInput.builder()
                .matrix(matrix)
                .firstGeneration(rawFirstGeneration)
                .fitnessToFind(fitness)
                .build();

        for (int i = 1; i <= 150; i++) {
            EXECUTOR_SERVICE.submit(() -> {
                final MemeticV3 memetic = new MemeticV3(input);
                final Output output = memetic.execute();
                durationsFromOOMemetic.add(output.getDuration());
                printRun(durationsFromOOMemetic, durationsFromStructuredMemetic, durationsFromOldStructuredMemetic);
            });
            EXECUTOR_SERVICE.submit(() -> {
                final MemeticV1 memeticV1 = new MemeticV1(input);
                final Output output = memeticV1.execute();
                durationsFromOldStructuredMemetic.add(output.getDuration());
                printRun(durationsFromOOMemetic, durationsFromStructuredMemetic, durationsFromOldStructuredMemetic);
            });
            EXECUTOR_SERVICE.submit(() -> {
                final MemeticV2 memeticV2 = new MemeticV2(input);
                final Output output = memeticV2.execute();
                durationsFromStructuredMemetic.add(output.getDuration());
                printRun(durationsFromOOMemetic, durationsFromStructuredMemetic, durationsFromOldStructuredMemetic);
            });
        }

        EXECUTOR_SERVICE.close();

        printResume(durationsFromOOMemetic, durationsFromStructuredMemetic, durationsFromOldStructuredMemetic);
    }

    /**
     * Print header V3|V2|V1
     */
    private static void printHeader() {
        System.out.println("V3|V2|V1");
    }


    private static void printRun(final List<Duration> durationsFromOOMemetic,
                                 final List<Duration> durationsFromStructuredMemetic,
                                 final List<Duration> durationsFromOldStructuredMemetic) {
        System.out.print("\r" + String.format("%02d", durationsFromOOMemetic.size()) + "|" + String.format("%02d", durationsFromStructuredMemetic.size()) + "|" + String.format("%02d", durationsFromOldStructuredMemetic.size()));
    }

    private static void printResume(final List<Duration> durationsFromOOMemetic,
                                    final List<Duration> durationsFromStructuredMemetic,
                                    final List<Duration> durationsFromOldStructuredMemetic) {
        double averageFromOOMemetic = durationsFromOOMemetic.stream()
                .mapToLong(Duration::toSeconds)
                .average()
                .orElse(0.0);

        double averageFromStructuredMemetic = durationsFromStructuredMemetic.stream()
                .mapToLong(Duration::toSeconds)
                .average()
                .orElse(0.0);

        double averageFromOldStructuredMemetic = durationsFromOldStructuredMemetic.stream()
                .mapToLong(Duration::toSeconds)
                .average()
                .orElse(0.0);
        System.out.println();
        System.out.println("V3 Average time: " + averageFromOOMemetic);
        System.out.println("V2 Average time: " + averageFromStructuredMemetic);
        System.out.println("V1 Average time: " + averageFromOldStructuredMemetic);
    }

}
