import algorithms.heuristic.memetic.oo.Generation
import algorithms.heuristic.memetic.oo.Individual
import algorithms.heuristic.memetic.oo.Memetic
import algorithms.heuristic.matrix.Input
import algorithms.heuristic.matrix.builder.MatricesGeneratorV2

fun main() {
//    val matrix = THIRTY_POINTS_MATRIX
//    val firstPopulation = Generation(MatricesGeneratorV2.generateRandomPopulation(matrix, 5).map { Individual(it, matrix) }.toTypedArray());
//     val fitness = MatricesGeneratorV2.extractTheBestFitnessFromContorlledMatrix(matrix)
//
//    val input = Input.builder()
//        .matrix(matrix)
//        .firstPopulation(firstPopulation) //  MENOR O TAMANHO DA POPULAÇÃO MAIS GERAÇÕES, MENOR PROCESSAMENTO ENTRE AS GERAÇÕES, MENOR O TEMPO
//        .fitnessToFind(fitness)
//        .build()
//
//    val memetic = Memetic(input)
//    memetic.execute()

//    val matrix = MatricesGeneratorV2.generateControlledMatrixMatrix(50);
//    val firstPopulation = Generation(MatricesGeneratorV2.generateRandomPopulation(matrix, 5).map { Individual(it, matrix) }.toTypedArray());
//    val fitness = MatricesGeneratorV2.extractTheBestFitnessFromContorlledMatrix(matrix)
//
//    val input = Input.builder()
//        .matrix(matrix)
//        .firstPopulation(firstPopulation) //  MENOR O TAMANHO DA POPULAÇÃO MAIS GERAÇÕES, MENOR PROCESSAMENTO ENTRE AS GERAÇÕES, MENOR O TEMPO
//        .fitnessToFind(fitness)
//        .build()
//
//    val memetic = Memetic(input)
//    memetic.execute()

    val matrix = MatricesGeneratorV2.generateControlledMatrixMatrix(80)
    val firstPopulation = Generation(
        MatricesGeneratorV2.generateRandomPopulation(
            matrix,
            20
        ).map { Individual(it, matrix) }.toTypedArray()
    );
    val fitness = MatricesGeneratorV2.extractTheBestFitnessFromContorlledMatrix(matrix)

    val input = Input.builder()
        .matrix(matrix)
        .firstPopulation(firstPopulation) //  MENOR O TAMANHO DA POPULAÇÃO MAIS GERAÇÕES, MENOR PROCESSAMENTO ENTRE AS GERAÇÕES, MENOR O TEMPO
        .fitnessToFind(fitness)
        .build()

    val memetic = Memetic(input)
    memetic.execute()

}