package ru.otus.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.otus.bst.TestHelper.checkIfKeyExists;
import static ru.otus.bst.TestHelper.walkTree;

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
	@DisplayName("Insert")
	void insert() {
		final int key = 11;
		tree.insert(key);

		assertTrue(checkIfKeyExists(tree.getRoot(), key));
		walkTree(tree.getRoot(), TestHelper::checkIfLeftChildKeyLessThanRightChildKey);
		walkTree(tree.getRoot(), TestHelper::checkIfPriorityGraterThanChildrenPriority);
	}

	@Test
	@DisplayName("Remove")
	void remove() {
		final int key = 10;

		assertTrue(checkIfKeyExists(tree.getRoot(), key));
		tree.remove(key);
		assertFalse(checkIfKeyExists(tree.getRoot(), key));
		walkTree(tree.getRoot(), TestHelper::checkIfLeftChildKeyLessThanRightChildKey);
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
