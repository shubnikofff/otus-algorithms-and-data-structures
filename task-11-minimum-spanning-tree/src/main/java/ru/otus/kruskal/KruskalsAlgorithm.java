package ru.otus.kruskal;

import ru.otus.Edge;
import ru.otus.util.Array;
import ru.otus.util.List;

public class KruskalsAlgorithm {

    public static Edge[] findMST(int[][] graph) {
        final DisjointSetSystem dss = new DisjointSetSystem(graph.length);
        final Edge[] edges = getEdges(graph);
        Array.sort(edges);

        final Edge[] mst = new Edge[graph.length - 1];
        int mstIndex = 0;

        for (final Edge edge : edges) {
            if (mstIndex == graph.length - 1) {
                break;
            }

            if (dss.union(edge.getSrc(), edge.getDst())) {
                mst[mstIndex++] = edge;
            }
        }

        return mst;
    }

    private static Edge[] getEdges(int[][] graph) {
        final List<Edge> edgeList = new List<>();

        int delta = 1;
        for (int i = 0; i < graph.length - 1; i++) {
            for (int j = delta; j < graph[i].length; j++) {
                if (graph[i][j] != 0) {
                    edgeList.add(new Edge(i, j, graph[i][j]));
                }
            }
            delta++;
        }

        return edgeList.toArray(new Edge[edgeList.size()]);
    }

}
