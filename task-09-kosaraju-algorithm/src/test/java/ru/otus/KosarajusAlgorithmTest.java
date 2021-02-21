package ru.otus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KosarajusAlgorithmTest {

	@Test
	void findStronglyConnectedComponent() {
		final int[][] graph = {{1}, {2, 4, 5}, {3, 6}, {2, 7}, {0, 5}, {6}, {5}, {3, 6}};
		final int[][] expectedResult = {{5, 6}, {2, 3, 7}, {1, 0, 4}};

		assertArrayEquals(expectedResult, KosarajusAlgorithm.findStronglyConnectedComponent(graph));
	}
}
