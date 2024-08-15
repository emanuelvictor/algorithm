package algorithms.heuristic.matrix;

import java.util.Arrays;
import java.util.Random;

/**
 * Algoritmo Genético implementado por Emanuel Victor e Haroldo Ramirez em 29/09/14.
 * Análise da influencia da mutação nos crossovers OX e PMX.
 * Matrixes analisadas
 */
public final class MatricesGeneratorV2 {

    private int fitness;

    private int[][] matrix;

    public int getFitness() {
        return fitness;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public MatricesGeneratorV2(int sizeOfMatrix) {
        generateLinearMatrix(sizeOfMatrix);
    }

    private void generateLinearMatrix(final int sizeOfMatrix) {
        generateMatrix(sizeOfMatrix, true);
    }

    private void generateMatrix(final int sizeOfMatrix, final boolean linear) {

        final int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        final Random random = new Random();

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++) {
                final int randomNumber = random.nextInt(matrix.length) + matrix.length;
                matrix[i][j] = randomNumber == matrix.length ? randomNumber + 1 : randomNumber;
            }

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                if (j == i)
                    matrix[j][i] = 0;

        for (int i = 0; i < matrix.length; i++)
            for (int j = 1; j < matrix.length; j++)
                if (j == i)
                    if (linear)
                        matrix[j - 1][i] = i;
                    else
                        matrix[j - 1][i] = random.nextInt(matrix.length);

        // Back to home
        matrix[0][matrix.length - 1] = linear ? matrix.length : random.nextInt(matrix.length);

        for (int i = 0; i < matrix.length; i++)
            for (int j = 1; j < matrix.length; j++)
                matrix[j][i] = matrix[i][j];

        this.matrix = matrix;

        this.fitness = calculateFitness();
    }

    private int calculateFitness() {

        this.fitness = this.matrix[this.matrix.length - 1][this.matrix.length - 1];

        for (int i = 0; i < this.matrix.length; i++) {
            for (int i1 = 0; i1 < this.matrix.length; i1++) {
                if (i == i1)
                    fitness = fitness + this.matrix[i == this.matrix.length - 1 ? 0 : i + 1][i1];
            }
        }

        return fitness;
    }

    public static int[][] generateSupervisedMatrixMatrix(final int sizeOfMatrix) {

        final int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        final Random random = new Random();

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++) {
                final int randomNumber = random.nextInt(matrix.length) + matrix.length;
                matrix[i][j] = randomNumber == matrix.length ? randomNumber + 1 : randomNumber;
            }

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                if (j == i)
                    matrix[j][i] = 0;

        for (int i = 0; i < matrix.length; i++)
            for (int j = 1; j < matrix.length; j++)
                if (j == i)
                    matrix[j - 1][i] = i;

        // Back to home
        matrix[0][matrix.length - 1] = matrix.length;

        for (int i = 0; i < matrix.length; i++)
            for (int j = 1; j < matrix.length; j++)
                matrix[j][i] = matrix[i][j];

        return matrix;
    }

    // TODO fazer a somatória entre 1 até o size da matrix.
    public static int extractTheBestFitnessFromSupervisedMatrix(final int[][] matrix) {

        int fitness = matrix[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix.length; i1++) {
                if (i == i1)
                    fitness = fitness + matrix[i == matrix.length - 1 ? 0 : i + 1][i1];
            }
        }

        return fitness;
    }

    public static int[][] generateRandomPopulation(final int[][] matrix, final int sizePopulation) {
        int[][] routes = new int[sizePopulation][matrix.length];

        //Inicializando população inicial
        for (int k = 0; k < sizePopulation; k++) {

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

        return routes;
    }

    private static boolean isContained(final int[][] population, final int[] chromosome) {
        for (final int[] ints : population) {
            if (Arrays.equals(ints, chromosome)) {
                return true;
            }
        }
        return false;
    }

    private static void shuffle(final int size, final int[] route, int[] auxRoute) {
        // Shuffling
        for (int i = 0; i < size; i++) {
            int r;
            do {
                r = new Random().nextInt(size - i);
            } while (r == i);

            route[i] = auxRoute[r];
            auxRoute = preencheVetorSemOR(auxRoute, r);
        }
    }

    private static int[] preencheVetorSemOR(final int[] vetorDeIndices, final int r) {
        int[] vetAux = new int[vetorDeIndices.length - 1];
        int cont = 0;
        for (int j = 0; j < vetorDeIndices.length; j++) {
            if (j == r) {
                continue;
            }
            vetAux[cont] = vetorDeIndices[j];
            cont++;
        }
        return vetAux;
    }
}