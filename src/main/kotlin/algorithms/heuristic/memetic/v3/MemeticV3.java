package algorithms.heuristic.memetic.v3;

import algorithms.heuristic.aid.Algorithm;
import algorithms.heuristic.aid.Input;
import algorithms.heuristic.aid.Output;
import algorithms.heuristic.memetic.v3.models.Generation;
import algorithms.heuristic.memetic.v3.models.Individual;

import java.time.Duration;
import java.time.LocalDateTime;

import static algorithms.heuristic.aid.Utils.*;

public class MemeticV3 implements Algorithm {

    private final int[][] matrix;
    private final Generation generation;
    private final int fitnessToFind;
    private final LocalDateTime initDate = LocalDateTime.now();

    public MemeticV3(final Input input) {
        this.matrix = input.getMatrix();
        this.fitnessToFind = input.getFitnessToFind();
        this.generation = new Generation(input.getFirstGeneration(), matrix);
    }

    @Override
    public Output execute() {
        return execute(generation);
    }

    private Output execute(Generation generation) {
        Individual latestBest = generation.getBestIndividual();

        //Variável auxiliar para guardar o melhor da população anterior anterior.
        int indexOfPopulation = 1;

        while (latestBest.getFitness() > fitnessToFind) {

            generation = jump(generation, matrix);

            generation = learn(generation, matrix);

            //TODO gambiarrona para elitizar o melhor e o algorithm não desaprender
            if (generation.getBestFitness() <= latestBest.getFitness()) {
//                if (generation.getBestFitness() < latestBest.getFitness())
//                    imprimir(indexOfPopulation, generation.getBestIndividual());
                latestBest = new Individual(generation.getBestIndividual().getChromosomes(), matrix);
            } else {
                generation.setBestIndividual(new Individual(latestBest.getChromosomes(), matrix));
            }
            if (indexOfPopulation % 10000 == 0) {
//                imprimir(indexOfPopulation, generation.getBestIndividual());
            }
            indexOfPopulation++;
        }
//        imprimir(indexOfPopulation, generation.getBestIndividual());
        Duration duration = Duration.between(initDate, LocalDateTime.now());
        return new Output(duration);
    }

    private static Generation jump(final Generation generation, final int[][] matrix) {
        final Individual currentBestIndividual = generation.getBestIndividual();
        final Generation newGeneration = generateRandomGeneration(generation.getIndividuals().length, matrix);
        newGeneration.setBestIndividual(currentBestIndividual);
        return newGeneration;
    }

    public static Generation learn(Generation generation, int[][] matrix) {

        //Percorrendo toda a população
        for (int n = 0; n < generation.getIndividuals().length; n++) { // TODO workaroundo for convergence function
            for (Individual individual : generation.getIndividuals()) {
                //Percorrendo o mellhor
                final Individual bestIndividual = generation.getBestIndividual();
                for (int m = 0; m < bestIndividual.getChromosomes().length - 1; m++) {
                    //Percorrendo o indivíduo da população
                    final int custoA = calculateFitness(bestIndividual.getChromosomes()[m], bestIndividual.getChromosomes()[m + 1], matrix);
                    for (int i = 0; i < individual.getChromosomes().length - 1; i++) {
                        if (individual.getChromosomes()[i] == bestIndividual.getChromosomes()[m]) {
                            final int custoB = calculateFitness(individual.getChromosomes()[i], individual.getChromosomes()[i + 1], matrix);
                            if (custoA < custoB) {
                                for (int k = 0; k < individual.getChromosomes().length; k++) {
                                    if (individual.getChromosomes()[k] == bestIndividual.getChromosomes()[m + 1]) {
                                        individual.getChromosomes()[k] = individual.getChromosomes()[i + 1];
                                        break;
                                    }
                                }
                                // todo diminui o custo A aqui do fitness
                                // ---
                                // TODO agora armazena quanto ficou de individual.getChromosomes()[i] até individual.getChromosomes()[i + 1] = variável X
                                individual.getChromosomes()[i + 1] = bestIndividual.getChromosomes()[m + 1];
                                // TODO diminui do fitness o valor recém armazenado em X, e soma novamente o calculo de quanto ficou de individual.getChromosomes()[i] até individual.getChromosomes()[i + 1]
                            } else if (custoB < custoA) {
                                for (int k = 0; k < bestIndividual.getChromosomes().length; k++) {
                                    if (bestIndividual.getChromosomes()[k] == individual.getChromosomes()[i + 1]) {
                                        bestIndividual.getChromosomes()[k] = bestIndividual.getChromosomes()[m + 1];
                                        break;
                                    }
                                }
                                bestIndividual.getChromosomes()[m + 1] = individual.getChromosomes()[i + 1];
                            }
                            break;
                        }
                    }
                }
            }
        }

        for (Individual individual : generation.getIndividuals()) { // TODO It must be removed
            individual.calculateFitness();
        }

        return new Generation(generation.getIndividuals());
    }

    private static Generation generateRandomGeneration(final int sizeOfPopulation, final int[][] matrix) {

        int[][] routes = new int[sizeOfPopulation][matrix.length];

        //Inicializando população inicial
        for (int k = 0; k < sizeOfPopulation; k++) {

            int[] auxRoute = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                auxRoute[i] = i;
            }

            int[] route = new int[auxRoute.length];

            shuffle(route.length, route, auxRoute);

//            if (!isContained(routes, route)) {
                routes[k] = route;
//            } else {
//                k--;
//            }
        }

        final Individual[] individuals = new Individual[routes.length];
        for (int i = 0; i < routes.length; i++) {
            individuals[i] = new Individual(routes[i], matrix);
        }

        return new Generation(individuals);
    }

    private void imprimir(final int indexOfPopulation, Individual individual) {
        System.out.println("OO " + indexOfPopulation + "|" + fitnessToFind + "|" + individual.getFitness());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("    ");
        for (int j : individual.getChromosomes()) {
            stringBuilder.append(" ").append(j);
        }
        System.out.println(stringBuilder);
    }

    private void imprimir(final int indexOfPopulation, int[] rota, int[][] matrix) {
        System.out.println("OO " + indexOfPopulation + "|" + fitnessToFind + "|" + calculateFitness(rota, matrix));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("    ");
        for (int j : rota) {
            stringBuilder.append(" ").append(j);
        }
        System.out.println(stringBuilder);
    }
}