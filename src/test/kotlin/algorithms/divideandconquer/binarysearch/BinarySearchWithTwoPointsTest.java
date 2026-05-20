package algorithms.divideandconquer.binarysearch;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BinarySearchWithTwoPointsTest {

    @Test
    void mustFind7TermInArrayWith10Size() {
        final var arrayToSearch = createArray(10);
        final var binaryTreeSearchWithTwoPoints = new BinarySearchWithTwoPoints(arrayToSearch);

        assertThat(binaryTreeSearchWithTwoPoints.search(7)).isEqualTo(7);
        System.out.println(binaryTreeSearchWithTwoPoints.getSteps());
    }

    @Test
    void mustFind8TermInArrayWith10Size() {
        final var arrayToSearch = createArray(10);
        final var binaryTreeSearchWithTwoPoints = new BinarySearchWithTwoPoints(arrayToSearch);

        assertThat(binaryTreeSearchWithTwoPoints.search(8)).isEqualTo(8);
        System.out.println(binaryTreeSearchWithTwoPoints.getSteps());
    }

    @Test
    void mustFind1TermInArrayWith10Size() {
        final var arrayToSearch = createArray(10);
        final var binaryTreeSearchWithTwoPoints = new BinarySearchWithTwoPoints(arrayToSearch);

        assertThat(binaryTreeSearchWithTwoPoints.search(1)).isEqualTo(1);
        System.out.println(binaryTreeSearchWithTwoPoints.getSteps());
    }

    @Test
    void mustFind10TermInArrayWith10Size() {
        final var arrayToSearch = createArray(10);
        final var binaryTreeSearchWithTwoPoints = new BinarySearchWithTwoPoints(arrayToSearch);

        assertThat(binaryTreeSearchWithTwoPoints.search(1)).isEqualTo(1);
        System.out.println(binaryTreeSearchWithTwoPoints.getSteps());
    }

    @Test
    void mustFind7TermInArrayWith15Size() {
        final var arrayToSearch = createArray(15);
        final var binaryTreeSearchWithTwoPoints = new BinarySearchWithTwoPoints(arrayToSearch);

        assertThat(binaryTreeSearchWithTwoPoints.search(7)).isEqualTo(7);
        System.out.println(binaryTreeSearchWithTwoPoints.getSteps());
    }

    @Test
    void mustFind7TermInArrayWith13Size() {
        final var arrayToSearch = createArray(13);
        final var binaryTreeSearchWithTwoPoints = new BinarySearchWithTwoPoints(arrayToSearch);

        assertThat(binaryTreeSearchWithTwoPoints.search(7)).isEqualTo(7);
        System.out.println(binaryTreeSearchWithTwoPoints.getSteps());
    }

    @Test
    void mustFind7TermInArrayWith14Size() {
        final var arrayToSearch = createArray(14);
        final var binaryTreeSearchWithTwoPoints = new BinarySearchWithTwoPoints(arrayToSearch);

        assertThat(binaryTreeSearchWithTwoPoints.search(7)).isEqualTo(7);
        System.out.println(binaryTreeSearchWithTwoPoints.getSteps());
    }

    @Test
    void cantFindTermGreaterThanArray() {
        final var arrayToSearch = createArray(14);
        final var binaryTreeSearchWithTwoPoints = new BinarySearchWithTwoPoints(arrayToSearch);

        assertThat(binaryTreeSearchWithTwoPoints.search(90)).isEqualTo(-1);
        System.out.println(binaryTreeSearchWithTwoPoints.getSteps());
    }

    @Test
    void cantFindTermLessThanArray() {
        final var arrayToSearch = createArray(14);
        final var binaryTreeSearchWithTwoPoints = new BinarySearchWithTwoPoints(arrayToSearch);

        assertThat(binaryTreeSearchWithTwoPoints.search(-5)).isEqualTo(-1);
        System.out.println(binaryTreeSearchWithTwoPoints.getSteps());
    }

    private static int[] createArray(int sizeOfArray) {
        final var array = new int[sizeOfArray];
        for (int i = 1; i <= sizeOfArray - 1; i++) {
            array[i] = i;
        }
        return array;
    }
}
