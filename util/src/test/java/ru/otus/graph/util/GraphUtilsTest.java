package ru.otus.graph.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphUtilsTest {

    private int[][] graph;

    @BeforeEach
    void setUp() {
        graph = new int[][]{{1, 2, 3, 6}, {0, 7, 8}, {0, 3}, {0, 2, 5}, {5}, {3, 4}, {0}, {1, 8}, {1, 7}};
    }

    @Test
    void transpose() {
        final int[][] expectedResult = {{1, 2, 3, 6}, {0, 7, 8}, {0, 3}, {0, 2, 5}, {5}, {3, 4}, {0}, {1, 8}, {1, 7}};
        assertArrayEquals(expectedResult, GraphUtils.transpose(graph));
    }

    @Test
    void depthFirstSearchRecursive() {
        final int[] expectedResult = {8, 7, 1, 4, 5, 3, 2, 6, 0};
        final List<Integer> result = new ArrayList<>(graph.length);
        GraphUtils.depthFirstSearch(graph, 0, result::add);
        assertArrayEquals(expectedResult, result.stream().mapToInt(Integer::intValue).toArray());
    }
}
