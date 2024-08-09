import algorithms.heuristic.Input
import algorithms.heuristic.matrix.MatricesGeneratorV2
import algorithms.heuristic.memetic.oo.OOMemetic

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
    val firstPopulation = MatricesGeneratorV2.generateRandomPopulation(matrix, 2)
    val fitness = MatricesGeneratorV2.extractTheBestFitnessFromControlledMatrix(matrix)

    val ooMemeticInput = Input.builder()
        .matrix(matrix)
        .firstGeneration(firstPopulation) //  MENOR O TAMANHO DA POPULAÇÃO MAIS GERAÇÕES, MENOR PROCESSAMENTO ENTRE AS GERAÇÕES, MENOR O TEMPO
        .fitnessToFind(fitness)
        .build()

    val ooMemetic = OOMemetic(ooMemeticInput)
    ooMemetic.execute()

}