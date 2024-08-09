package algorithms.heuristic;

import algorithms.heuristic.matrix.MatricesGeneratorV2;

public class InputBuilder {

    static Integer DEFAULT_SIZE_OF_MARIX = 100;
    static Integer DEFAULT_SIZE_OF_FIRST_POPULATION = 2;

    private int[][] matrix;
    private int[][] firstGeneration;
    private Integer fitnessToFind;
    private Integer sizeOfFirstGeneration = DEFAULT_SIZE_OF_FIRST_POPULATION;

    public InputBuilder() {
    }

    public InputBuilder matrix(int[][] matrix) {
        this.matrix = matrix.clone();
        return this;
    }

    public InputBuilder fitnessToFind(Integer fitnessToFind) {
        this.fitnessToFind = fitnessToFind;
        return this;
    }

    public InputBuilder sizeOfFirstGeneration(Integer sizeOfFirstGeneration) {
        this.sizeOfFirstGeneration = sizeOfFirstGeneration;
        return this;
    }

    public InputBuilder firstGeneration(int[][] firstGeneration) {
        this.firstGeneration = new int[firstGeneration.length][];
        for (int g = 0; g < this.firstGeneration.length; g++) {
            this.firstGeneration[g] = firstGeneration[g].clone();
        }
        return this;
    }

    public Input build() {
        if (matrix == null) {
            MatricesGeneratorV2 matricesGenerator = new MatricesGeneratorV2(DEFAULT_SIZE_OF_MARIX);
            matrix = matricesGenerator.getMatrix();
            fitnessToFind = matricesGenerator.getFitness();
        }
        if (firstGeneration == null) {
            firstGeneration = MatricesGeneratorV2.generateRandomPopulation(matrix, sizeOfFirstGeneration);
        }
        final Input input = new Input(matrix);
        input.setSizeOfFirstGeneration(sizeOfFirstGeneration);
        input.setFirstGeneration(firstGeneration);
        input.setFitnessToFind(fitnessToFind);
        return input;
    }
}