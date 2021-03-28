package ru.otus;

import ru.otus.util.Array;
import ru.otus.util.List;
import ru.otus.util.graph.Edge;

import java.util.Arrays;

public class DijkstrasAlgorithm {

    private final Integer[][] graph;

    private final int startVertex;

    private final float[] distances;

    private final int[] prev;

    private final boolean[] used;

    public DijkstrasAlgorithm(Integer[][] graph, int startVertex) {
        this.graph = graph;
        this.startVertex = startVertex;

        distances = new float[graph.length];
        Arrays.fill(distances, Float.POSITIVE_INFINITY);
        distances[startVertex] = 0f;

        prev = new int[graph.length];
        used = new boolean[graph.length];

        findShortestPaths();
    }

    public Edge[] getShortestPath(int destination) {
        if (destination == startVertex) {
            return new Edge[]{};
        }

        final List<Edge> path = new List<>(graph.length - 1);
        int vertex = destination;

        while (vertex != startVertex) {
            int prev = this.prev[vertex];
            path.add(new Edge(prev, vertex, graph[prev][vertex]));
            vertex = prev;
        }

        final Edge[] result = path.toArray(new Edge[path.size()]);
        Array.reverse(result);

        return result;
    }

    private void findShortestPaths() {
        Integer vertex = findMinNotUsedVertex();

        while (vertex != null) {
            for (int i = 0; i < graph[vertex].length; i++) {
                final Integer neighborDistance = graph[vertex][i];
                if (neighborDistance != null) {
                    final float distance = distances[vertex] + neighborDistance;
                    if (distance < distances[i]) {
                        distances[i] = distance;
                        prev[i] = vertex;
                    }
                }
            }

            used[vertex] = true;
            vertex = findMinNotUsedVertex();
        }
    }

    private Integer findMinNotUsedVertex() {
        Integer min = null;

        for (int i = 0; i < distances.length; i++) {
            if (!used[i] && (min == null || distances[i] < distances[min])) {
                min = i;
            }
        }

        return min;
    }
}
