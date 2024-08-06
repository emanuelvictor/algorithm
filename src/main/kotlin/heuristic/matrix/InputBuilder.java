package heuristic.matrix;

import heuristic.algorithms.oo.Generation;
import heuristic.matrix.builder.MatricesGeneratorV2;

public final class InputBuilder {

    private int[][] matrix;
    private Generation firstGeneration;
    private Integer fitnessToFind;

    InputBuilder() {
    }

    public InputBuilder matrix(int[][] matrix) {
        this.matrix = matrix.clone();
        return this;
    }

    public InputBuilder fitnessToFind(Integer fitnessToFind) {
        this.fitnessToFind = fitnessToFind;
        return this;
    }

    public InputBuilder firstPopulation(Generation firstPopulation) {
        this.firstGeneration = firstPopulation;
        return this;
    }

    public Input build() {
        if (matrix == null) {
            MatricesGeneratorV2 matricesGenerator = new MatricesGeneratorV2(100);
            matrix = matricesGenerator.getMatrix();
            fitnessToFind = matricesGenerator.getFitness();
        }
        final Input input = new Input(matrix);
        input.setGeneration(firstGeneration);
        input.setFitnessToFind(fitnessToFind);
        return input;
    }
}
