package heuristic.algorithms.oo;

import heuristic.matrix.Input;

import java.util.Arrays;
import java.util.Random;

public class Memetic implements Algorithm {

    private final int[][] matrix;
    private final Generation generation;
    private final int fitnessToFind;

    public Memetic(final Input input) {
        this.matrix = input.getMatrix();
        this.fitnessToFind = input.getFitnessToFind();
        this.generation = input.getGeneration();
    }

    @Override
    public void execute() {
        execute(generation);
    }

    private void execute(Generation generation) {
        Individual latestBest = generation.getBestIndividual();

        //Variável auxiliar para guardar o melhor da população anterior anterior.
        int indexOfPopulation = 1;

        while (latestBest.getFitness() > fitnessToFind) {

            generation = jump(generation, matrix);

            generation = learn(generation, matrix);

            //TODO gambiarrona para elitizar o melhor e o algorithm não desaprender
            if (generation.getBestFitness() <= latestBest.getFitness()) {
                if (generation.getBestFitness() < latestBest.getFitness())
                    imprimir(indexOfPopulation, generation.getBestIndividual());
                latestBest = new Individual(generation.getBestIndividual().getChromosomes(), matrix);
            } else {
                generation.setBestIndividual(new Individual(latestBest.getChromosomes(), matrix));
            }

            indexOfPopulation++;
            if (indexOfPopulation % 50 == 0) {
//                imprimir(indexOfPopulation, generation.getBestIndividual());
            }
        }
        imprimir(indexOfPopulation, generation.getBestIndividual());
    }

    private static boolean foundTheBestGlobalFitness(final int[][] population, final int[][] matrix, final int fitness) {
        return calculateFitness(population, matrix)[0] <= fitness;
    }

    private static Generation jump(final Generation generation, final int[][] matrix) {
        final Individual currentBestIndividual = generation.getBestIndividual();
        final Generation newGeneration = generateRandomGeneration(generation.getIndividuals().length, matrix);
        newGeneration.setBestIndividual(currentBestIndividual);
        return newGeneration;
    }

    public static Generation learn(Generation generation, int[][] matrix) {

//        int[] fitness = calculateFitness(population, matrix);

//        sort(population, fitness);

        final int m = 0; //roulette(fitness);
        //Percorrendo toda a população
        for (Individual individual : generation.getIndividuals()) {
            for (int i = 0; i < individual.getChromosomes().length; i++) { // TODO não sei pra que serve, mas melhora muito o desempenho. Ah acho que é para função de conversão.
                //Percorrendo o mellhor
                final Individual bestIndividual = generation.getBestIndividual();
                for (int c = 0; c < bestIndividual.getChromosomes().length - 1; c++) {
                    //Percorrendo o indivíduo da população
                    final int custoA = calculateFitness(bestIndividual.getChromosomes()[c], bestIndividual.getChromosomes()[c + 1], matrix);
                    for (int j = 0; j < individual.getChromosomes().length - 1; j++) {
                        if (individual.getChromosomes()[j] == bestIndividual.getChromosomes()[c]) {
                            final int custoB = calculateFitness(individual.getChromosomes()[j], individual.getChromosomes()[j + 1], matrix);
                            if (custoA < custoB) {
                                for (int k = 0; k < individual.getChromosomes().length; k++) {
                                    if (individual.getChromosomes()[k] == bestIndividual.getChromosomes()[c + 1]) {
                                        individual.getChromosomes()[k] = individual.getChromosomes()[j + 1];
                                        break;
                                    }
                                }
                                individual.getChromosomes()[j + 1] = bestIndividual.getChromosomes()[c + 1];
                            } else if (custoB < custoA) {
                                for (int k = 0; k < bestIndividual.getChromosomes().length; k++) {
                                    if (bestIndividual.getChromosomes()[k] == individual.getChromosomes()[j + 1]) {
                                        bestIndividual.getChromosomes()[k] = bestIndividual.getChromosomes()[c + 1];
                                        // bestIndividual.setFitness(bestIndividual.getFitness() - (custoA - custoB)); TODO put it in setChromosome
                                        break;
                                    }
                                }
                                bestIndividual.getChromosomes()[c + 1] = individual.getChromosomes()[j + 1];
                            }
                            break;
                        }
                    }
                }
            }
        }

        // TODO workaround to recalculate fitness
        for (Individual individual : generation.getIndividuals()) {
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

            if (!isContained(routes, route)) {
                routes[k] = route;
            } else {
                k--;
            }
        }

        final Individual[] individuals = new Individual[routes.length];
        for (int i = 0; i < routes.length; i++) {
            individuals[i] = new Individual(routes[i], matrix);
        }

        return new Generation(individuals);
    }

    private static void shuffle(final int tam, final int[] route, int[] auxRoute) {
        // Shuffling
        for (int i = 0; i < tam; i++) {
            int random;
            do {
                random = new Random().nextInt(tam - i);
            } while (random == i);

            route[i] = auxRoute[random];
            auxRoute = fillWithoutRandom(auxRoute, random);
        }
    }

    private static int[] fillWithoutRandom(final int[] arrayOfIndex, final int random) {
        int[] auxArray = new int[arrayOfIndex.length - 1];
        int cont = 0;
        for (int j = 0; j < arrayOfIndex.length; j++) {
            if (j == random) {
                continue;
            }
            auxArray[cont] = arrayOfIndex[j];
            cont++;
        }
        return auxArray;
    }

    private static int[] calculateFitness(final int[][] population, final int[][] matrix) {
        int[] fitness = new int[population.length];
        for (int i = 0; i < population.length; i++) {
            fitness[i] = calculateFitness(population[i], matrix);
        }
        return fitness;
    }

    private static int calculateFitness(final int[] chromosome, final int[][] matrix) {
        int fitness = 0;
        for (int j = 0; j < chromosome.length; j++) {
            fitness = fitness + matrix[chromosome[j]][chromosome[j == chromosome.length - 1 ? 0 : j + 1]];
        }
        return fitness;
    }

    private static int calculateFitness(int cidade1, int cidade2, int[][] matrix) {
        return matrix[cidade1][cidade2];
    }

    private static int[][] sort(final int[][] population, final int[] fitness) {
        // ordenando
        int i, i2;
        for (i = 0; i < population.length; i++) {
            for (i2 = i; i2 < population.length; i2++) {
                if (fitness[i] > fitness[i2]) {
                    int vTmp = fitness[i];
                    fitness[i] = fitness[i2];
                    fitness[i2] = vTmp;

                    int[] vvTmp = population[i];
                    population[i] = population[i2];
                    population[i2] = vvTmp;
                }
            }
        }
        return population;
    }

    private static boolean isContained(int[][] population, int[] individuo) {
        for (int[] auxiliar : population) {
            if (Arrays.equals(auxiliar, individuo)) {
                return true;
            }
        }
        return false;
    }

//    private static void imprimir(int[][] population, int[] fitness, int[][] matrix) {
//        for (int j = 0; j < population.length; j++) {
//            System.out.print("Rota " + j + " = ");
//            for (int i = 0; i < matrix.length; i++) {
//                System.out.print(" " + population[j][i] + " ");
//            }
//            System.out.println(" fitness = " + fitness[j]);
//        }
//    }

    private void imprimir(final int indexOfPopulation, Individual individual) {
        System.out.println(indexOfPopulation + "|" + fitnessToFind + "|" + individual.getFitness());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("    ");
        for (int j : individual.getChromosomes()) {
            stringBuilder.append(" ").append(j);
        }
        System.out.println(stringBuilder);
    }

    private void imprimir(final int indexOfPopulation, int[] rota, int[][] matrix) {
        System.out.println(indexOfPopulation + "|" + fitnessToFind + "|" + calculateFitness(rota, matrix));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("    ");
        for (int j : rota) {
            stringBuilder.append(" ").append(j);
        }
        System.out.println(stringBuilder);
    }
}