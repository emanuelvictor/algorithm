package algorithms.heuristic.memetic.v3.models;

public class Individual {

    private final int[][] matrix;
    private int fitness;
    private final int[] chromosomes;

    public Individual(int[] chromosomes, int[][] matrix) {
        this.matrix = matrix;
        this.chromosomes = chromosomes.clone();
        this.calculateFitness();
    }

    // TODO must have unity test
    public void calculateFitness() {
        fitness = calculateFitness(chromosomes, matrix);
    }

    private static int calculateFitness(final int[] chromosome, final int[][] matrix) {
        int fitness = 0;
        for (int j = 0; j < chromosome.length; j++) {
            fitness = fitness + matrix[chromosome[j]][chromosome[j == chromosome.length - 1 ? 0 : j + 1]];
        }
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public int getFitness() {
        return fitness;
    }

    public int[] getChromosomes() {
        return chromosomes;
    }
}
