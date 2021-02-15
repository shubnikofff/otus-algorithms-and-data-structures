package ru.otus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstSearchTest {

	private int[][] graph = {{1, 2, 3}, {0, 3, 4}, {0, 3}, {0, 1, 2, 4}, {1, 3}};

	@Test
	void search() {
		DepthFirstSearch.search(graph, 0, System.out::println);
	}
}
