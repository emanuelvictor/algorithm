package algorithms.heuristic.aid;

import java.util.Arrays;
import java.util.Random;

public class Utils {

    public static int[][] generateRandomPopulation(final int sizeOfPopulation, final int[][] matrix) {

        int[][] routes = new int[sizeOfPopulation][matrix.length];

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

        return sort(routes, calculateFitness(routes, matrix));
    }

    public static void shuffle(final int tam, final int[] route, int[] auxRoute) {
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

    public static int[] fillWithoutRandom(final int[] arrayOfIndex, final int random) {
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

    public static int[] calculateFitness(final int[][] population, final int[][] matrix) {
        int[] fitness = new int[population.length];
        for (int i = 0; i < population.length; i++) {
            fitness[i] = calculateFitness(population[i], matrix);
        }
        return fitness;
    }

    public static int calculateFitness(final int[] chromosome, final int[][] matrix) {
        int fitness = 0;
        for (int j = 0; j < chromosome.length; j++) {
            fitness = fitness + matrix[chromosome[j]][chromosome[j == chromosome.length - 1 ? 0 : j + 1]];
        }
        return fitness;
    }

    public static int calculateFitness(int cidade1, int cidade2, int[][] matrix) {
        return matrix[cidade1][cidade2];
    }

    public static int[][] sort(final int[][] population, final int[] fitness) {
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

    public static boolean isContained(int[][] population, int[] individuo) {
        for (int[] auxiliar : population) {
            if (Arrays.equals(auxiliar, individuo)) {
                return true;
            }
        }
        return false;
    }
}
