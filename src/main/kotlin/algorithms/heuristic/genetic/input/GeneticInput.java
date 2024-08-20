package algorithms.heuristic.genetic.input;

import algorithms.heuristic.aid.Input;
import algorithms.heuristic.genetic.v1.Crossover;
import org.springframework.util.Assert;

public class GeneticInput implements Input {

    private final int[][] matrix;
    private Integer fitnessToFind;
    private int[][] firstGeneration;
    private Integer sizeOfFirstGeneration;

    private float txMutation;
    private float txCrossover;
    private float txElitism;
    private boolean withRoulette = true;
    private Crossover crossover;

    public GeneticInput(int[][] matrix) {
        assert matrix != null;
        this.matrix = matrix.clone();
    }

    public float getTxMutation() {
        return txMutation;
    }

    public void setTxMutation(float txMutation) {
        this.txMutation = txMutation;
    }

    public float getTxCrossover() {
        return txCrossover;
    }

    public void setTxCrossover(float txCrossover) {
        this.txCrossover = txCrossover;
    }

    public float getTxElitism() {
        return txElitism;
    }

    public void setTxElitism(float txElitism) {
        this.txElitism = txElitism;
    }

    public boolean isWithRoulette() {
        return withRoulette;
    }

    public void setWithRoulette(boolean withRoulette) {
        this.withRoulette = withRoulette;
    }

    public Crossover getCrossover() {
        return crossover;
    }

    public void setCrossover(Crossover crossover) {
        this.crossover = crossover;
    }

    @Override
    public int[][] getMatrix() {
        return matrix;
    }

    @Override
    public Integer getFitnessToFind() {
        return fitnessToFind;
    }

    @Override
    public void setFitnessToFind(Integer fitnessToFind) {
        validateFitnessToFind(fitnessToFind);
        this.fitnessToFind = fitnessToFind;
    }

    @Override
    public int[][] getFirstGeneration() {
        final int[][] generation = new int[firstGeneration.length][matrix.length];
        for (int i = 0; i < firstGeneration.length; i++) {
            System.arraycopy(firstGeneration[i], 0, generation[i], 0, firstGeneration[i].length);
        }
        return generation;
    }

    @Override
    public void setFirstGeneration(int[][] firstGeneration) {
        validateSizeOfFirstGeneration(firstGeneration, matrix);
        this.firstGeneration = firstGeneration;
    }

    @Override
    public Integer getSizeOfFirstGeneration() {
        return sizeOfFirstGeneration;
    }

    @Override
    public void setSizeOfFirstGeneration(Integer sizeOfFirstGeneration) {
        this.sizeOfFirstGeneration = sizeOfFirstGeneration;
    }

    @Override
    public void showMatrix() {
        showMatrix(matrix);
    }

    public static GeneticInputBuilder builder() {
        return new GeneticInputBuilder();
    }

    private static void validateFitnessToFind(Integer fitnessToFind) {
        if (fitnessToFind != null)
            Assert.isTrue(fitnessToFind > 0, "fitnessToFind cannot be less than 0");
    }

    private static void validateSizeOfFirstGeneration(int[][] generation, int[][] matrix) {
        if (generation != null)
            for (int i = 0; i < generation.length; i++) {
                Assert.isTrue(generation[i].length == matrix.length, "The size of individuals from population must be equal to size of matrix");
            }
    }
}