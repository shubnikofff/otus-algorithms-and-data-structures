package ru.otus.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.otus.bst.TestHelper.walkTree;

class AVLTreeTest {

    private AVLTree tree;

    @BeforeEach
    void setUp() {
        tree = new AVLTree();
    }

    @Test
    @DisplayName("Small right rotation")
    void smallRightRotation() {
        tree.insert(10);
        tree.insert(11);
        tree.insert(9);
        tree.insert(8);
        tree.insert(7);

        walkTree(tree.root, TestHelper::checkIfLeftChildKeyLessThanRightChildKey);
        walkTree(tree.root, TestHelper::checkBalance);
    }

    @Test
    @DisplayName("Small left rotation")
    void smallLeftRotation() {
        tree.insert(10);
        tree.insert(9);
        tree.insert(11);
        tree.insert(12);
        tree.insert(13);

        walkTree(tree.root, TestHelper::checkIfLeftChildKeyLessThanRightChildKey);
        walkTree(tree.root, TestHelper::checkBalance);
    }

    @Test
    @DisplayName("Big right rotation")
    void bigRightRotation() {
        tree.insert(10);
        tree.insert(11);
        tree.insert(8);
        tree.insert(7);
        tree.insert(6);
        tree.insert(9);

        walkTree(tree.root, TestHelper::checkIfLeftChildKeyLessThanRightChildKey);
        walkTree(tree.root, TestHelper::checkBalance);
    }

    @Test
    @DisplayName("Big left rotation")
    void bigLeftRotation() {
        tree.insert(10);
        tree.insert(9);
        tree.insert(12);
        tree.insert(13);
        tree.insert(14);
        tree.insert(11);

        walkTree(tree.root, TestHelper::checkIfLeftChildKeyLessThanRightChildKey);
        walkTree(tree.root, TestHelper::checkBalance);
    }

    @Test
    @DisplayName("Search")
    void search() {
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        assertTrue(tree.search(5));
        assertFalse(tree.search(100));
    }
}
