package algorithms.heuristic.matrix;


import algorithms.heuristic.memetic.oo.Generation;
import algorithms.heuristic.memetic.oo.Individual;
import org.springframework.util.Assert;

public class Input {

    private final int[][] matrix;

    private Integer fitnessToFind;

    private Generation generation;

    public Input(int[][] matrix) {
        assert matrix != null;
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public Integer getFitnessToFind() {
        return fitnessToFind;
    }

    public Generation getGeneration() {
        return generation;
    }

    public static InputBuilder builder() {
        return new InputBuilder();
    }

    public void setFitnessToFind(Integer fitnessToFind) {
        validateFitnessToFind(fitnessToFind);
        this.fitnessToFind = fitnessToFind;
    }

    private static void validateFitnessToFind(Integer fitnessToFind) {
        if (fitnessToFind != null)
            Assert.isTrue(fitnessToFind > 0, "fitnessToFind cannot be less than 0");
    }

    public void setGeneration(Generation generation) {
        validateSizeOfFirstPopulation(generation, matrix);
        this.generation = generation;
    }

    private static void validateSizeOfFirstPopulation(Generation generation, int[][] matrix) {
        if (generation != null)
            for (Individual individual : generation.getIndividuals()) {
                Assert.isTrue(individual.getChromosomes().length == matrix.length, "The size of individuals from population must be equal to size of matrix");
            }
    }

    public void showMatrix(){
        showMatrix(matrix);
    }

    /**
     * Auxiliary method
     */
    public static void showMatrix(final int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (i == 0)
                System.out.print("{");
            for (int j = 0; j < matrix[i].length; j++) {
                final String firstChar;
                if (j == 0) {
                    firstChar = "{";
                } else {
                    firstChar = "";
                }
                final String lastChar;
                if (j == matrix[i].length - 1) {
                    if (i == matrix.length - 1) {
                        lastChar = "}";
                    } else
                        lastChar = "},";
                } else lastChar = ",";
                if (matrix[i][j] == 0)
                    System.out.print(firstChar + "  0" + lastChar);
                else if (matrix[i][j] < 100 && matrix[i][j] >= 10)
                    System.out.print(firstChar + " " + matrix[i][j] + lastChar);
                else if (matrix[i][j] < 10)
                    System.out.print(firstChar + "  " + matrix[i][j] + lastChar);
                else
                    System.out.print(matrix[i][j]);
            }
            if (i == matrix.length - 1)
                System.out.print("};");
            System.out.println();
        }
    }


//    /**
//     * Auxiliary method
//     */
//    public void showGeneration() {
//        showMatrix(generation);
//    }
}
