package algorithms.invertlinkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MyLinkedListTest {

    private MyLinkedList list;

    @BeforeEach
    void setUp() {
        list = new MyLinkedList();
    }

    @Test
    void shouldAddFirstNode() {
        final var valueExpected = 10;
        list.add(valueExpected);

        final var firstValue = list.getFirst();

        assertThat(firstValue).isEqualTo(valueExpected);
    }

    @Test
    void shouldAnyNodes() {
        final var firstValueExpected = 10;
        final var secondValueExpected = 20;
        final var thirtyValueExpected = 30;
        final var fortyValueExpected = 40;
        list.add(firstValueExpected);
        list.add(secondValueExpected);
        list.add(thirtyValueExpected);
        list.add(fortyValueExpected);

        final var firstValue = list.get(1);
        final var secondValue = list.get(2);
        final var thirtyValue = list.get(3);
        final var fortyValue = list.get(4);

        assertThat(firstValue).isEqualTo(firstValueExpected);
        assertThat(secondValue).isEqualTo(secondValueExpected);
        assertThat(thirtyValue).isEqualTo(thirtyValueExpected);
        assertThat(fortyValue).isEqualTo(fortyValueExpected);
    }

    @Test
    void shouldRemoveThirtyNode() {
        final var firstValueExpected = 10;
        final var secondValueExpected = 20;
        final var thirtyValueExpected = 30;
        final var fortyValueExpected = 40;
        list.add(firstValueExpected);
        list.add(secondValueExpected);
        list.add(thirtyValueExpected);
        list.add(fortyValueExpected);

        list.remove(3);

        assertThat(list.get(3)).isEqualTo(fortyValueExpected);
    }

    @Test
    void shouldRemoveFirstNode() {
        final var firstValueExpected = 10;
        final var secondValueExpected = 20;
        final var thirtyValueExpected = 30;
        final var fortyValueExpected = 40;
        list.add(firstValueExpected);
        list.add(secondValueExpected);
        list.add(thirtyValueExpected);
        list.add(fortyValueExpected);

        list.remove(1);

        assertThat(list.getFirst()).isEqualTo(secondValueExpected);
    }

    @Test
    void shouldRemoveLastNode() {
        final var firstValueExpected = 10;
        final var secondValueExpected = 20;
        final var thirtyValueExpected = 30;
        final var fortyValueExpected = 40;
        list.add(firstValueExpected);
        list.add(secondValueExpected);
        list.add(thirtyValueExpected);
        list.add(fortyValueExpected);

        list.remove(4);

        assertThat(list.get(3)).usingRecursiveComparison().isEqualTo(thirtyValueExpected);
    }

    @Test
    void shouldInvertList() {
        final var firstValueExpected = 10;
        final var secondValueExpected = 20;
        final var thirtyValueExpected = 30;
        final var fortyValueExpected = 40;
        list.add(firstValueExpected);
        list.add(secondValueExpected);
        list.add(thirtyValueExpected);
        list.add(fortyValueExpected);

        list.invert();

        assertThat(list.getFirst()).isEqualTo(fortyValueExpected);
        assertThat(list.get(2)).isEqualTo(thirtyValueExpected);
        assertThat(list.get(3)).isEqualTo(secondValueExpected);
        assertThat(list.get(4)).isEqualTo(firstValueExpected);
    }
}