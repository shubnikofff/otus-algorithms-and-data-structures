package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.factory.RegistrableNodeFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

	private RegistrableNodeFactory nodeFactory;

	private Map<Integer, Node> nodeRegistry;

	@BeforeEach
	void setUp() {
		nodeRegistry = new HashMap<>();
		nodeFactory = new RegistrableNodeFactory(nodeRegistry);
	}

	@Test
	void insert() {
		final BinarySearchTree tree = new BinarySearchTree(nodeFactory);
		tree.insert(10);
		tree.insert(5);
		tree.insert(8);
		tree.insert(4);
		tree.insert(13);

		assertEquals(10, nodeRegistry.get(10).getValue());
		assertEquals(13, nodeRegistry.get(10).getRight().getValue());
		assertEquals(5, nodeRegistry.get(10).getLeft().getValue());
		assertEquals(4, nodeRegistry.get(5).getLeft().getValue());
		assertEquals(8, nodeRegistry.get(5).getRight().getValue());

		assertThrows(IllegalArgumentException.class, () -> tree.insert(8));
	}

	@Test
	void remove() {
	}

	@Test
	void search() {
	}
}
