package ru.otus.graph.util;

import java.util.Arrays;
import java.util.function.Consumer;

public class GraphUtils {

    public static int[][] transpose(int[][] graph) {
        final int[][] transposedGraph = new int[graph.length][];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                final int index = graph[i][j];
                if (transposedGraph[index] == null) {
                    transposedGraph[index] = new int[1];
                } else {
                    transposedGraph[index] = Arrays.copyOf(transposedGraph[index], transposedGraph[index].length + 1);
                }
                transposedGraph[index][transposedGraph[index].length - 1] = i;
            }
        }

        return transposedGraph;
    }
}
