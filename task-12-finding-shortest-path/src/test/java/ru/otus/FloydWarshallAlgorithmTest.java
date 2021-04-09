package ru.otus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.util.graph.Edge;

import static org.junit.jupiter.api.Assertions.*;

class FloydWarshallAlgorithmTest {

    private FloydWarshallAlgorithm algorithm;

    private static final Integer[][] GRAPH = {
            {0, -2, 7, 5},
            {null, 0, 8, 6},
            {null, 3, 0, -4},
            {-1, null, null, 0},
    };

    @BeforeEach
    void setUp() {
        algorithm = new FloydWarshallAlgorithm(GRAPH);
    }

    @Test
    void getDistances() {
        final float[][] expected = {
                {0, -2, 6, 2},
                {3, 0, 8, 4},
                {-5, -7, 0, -4},
                {-1, -3, 5, 0},
        };

        assertArrayEquals(expected, algorithm.getDistances());
    }

    @Test
    void findShortestPath() {
        assertArrayEquals(new Edge[]{}, algorithm.findShortestPath(1, 1));

        assertArrayEquals(new Edge[]{
                new Edge(0, 1, -2),
                new Edge(1, 2, 8),
                new Edge(2, 3, -4),
        }, algorithm.findShortestPath(0, 3));
    }
}
