package algorithms.heuristic.genetic.input;

import algorithms.heuristic.aid.Input;
import algorithms.heuristic.aid.matrix.MatricesGeneratorV2;

public class GeneticInputBuilder {

    static Integer DEFAULT_SIZE_OF_MARIX = 100;
    static Integer DEFAULT_SIZE_OF_FIRST_POPULATION = 2;

    private int[][] matrix;
    private int[][] firstGeneration;
    private Integer fitnessToFind;
    private Integer sizeOfFirstGeneration = DEFAULT_SIZE_OF_FIRST_POPULATION;

    public GeneticInputBuilder() {
    }

    public GeneticInputBuilder matrix(int[][] matrix) {
        this.matrix = matrix.clone();
        return this;
    }

    public GeneticInputBuilder fitnessToFind(Integer fitnessToFind) {
        this.fitnessToFind = fitnessToFind;
        return this;
    }

    public GeneticInputBuilder sizeOfFirstGeneration(Integer sizeOfFirstGeneration) {
        this.sizeOfFirstGeneration = sizeOfFirstGeneration;
        return this;
    }

    public GeneticInputBuilder firstGeneration(int[][] firstGeneration) {
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
        final Input input = new GeneticInput(matrix);
        input.setSizeOfFirstGeneration(sizeOfFirstGeneration);
        input.setFirstGeneration(firstGeneration);
        input.setFitnessToFind(fitnessToFind);
        return input;
    }
}