package ru.otus;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstSearchTest {

    private final int[][] graph = {{1, 2, 3, 6}, {0, 7, 8}, {0, 3}, {0, 2, 5}, {5}, {3, 4}, {0}, {1, 8}, {1, 7}};
    private final int[] expectedResult = {0, 6, 3, 5, 4, 2, 1, 8, 7};

    @Test
    void search() {
        final List<Integer> result = new ArrayList<>(graph.length);
        DepthFirstSearch.search(graph, 0, result::add);
        assertArrayEquals(expectedResult, result.stream().mapToInt(Integer::intValue).toArray());
    }
}
