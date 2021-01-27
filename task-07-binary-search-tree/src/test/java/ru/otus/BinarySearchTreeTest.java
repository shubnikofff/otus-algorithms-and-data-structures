package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ru.otus.TestHelper.checkIfKeyExists;
import static ru.otus.TestHelper.walkTree;

@DisplayName("Binary Search Tree")
class BinarySearchTreeTest {

    private BinarySearchTree tree;

    @BeforeEach
    void setUp() {
        tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(8);
        tree.insert(4);
        tree.insert(13);
        tree.insert(6);
    }

    @Test
    @DisplayName("Insert left")
    void insert_left() {
        final int key = 2;
        tree.insert(key);

        assertTrue(checkIfKeyExists(tree.root, key));
        walkTree(tree.root, TestHelper::checkIfLeftChildKeyLessThanRightChildKey);
    }

    @Test
    @DisplayName("Insert right")
    void insert_right() {
        final int key = 9;
        tree.insert(key);

        assertTrue(checkIfKeyExists(tree.root, key));
        walkTree(tree.root, TestHelper::checkIfLeftChildKeyLessThanRightChildKey);
    }

    @Test
    @DisplayName("Insert existing")
    void insert_existing() {
        assertThrows(IllegalArgumentException.class, () -> tree.insert(8));
    }

    @Test
    @DisplayName("Remove when no children")
    void remove_when_no_children() {
        final int key = 6;

        assertTrue(checkIfKeyExists(tree.root, key));
        tree.remove(key);
        assertFalse(checkIfKeyExists(tree.root, key));
        walkTree(tree.root, TestHelper::checkIfLeftChildKeyLessThanRightChildKey);
    }

    @Test
    @DisplayName("Remove when one child")
    void remove_when_one_child() {
        final int key = 8;

        assertTrue(checkIfKeyExists(tree.root, key));
        tree.remove(key);
        assertFalse(checkIfKeyExists(tree.root, key));
        walkTree(tree.root, TestHelper::checkIfLeftChildKeyLessThanRightChildKey);
    }

    @Test
    @DisplayName("Remove when two children")
    void remove_when_two_children() {
        final int key = 5;

        assertTrue(checkIfKeyExists(tree.root, key));
        tree.remove(key);
        assertFalse(checkIfKeyExists(tree.root, key));
        walkTree(tree.root, TestHelper::checkIfLeftChildKeyLessThanRightChildKey);
    }

    @Test
    @DisplayName("Search")
    void search() {
        final int key = 100;

        assertFalse(tree.search(key));
        tree.insert(key);
        assertTrue(tree.search(key));
    }
}
