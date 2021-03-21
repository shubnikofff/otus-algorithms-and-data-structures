package ru.otus;

import ru.otus.util.List;
import ru.otus.util.graph.Edge;

public class FloydWarshallAlgorithm {

    private final Integer[][] graph;

    private final float[][] distances;

    private final Integer[][] next;

    public FloydWarshallAlgorithm(Integer[][] graph) {
        this.graph = graph;
        distances = new float[graph.length][graph.length];
        next = new Integer[graph.length][graph.length];
        init(graph);
        relax();
    }

    private void init(Integer[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                distances[i][j] = (i == j) ? 0 : (graph[i][j] == null) ? Float.POSITIVE_INFINITY : graph[i][j];
                next[i][j] = j;
            }
        }
    }

    private void relax() {
        for (int k = 0; k < distances.length; k++) {
            for (int i = 0; i < distances.length; i++) {
                for (int j = 0; j < distances.length; j++) {
                    final float altDistance = distances[i][k] + distances[k][j];
                    if (distances[i][j] > altDistance) {
                        distances[i][j] = altDistance;
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }

    public float[][] getDistances() {
        return distances;
    }

    public Edge[] findShortestPath(int u, int v) {
        if (u == v) {
            return new Edge[]{};
        }

        final List<Edge> path = new List<>();

        while (u != v) {
            final int next = this.next[u][v];
            path.add(new Edge(u, next, graph[u][next]));
            u = next;
        }

        return path.toArray(new Edge[path.size()]);
    }
}
