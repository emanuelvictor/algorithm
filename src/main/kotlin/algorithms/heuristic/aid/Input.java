package algorithms.heuristic.aid;

public interface Input {

     int[][] getMatrix();

     Integer getFitnessToFind();

    void setFitnessToFind(Integer fitnessToFind);

     int[][] getFirstGeneration();

     void setFirstGeneration(int[][] firstGeneration);

     Integer getSizeOfFirstGeneration();

     void setSizeOfFirstGeneration(Integer sizeOfFirstGeneration);

}
