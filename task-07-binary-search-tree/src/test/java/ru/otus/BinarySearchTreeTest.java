package ru.otus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void insert() {
        final BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(8);
        tree.insert(4);
        tree.insert(13);

		final Node root = tree.getRoot();
        assertEquals(root.getValue(), 10);
        assertEquals(13, root.getRight().getValue());
        assertEquals(5, root.getLeft().getValue());
        assertEquals(4, root.getLeft().getLeft().getValue());
        assertEquals(8, root.getLeft().getRight().getValue());

        assertThrows(IllegalArgumentException.class, () -> {
            tree.insert(8);
        });
    }

    @Test
    void remove() {
    }

    @Test
    void search() {
    }
}
