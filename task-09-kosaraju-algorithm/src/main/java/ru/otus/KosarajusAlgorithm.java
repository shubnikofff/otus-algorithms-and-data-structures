package ru.otus;

import ru.otus.util.Graph;
import ru.otus.util.List;

import java.util.concurrent.atomic.AtomicInteger;

public class KosarajusAlgorithm {

    public static int[][] findStronglyConnectedComponent(int[][] graph) {

        final int[][] transposedGraph = Graph.transpose(graph);
        final int[] order = new int[transposedGraph.length];
        final AtomicInteger orderIndex = new AtomicInteger();
        boolean[] used = new boolean[transposedGraph.length];

        for (int i = 0; i < transposedGraph.length; i++) {
            if (!used[i]) {
                Graph.dfsRecursive(transposedGraph, i, used, vertex -> order[orderIndex.getAndIncrement()] = vertex);
            }
        }

        used = new boolean[order.length];
        final List<List<Integer>> componentList = new List<>();

        for (int i = order.length - 1; i > 0; i--) {
            if (!used[i]) {
                final List<Integer> component = new List<>();
                Graph.dfsRecursive(graph, order[i], used, component::add);
                componentList.add(component);
            }
        }

        final int[][] result = new int[componentList.size()][];
        for (int i = 0; i < componentList.size(); i++) {
            final List<Integer> component = componentList.get(i);
            result[i] = new int[component.size()];
            for (int j = 0; j < component.size(); j++) {
                result[i][j] = component.get(j);
            }
        }

        return result;
    }
}
