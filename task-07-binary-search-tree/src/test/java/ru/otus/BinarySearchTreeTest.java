package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.factory.RegistrableNodeFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Binary Search Tree")
class BinarySearchTreeTest {

    private Map<Integer, Node> nodeRegistry;

    private BinarySearchTree tree;

    @BeforeEach
    void setUp() {
        nodeRegistry = new HashMap<>();
        final RegistrableNodeFactory nodeFactory = new RegistrableNodeFactory(nodeRegistry);
        tree = new BinarySearchTree(nodeFactory);

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
        assertNull(nodeRegistry.get(4).left);
        tree.insert(2);
        assertEquals(2, nodeRegistry.get(4).left.value);
    }

    @Test
    @DisplayName("Insert right")
    void insert_right() {
        assertNull(nodeRegistry.get(8).right);
        tree.insert(9);
        assertEquals(9, nodeRegistry.get(8).right.value);
    }

    @Test
    @DisplayName("Insert existing")
    void insert_existing() {
        assertThrows(IllegalArgumentException.class, () -> tree.insert(8));
    }

    @Test
    @DisplayName("Remove when no children")
    void remove_when_no_children() {
        assertEquals(6, nodeRegistry.get(8).left.value);
        tree.remove(6);
        assertNull(nodeRegistry.get(8).left);
    }

    @Test
    @DisplayName("Remove when one child")
    void remove_when_one_child() {
        assertEquals(8, nodeRegistry.get(5).right.value);
        tree.remove(8);
        assertEquals(6, nodeRegistry.get(5).right.value);
    }

    @Test
    @DisplayName("Remove when two children")
    void remove_when_two_children() {
        assertEquals(5, nodeRegistry.get(10).left.value);
        tree.remove(5);
        assertEquals(6, nodeRegistry.get(10).left.value);
        assertNull(nodeRegistry.get(8).left);
    }

    @Test
    @DisplayName("Search")
    void search() {
        assertTrue(tree.search(4));
        assertFalse(tree.search(100));
    }
}
