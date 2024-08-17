package algorithms.heuristic.memetic.input;

import algorithms.heuristic.aid.Input;
import org.springframework.util.Assert;

public class MemeticInput implements Input {

    private final int[][] matrix;
    private Integer fitnessToFind;
    private int[][] firstGeneration;
    private Integer sizeOfFirstGeneration;

    public MemeticInput(int[][] matrix) {
        assert matrix != null;
        this.matrix = matrix.clone();
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public Integer getFitnessToFind() {
        return fitnessToFind;
    }

    public void setFitnessToFind(Integer fitnessToFind) {
        validateFitnessToFind(fitnessToFind);
        this.fitnessToFind = fitnessToFind;
    }

    public int[][] getFirstGeneration() {
        final int[][] generation = new int[firstGeneration.length][matrix.length];
        for (int i = 0; i < firstGeneration.length; i++) {
            System.arraycopy(firstGeneration[i], 0, generation[i], 0, firstGeneration[i].length);
        }
        return generation;
    }

    public void setFirstGeneration(int[][] firstGeneration) {
        validateSizeOfFirstGeneration(firstGeneration, matrix);
        this.firstGeneration = firstGeneration;
    }

    public Integer getSizeOfFirstGeneration() {
        return sizeOfFirstGeneration;
    }

    public void setSizeOfFirstGeneration(Integer sizeOfFirstGeneration) {
        this.sizeOfFirstGeneration = sizeOfFirstGeneration;
    }

    public static MemeticInputBuilder builder() {
        return new MemeticInputBuilder();
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

    public void showMatrix() {
        showMatrix(matrix);
    }
}
