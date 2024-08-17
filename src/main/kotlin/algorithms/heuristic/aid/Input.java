package algorithms.heuristic.aid;

public interface Input {

    int[][] getMatrix();

    Integer getFitnessToFind();

    void setFitnessToFind(Integer fitnessToFind);

    int[][] getFirstGeneration();

    void setFirstGeneration(int[][] firstGeneration);

    Integer getSizeOfFirstGeneration();

    void setSizeOfFirstGeneration(Integer sizeOfFirstGeneration);

    void showMatrix();

    default void showMatrix(final int[][] matrix) {
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
