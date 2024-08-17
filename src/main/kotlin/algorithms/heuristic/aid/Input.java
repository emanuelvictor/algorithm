package algorithms.heuristic.aid;

import org.springframework.util.Assert;

public class Input {

    private final int[][] matrix;
    private Integer fitnessToFind;
    private int[][] firstGeneration;
    private Integer sizeOfFirstGeneration;

    public Input(int[][] matrix) {
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

    public void showMatrix() {
        showMatrix(matrix);
    }

    public static InputBuilder builder() {
        return new InputBuilder();
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

    public static void showMatrix(final int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (i == 0)
                System.out.print("{");
            for (int g = 0; g < matrix[i].length; g++) {

                System.out.print((g == 0 ? "{" : ""));
                if (matrix[i][g] < 10)
                    System.out.print("  " + matrix[i][g]);
                else if (matrix[i][g] < 100 && matrix[i][g] >= 10)
                    System.out.print(" " + matrix[i][g]);
                else if (matrix[i][g] < 1000 && matrix[i][g] >= 100)
                    System.out.print(matrix[i][g]);
                System.out.print((g == matrix[i].length - 1 ? "}" + (i == matrix.length - 1 ? "" : ",") : ","));
            }
            if (i == matrix.length - 1)
                System.out.println("};");
            System.out.println();
        }
    }
}
