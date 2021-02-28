package ru.otus;

import ru.otus.util.List;

import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class DemucronsAlgorithm {

    public static int[][] sort(int[][] graph) {
        final int[] sums = getColumnSums(graph);
        return graph;
    }

    private static List<List<Integer>> sort(int[][] graph, int[] powers, List<List<Integer>> result) {
        final List<Integer> currentLevelVertex = new List<>();
        int[] sum = new int[powers.length];
        for (int i = 0; i < powers.length; i++) {
            if (powers[i] == 0) {
                sum = applyOperation(Integer::sum, graph[i], sum);
                currentLevelVertex.add(i);
            }
        }

        if (currentLevelVertex.size() == 0) {
            return result;
        }

        result.add(currentLevelVertex);

        return sort(graph, applyOperation((a, b) -> a - b, powers, sum), result);
    }

    private static int[] getColumnSums(int[][] graph) {
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
}
