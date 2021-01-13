package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.factory.RegistrableNodeFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AVLTreeTest {

    private Map<Integer, Node> nodeRegistry;

    private AVLTree tree;

    @BeforeEach
    void setUp() {
        nodeRegistry = new HashMap<>();
        final RegistrableNodeFactory nodeFactory = new RegistrableNodeFactory(nodeRegistry);
        tree = new AVLTree(nodeFactory);
    }

    @Test
    @DisplayName("Insert with small right rotation")
    void inser_with_small_right_rotation() {
        tree.insert(10);
        tree.insert(9);
        tree.insert(8);

        assertEquals(2, nodeRegistry.get(9).height);
        assertEquals(nodeRegistry.get(8), nodeRegistry.get(9).left);
        assertEquals(nodeRegistry.get(10), nodeRegistry.get(9).right);
        assertEquals(1, nodeRegistry.get(9).left.height);
        assertEquals(1, nodeRegistry.get(9).right.height);
    }

    @Test
    @DisplayName("Insert with small left rotation")
    void inser_with_small_left_rotation() {
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);

        assertEquals(2, nodeRegistry.get(2).height);
        assertEquals(nodeRegistry.get(1), nodeRegistry.get(2).left);
        assertEquals(nodeRegistry.get(3), nodeRegistry.get(2).right);
        assertEquals(1, nodeRegistry.get(2).left.height);
        assertEquals(1, nodeRegistry.get(2).right.height);
    }
}