package ru.otus.graph.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphUtilsTest {

    private final int[][] graph = {{1, 2}, {0, 2}, {0}};

    @Test
    void transpose() {
        final int[][] expectedResult = {{1, 2}, {0}, {0, 1}};
        assertArrayEquals(expectedResult, GraphUtils.transpose(graph));
    }
}
