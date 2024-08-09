package algorithms.heuristic.memetic.oo.models;

public class Generation {

    private Individual[] individuals;

    public Generation(int[][] individuals, final int[][] matrix) {
       final Individual[] tempIndividuals = new Individual[individuals.length];
        for (int i = 0; i < tempIndividuals.length; i++) {
            tempIndividuals[i] = new Individual(individuals[i].clone(), matrix);
        }
        this.individuals = sort(tempIndividuals);
    }

    public Generation(Individual[] individuals) {
        this.individuals = sort(individuals);
    }

    public Individual[] getIndividuals() {
        return individuals;
    }

    public Individual getBestIndividual() {
        return individuals[0];
    }

    public int[] getChromosomesFromBestIndividual() {
        return individuals[0].getChromosomes();
    }

    public int getBestFitness() {
        return individuals[0].getFitness();
    }

    public void setBestIndividual(Individual currentBestIndividual) {
        this.individuals[0] = currentBestIndividual; // TODO we must use insertion sort here maybe?
        this.individuals = sort(individuals);
    }

    // I don't use java stream API. And that's it.
    private static Individual[] sort(final Individual[] individuals) {
        int i, i2;
        for (i = 0; i < individuals.length; i++) {
            for (i2 = i; i2 < individuals.length; i2++) {
                if (individuals[i].getFitness() > individuals[i2].getFitness()) {
                    Individual vvTmp = individuals[i];
                    individuals[i] = individuals[i2];
                    individuals[i2] = vvTmp;
                }
            }
        }
        return individuals;
    }
}
