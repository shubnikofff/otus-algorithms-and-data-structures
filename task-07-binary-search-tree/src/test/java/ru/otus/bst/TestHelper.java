package ru.otus.bst;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TestHelper {

    static void walkTree(Node node, Consumer<Node> consumer) {

        if (node == null) {
            return;
        }

        consumer.accept(node);

        walkTree(node.left, consumer);
        walkTree(node.right, consumer);
    }

    static void checkIfLeftChildKeyLessThanRightChildKey(Node node) {
        if (node.left == null || node.right == null) {
            return;
        }

        assertTrue(node.left.key < node.right.key);
    }

    static boolean checkIfKeyExists(Node node, int key) {
        if (node == null) {
            return false;
        }

        if (key == node.key) {
            return true;
        }

        return key < node.key ? checkIfKeyExists(node.left, key) : checkIfKeyExists(node.right, key);
    }

    static void checkBalance(Node node) {
        final int leftHeight = node.left != null ? node.left.height : 0;
        final int rightHeight = node.right != null ? node.right.height : 0;

        assertTrue(Math.abs(rightHeight - leftHeight) <= 1);
    }

    static void checkIfPriorityGraterThanChildrenPriority(Node node) {
        if (node.left != null) {
            assertTrue(node.priority > node.left.priority);
        }

        if (node.right != null) {
            assertTrue(node.priority > node.right.priority);
        }
    }
}
