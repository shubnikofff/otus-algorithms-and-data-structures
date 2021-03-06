package ru.otus;

import ru.otus.util.List;

import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class DemucronsAlgorithm {

    public static int[][] topologicalSort(int[][] graph) {
        final int[] powersVector = getPowersVector(graph);
        final boolean[] used = new boolean[powersVector.length];
        final List<List<Integer>> result = sort(graph, powersVector, used, new List<>());

        return toArray(result);
    }

    private static List<List<Integer>> sort(int[][] graph, int[] powersVector, boolean[] used, List<List<Integer>> levels) {
        final List<Integer> vertexList = new List<>();
        int[] vector = new int[powersVector.length];

        for (int i = 0; i < powersVector.length; i++) {
            if (powersVector[i] == 0 && !used[i]) {
                vector = applyOperation(Integer::sum, graph[i], vector);
                vertexList.add(i);
                used[i] = true;
            }
        }

        if (vertexList.isEmpty()) {
            return levels;
        }

        levels.add(vertexList);

        return sort(graph, applyOperation((a, b) -> a - b, powersVector, vector), used, levels);
    }

    private static int[] getPowersVector(int[][] graph) {
        final int[] result = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            int sum = 0;
            for (final int[] row : graph) {
                sum += row[i];
            }

            result[i] = sum;
        }

        return result;
    }

    private static int[] applyOperation(BinaryOperator<Integer> operator, int[] a, int[] b) {
        if (b.length < a.length) {
            throw new IllegalArgumentException("Length of second term should be equal or greater than first");
        }

        return IntStream.range(0, a.length)
                .map(index -> operator.apply(a[index], b[index]))
                .toArray();
    }

    private static int[][] toArray(List<List<Integer>> list) {
        final int[][] result = new int[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            final List<Integer> item = list.get(i);
            result[i] = new int[item.size()];
            for (int j = 0; j < item.size(); j++) {
                result[i][j] = item.get(j);
            }
        }

        return result;
    }
}
