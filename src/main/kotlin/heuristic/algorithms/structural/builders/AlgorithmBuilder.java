package heuristic.algorithms.structural.builders;//package heuristic.algorithm.builders;
//
//
//import heuristic.matrix.builder.MatrixGenerator;
//// TODO não vai ser necessário
//public class AlgorithmBuilder<B, T> {
//
//    private int[][] matrix, firstPopulation;
//    private int fitnessToFind;
//
//    public AlgorithmBuilder() {
//        matrix = MatrixGenerator.getInstance().getMatrix(); // TODO get default matrix
//        firstPopulation = null; // TODO get default first population
//        fitnessToFind = MatrixGenerator.getInstance().getFitness(); // TODO get default matrix
//    }
//
//    public B matrix(int[][] matrix) {
//        this.matrix = matrix;
//        return (B) this;
//    }
//
//    public B firstPopulation(int[][] firstPopulation) {
//        this.firstPopulation = firstPopulation;
//        return (B) this;
//    }
//
//    public B fitnessToFind(int fitnessToFind) {
//        this.fitnessToFind = fitnessToFind;
//        return (B) this;
//    }
//
//}
