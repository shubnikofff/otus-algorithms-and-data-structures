package ru.otus;

import ru.otus.util.List;

import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class DemucronsAlgorithm {

    private final static short USED_POWER = -1;

    public static int[][] topologicalSort(int[][] graph) {
        final int[] powersVector = getPowersVector(graph);
        final List<List<Integer>> result = sort(graph, powersVector, new List<>());

        return toArray(result);
    }

    private static List<List<Integer>> sort(int[][] graph, int[] powersVector, List<List<Integer>> levels) {
        final List<Integer> vertexList = new List<>();
        int[] vector = new int[powersVector.length];

        for (int i = 0; i < powersVector.length; i++) {
            if (powersVector[i] == 0) {
                vector = applyOperation(Integer::sum, graph[i], vector);
                vertexList.add(i);
                powersVector[i] = USED_POWER;
            }
        }

        if (vertexList.size() == 0) {
            return levels;
        }

        levels.add(vertexList);

        return sort(graph, applyOperation((a, b) -> a - b, powersVector, vector), levels);
    }

    private static int[] getPowersVector(int[][] graph) {
        int[] vector = new int[graph.length];

        for (final int[] row : graph) {
            vector = applyOperation(Integer::sum, row, vector);
        }

        return vector;
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
