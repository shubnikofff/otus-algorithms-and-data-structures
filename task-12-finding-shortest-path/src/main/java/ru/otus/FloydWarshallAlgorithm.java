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
        for (int x = 0; x < graph.length; x++) {
            for (int y = 0; y < graph[x].length; y++) {
                distances[x][y] = (x == y)
                        ? 0
                        : (graph[x][y] == null) ? Float.POSITIVE_INFINITY : graph[x][y];
                next[x][y] = y;
            }
        }
    }

    private void relax() {
        for (int k = 0; k < distances.length; k++) {
            for (int x = 0; x < distances.length; x++) {
                for (int y = 0; y < distances.length; y++) {
                    final float altDistance = distances[x][k] + distances[k][y];
                    if (distances[x][y] > altDistance) {
                        distances[x][y] = altDistance;
                        next[x][y] = next[x][k];
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
            int nextIndex = next[u][v];
            path.add(new Edge(u, nextIndex, graph[u][nextIndex]));
            u = nextIndex;
        }

        return path.toArray(new Edge[path.size()]);
    }
}
