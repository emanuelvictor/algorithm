package algorithms.heuristic.memetic.structured;

import algorithms.heuristic.Algorithm;
import algorithms.heuristic.Input;
import algorithms.heuristic.Output;

import java.time.Duration;
import java.time.LocalDateTime;

import static algorithms.heuristic.Utils.*;

public class OldStructuredMemetic implements Algorithm {

    private final LocalDateTime initDate = LocalDateTime.now();
    private final int[][] matrix;
    private final int[][] generation;
    private final int fitnessToFind;

    private int[] melhor;


    public OldStructuredMemetic(final Input input) {
        this.matrix = input.getMatrix();
        this.fitnessToFind = input.getFitnessToFind();
        this.generation = input.getFirstGeneration();
    }

    @Override
    public Output execute() {
        return execute(generation);
    }

    public Output execute(int[][] populacao) {

        melhor = sort(populacao, calculateFitness(populacao, matrix))[0];

        //Variável auxiliar para guardar o melhor da população anterior anterior.
        int melhorAnterior = calculateFitness(melhor, matrix);

        while (!melhorGlobal(populacao, matrix, fitnessToFind)) {

            populacao = saltar(populacao, matrix);

            populacao = buscaLocal(populacao, matrix);

            //Variável auxiliar para não duplicar o processo de cálculo do fitness
            int melhorAtual = calculateFitness(melhor, matrix);

            //TODO gambiarrona para elitizar o melhor e o algorithm não desaprender
            if (calculateFitness(sort(populacao, calculateFitness(populacao, matrix))[0], matrix) <= melhorAtual) {
                populacao = sort(populacao, calculateFitness(populacao, matrix));
                for (int i = 0; i < populacao[0].length; i++) {
                    melhor[i] = populacao[0][i];
                }
            } else {
                populacao = sort(populacao, calculateFitness(populacao, matrix));
                for (int i = 0; i < populacao[0].length; i++) {
                    populacao[0][i] = melhor[i];
                }
            }
            //Se o fitness do melhor indivíduo encontrado for melhor que o anterior, imprime-o
            if (melhorAtual < melhorAnterior) {
                melhorAnterior = calculateFitness(melhor, matrix);
//                imprimir(null, ordenar(populacao, calcularFitness(populacao, matrix))[0], matrix);
//                System.out.println(" = " + calcularFitness(ordenar(populacao, calcularFitness(populacao, MATRIZ_ADJACENTE))[0], MATRIZ_ADJACENTE));
            }

        }

//        imprimir(ordenar(populacao, calcularFitness(populacao, matrix))[0], matrix);
//        imprimir(populacao[0]);
//        System.out.print(" "+calcularFitness(populacao[0], MATRIZ_ADJACENTE));
//        imprimir("oldMemetic done ", sort(populacao, calculateFitness(populacao, matrix))[0], matrix);

        Duration duration = Duration.between(initDate, LocalDateTime.now());
        return new Output(duration);
    }

    public static int[][] saltar(int[][] populacao, int[][] MATRIZ_ADJACENTE) {
        int[] melhor = sort(populacao, calculateFitness(populacao, MATRIZ_ADJACENTE))[0];
        populacao = sort(generateRandomPopulation(populacao.length, MATRIZ_ADJACENTE), calculateFitness(populacao, MATRIZ_ADJACENTE));
        populacao[populacao.length - 1] = melhor;
//        melhor = rotate(melhor);
        return sort(populacao, calculateFitness(populacao, MATRIZ_ADJACENTE));
    }

    //TODO
    public static int[][] buscaLocal(int[][] populacao, int[][] MATRIZ_ADJACENTE) {

        final int[] melhor = populacao[0];
        //Percorrendo toda a população
        for (int n = 0; n < populacao.length; n++) {
            for (int i = 1; i < populacao.length; i++) {
                //Percorrendo o mellhor
                for (int c = 0; c < melhor.length - 1; c++) {
                    //Percorrendo o indivíduo da população
                    final int custoA = calculateFitness(melhor[c], melhor[c + 1], MATRIZ_ADJACENTE);
                    for (int j = 0; j < populacao[i].length - 1; j++) {
                        if (populacao[i][j] == melhor[c]) {
                            final int custoB = calculateFitness(populacao[i][j], populacao[i][j + 1], MATRIZ_ADJACENTE);
                            if (custoA < custoB) {
                                for (int k = 0; k < populacao[i].length; k++) {
                                    if (populacao[i][k] == melhor[c + 1]) {
                                        populacao[i][k] = populacao[i][j + 1];
                                        break;
                                    }
                                }
                                populacao[i][j + 1] = melhor[c + 1];
                            } else if (custoB < custoA) {
                                for (int k = 0; k < melhor.length; k++) {
                                    if (melhor[k] == populacao[i][j + 1]) {
                                        melhor[k] = melhor[c + 1];
                                        break;
                                    }
                                }
                                melhor[c + 1] = populacao[i][j + 1];
                            }
                            break;
                        }
                    }
                }
            }
        }
        return sort(populacao, calculateFitness(populacao, MATRIZ_ADJACENTE));
    }

//    public static boolean converge(int[][] populacao, int [][] MATRIZ_ADJACENTE) {
//        int[] fitness = calcularFitness(populacao, MATRIZ_ADJACENTE);
//        for (int i = 1; i < fitness.length; i++) {
//            if (fitness[i]!=fitness[i-1]) return false;
//        }
//        System.out.print("Convergiu");
//        return true;
//    }

    private static boolean melhorGlobal(int[][] populacao, int[][] MATRIZ_ADJACENTE, int FITNESS) {
        return calculateFitness(populacao, MATRIZ_ADJACENTE)[0] <= FITNESS;
    }

//    private static int[][] generateRandomPopulation(int sizeOfPopulation, int[][] matrix) {
//
//        int[][] routes = new int[sizeOfPopulation][matrix.length];
//
//        for (int k = 0; k < sizeOfPopulation; k++) {
//
//            int[] auxRoute = new int[matrix.length];
//            for (int i = 0; i < matrix.length; i++) {
//                auxRoute[i] = i;
//            }
//
//            int[] route = new int[auxRoute.length];
//
//            route = shuffle(route.length, route, auxRoute);
//
//            if (!isContained(routes, route)) {
//                routes[k] = route;
//            } else {
//                k--;
//            }
//        }
//
//        return sort(routes, calculateFitness(routes, matrix));
//    }

//    private static int[] shuffle(int tam, int rota[], int rotaAux[]) {
//        // Embaralha
//        for (int i = 0; i < tam; i++) {
//            int r;
//            do {
//                r = new Random().nextInt(tam - i);
//            } while (r == i);
//
//            rota[i] = rotaAux[r];
//            rotaAux = preencheVetorSemOR(rotaAux, r);
//        }
//        return rota;
//    }

//    private static int[] preencheVetorSemOR(final int[] vetorDeIndices, final int r) {
//        int[] vetAux = new int[vetorDeIndices.length - 1];
//        int cont = 0;
//        for (int j = 0; j < vetorDeIndices.length; j++) {
//            if (j == r) {
//                continue;
//            }
//            vetAux[cont] = vetorDeIndices[j];
//            cont++;
//        }
//        return vetAux;
//    }
//
//    private static int[] calculateFitness(int[][] populacao, int[][] MATRIZ_ADJACENTE) {
//        int[] fitness = new int[populacao.length];
//        for (int i = 0; i < populacao.length; i++) {
//            fitness[i] = calculateFitness(populacao[i], MATRIZ_ADJACENTE);
//        }
//        return fitness;
//    }
//
//    // TODO it's wrong
//    public static int calculateFitness(int[] individuo, int[][] MATRIZ_ADJACENTE) {
//        int fitness = 0;
//        for (int j = 0; j < individuo.length; j++) {
//            fitness = fitness + MATRIZ_ADJACENTE[individuo[j]][individuo[j == individuo.length - 1 ? 0 : j + 1]];
//        }
//        return fitness;
//    }
//
//    public static int calculateFitness(int cidade1, int cidade2, int[][] MATRIZ_ADJACENTE) {
//        return MATRIZ_ADJACENTE[cidade1][cidade2];
//    }
//
//    private static int[][] sort(int[][] populacao, int[] fitness) {
//        // ordenando
//        int i, i2;
//        for (i = 0; i < populacao.length; i++) {
//            for (i2 = i; i2 < populacao.length; i2++) {
//                if (fitness[i] > fitness[i2]) {
//                    int vTmp = fitness[i];
//                    fitness[i] = fitness[i2];
//                    fitness[i2] = vTmp;
//
//                    int[] vvTmp = populacao[i];
//                    populacao[i] = populacao[i2];
//                    populacao[i2] = vvTmp;
//                }
//            }
//        }
//        return populacao;
//    }
//
//    private static boolean isContained(int[][] populacao, int[] individuo) {
//        for (int[] auxiliar : populacao) {
//            if (Arrays.equals(auxiliar, individuo)) {
//                return true;
//            }
//        }
//        return false;
//    }


    private void imprimir(final String concluded, int[] rota, int[][] matrix) {
        if (concluded != null) System.out.print(concluded);
        for (int j : rota) {
            System.out.print(" " + j);
        }
        System.out.println(" = " + calculateFitness(rota, matrix) + " fitness a ser encontrado = " + fitnessToFind);
    }

//    private static void imprimir(int[][] populacao, int[] fitness, int[][] MATRIZ_ADJACENTE) {
//        for (int j = 0; j < populacao.length; j++) {
//            System.out.print("Rota " + j + " = ");
//            for (int i = 0; i < MATRIZ_ADJACENTE.length; i++) {
//                System.out.print(" " + populacao[j][i] + " ");
//            }
//            System.out.println(" fitness = " + fitness[j]);
//        }
//    }
//
//    private static void imprimir(int[] rota) {
//        for (int j : rota) {
//            System.out.print(" " + j);
//        }
//    }
}