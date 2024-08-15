package algorithms.heuristic.memetic.structured;


import algorithms.heuristic.Algorithm;
import algorithms.heuristic.Input;
import algorithms.heuristic.Output;

import java.time.Duration;
import java.time.LocalDateTime;

import static algorithms.heuristic.Utils.*;

public class StructuredMemetic implements Algorithm {

    private final int[][] matrix;
    private final int[][] generation;
    private final int fitnessToFind;
    private final LocalDateTime initDate = LocalDateTime.now();

    public StructuredMemetic(final Input input) {
        this.matrix = input.getMatrix();
        this.fitnessToFind = input.getFitnessToFind();
        this.generation = input.getFirstGeneration();
    }

    public Output execute() {
        return execute(generation);
    }

    private Output execute(int[][] population) {
        int[] best = sort(population, calculateFitness(population, matrix))[0];

        //Variável auxiliar para guardar o melhor da população anterior anterior.
        int melhorFitnessAnterior = calculateFitness(best, matrix);
        int indexOfPopulation = 1;

        while (!foundTheBestGlobalFitness(population, matrix, fitnessToFind)) {

            population = jump(population, matrix);

            population = learn(population, matrix);

            //Variável auxiliar para não duplicar o processo de cálculo do fitness
            final int currentBest = calculateFitness(best, matrix);

            //TODO gambiarrona para elitizar o melhor e o algorithm não desaprender
            if (calculateFitness(sort(population, calculateFitness(population, matrix))[0], matrix) <= currentBest) {
                System.arraycopy(population[0], 0, best, 0, population[0].length);
            } else {
                System.arraycopy(best, 0, population[0], 0, population[0].length);
            }
            //Se o fitness do melhor indivíduo encontrado for melhor que o anterior, imprime-o
            if (currentBest < melhorFitnessAnterior) {
                melhorFitnessAnterior = calculateFitness(best, matrix);
//                imprimir(null, sort(population, calculateFitness(population, matrix))[0], matrix);
//                System.out.println(" = " + calcularFitness(ordenar(population, calcularFitness(population, matrix))[0], matrix));
            }
            indexOfPopulation++;
            if(indexOfPopulation % 10000 == 0){
//                imprimir(indexOfPopulation, sort(population, calculateFitness(population, matrix))[0], matrix);
            }
        }
//        imprimir(indexOfPopulation, sort(population, calculateFitness(population, matrix))[0], matrix);
        Duration duration = Duration.between(initDate, LocalDateTime.now());
        return new Output(duration);
    }

    private static boolean foundTheBestGlobalFitness(final int[][] population, final int[][] matrix, final int fitness) {
        return calculateFitness(population, matrix)[0] <= fitness;
    }

    private static int[][] jump(final int[][] population, final int[][] matrix) {
        int[] bestChromosome = sort(population, calculateFitness(population, matrix))[0];
        final int[][] newPopulation = generateRandomPopulation(population.length, matrix);
        newPopulation[newPopulation.length - 1] = bestChromosome;
        return sort(newPopulation, calculateFitness(newPopulation, matrix));
    }

    public static int[][] learn(int[][] population, int[][] matrix) {

        final int m = 0;

        //Percorrendo toda a população
        for (int n = 0; n < population.length; n++) {
            for (int i = 1; i < population.length; i++) {
                //Percorrendo o mellhor
                for (int c = 0; c < population[m].length - 1; c++) {
                    //Percorrendo o indivíduo da população
                    final int custoA = calculateFitness(population[m][c], population[m][c + 1], matrix);
                    for (int j = 0; j < population[i].length - 1; j++) {
                        if (population[i][j] == population[m][c]) {
                            final int custoB = calculateFitness(population[i][j], population[i][j + 1], matrix);
                            if (custoA < custoB) {
                                for (int k = 0; k < population[i].length; k++) {
                                    if (population[i][k] == population[m][c + 1]) {
                                        population[i][k] = population[i][j + 1];
                                        break;
                                    }
                                }
                                population[i][j + 1] = population[m][c + 1];
                            } else if (custoB < custoA) {
                                for (int k = 0; k < population[m].length; k++) {
                                    if (population[m][k] == population[i][j + 1]) {
                                        population[m][k] = population[m][c + 1];
                                        break;
                                    }
                                }
                                population[m][c + 1] = population[i][j + 1];
                            }
                            break;
                        }
                    }
                }
            }
        }
        return sort(population, calculateFitness(population, matrix));
    }

    private void imprimir(final int indexOfPopulation, int[] rota, int[][] matrix) {
        System.out.println("Structured "+ indexOfPopulation + "|" + fitnessToFind + "|" + calculateFitness(rota, matrix));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("    ");
        for (int j : rota) {
            stringBuilder.append(" ").append(j);
        }
        System.out.println(stringBuilder);
    }
}