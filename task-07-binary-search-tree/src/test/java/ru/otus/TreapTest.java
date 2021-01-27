package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.otus.TestHelper.walkTree;

class TreapTest {

	private Treap tree;

	@BeforeEach
	void setUp() {
		tree = new Treap();
		tree.insert(10);
		tree.insert(9);
		tree.insert(8);
		tree.insert(7);
	}

	@Test
	void insert() {
		walkTree(tree.root, TestHelper::checkIfLeftChildKeyLessThanRightChildKey);
		walkTree(tree.root, TestHelper::checkIfPriorityGraterThanChildrenPriority);
	}

	@Test
	void remove() {
		tree.remove(9);
		assertFalse(tree.search(9));
	}

	@Test
	@DisplayName("Search")
	void search() {
		assertFalse(tree.search(100));
		tree.insert(100);
		assertTrue(tree.search(100));
	}
}
