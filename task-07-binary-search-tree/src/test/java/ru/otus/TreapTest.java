package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.factory.RegistrableNodeFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TreapTest {

	private Map<Integer, Node> nodeRegistry;

	private Treap tree;

	@BeforeEach
	void setUp() {
		nodeRegistry = new HashMap<>();
		final RegistrableNodeFactory nodeFactory = new RegistrableNodeFactory(nodeRegistry);
		tree = new Treap(nodeFactory);
	}

	@Test
	void insert() {
		tree.insert(10);
		tree.insert(9);
		tree.insert(8);
		tree.insert(7);
	}

	@Test
	void remove() {
	}
}