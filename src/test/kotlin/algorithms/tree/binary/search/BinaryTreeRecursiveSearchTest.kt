package algorithms.tree.binary.search

import algorithms.tree.binary.search.BinaryTreeRecursiveSearch.TERM_CANNOT_BE_FOUND_MESSAGE_ERROR
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BinaryTreeRecursiveSearchTest {

    @ParameterizedTest
    @MethodSource("getArraysToSearch")
    fun `Must search a term from array`(array: IntArray) {
        val tree = BinaryTreeRecursiveSearch(array)

        for (i in array.indices) {
            assertThat(tree.search(i + 1)).isEqualTo(i);
        }
    }

    @ParameterizedTest
    @MethodSource("getArraysToSearch")
    fun `Must return an exception if cannot find a term`(array: IntArray) {
        val tree = BinaryTreeRecursiveSearch(array)

        for (i in array.indices) {
            val exception: Exception = assertThrows(BinaryTreeRecursiveSearch.TermCannotBeFound::class.java) {
                tree.search(i + 1000)
            }

            assertThat(exception).isInstanceOf(BinaryTreeRecursiveSearch.TermCannotBeFound::class.java)
                .hasMessageContaining(String.format(TERM_CANNOT_BE_FOUND_MESSAGE_ERROR, i + 1000))
        }
    }

    private fun getArraysToSearch(): Stream<Arguments> {
        val evenArray = IntArray(90)
        val oddArray = IntArray(95)
        populateArray(oddArray, evenArray)
        return Stream.of(
            Arguments.arguments(evenArray),
            Arguments.arguments(oddArray),
        )
    }

    private fun populateArray(vararg arrays: IntArray) {
        arrays.forEach { array ->
            for (i in array.indices)
                array[i] = i + 1
        }
    }
}
