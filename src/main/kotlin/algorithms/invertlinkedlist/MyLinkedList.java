package algorithms.invertlinkedlist;

public class MyLinkedList {

    private Node first;

    void add(int value) {
        add(new Node(value));
    }

    void add(Node node) {
        if (first == null) {
            first = node;
            return;
        }
        var currentNode = first;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
    }

    void remove(int index) {
        if (first == null)
            return;
        if (index == 1) {
            first = first.next;
            return;
        }
        var currentNode = first;
        for (int i = 0; i < index - 2; i++) {
            currentNode = currentNode.next;
        }
        if (currentNode.next != null)
            currentNode.next = currentNode.next.next;
    }

    int getFirst() {
        return first.value;
    }

    int get(int index) {
        var currentNode = first;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }

    void invert() {
        Node newFirst = null;
        Node head = first;
        while (head != null) {
            final var nextNode = head.next;
            head.next = newFirst;
            newFirst = head;
            head = nextNode;
        }
        this.first = newFirst;
    }
}
