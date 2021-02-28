package ru.otus;

import ru.otus.util.List;

import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class DemucronsAlgorithm {

    public static int[][] topologicalSort(int[][] graph) {
        final int[] powers = getColumnSums(graph);
        final boolean[] used = new boolean[powers.length];
        final List<List<Integer>> result = sort(graph, powers, used, new List<>());

        return toArray(result);
    }

    private static List<List<Integer>> sort(int[][] graph, int[] powers, boolean[] used, List<List<Integer>> result) {
        final List<Integer> currentLevelVertex = new List<>();
        int[] nextPowers = new int[powers.length];

        for (int i = 0; i < powers.length; i++) {
            if (powers[i] == 0 && !used[i]) {
                nextPowers = applyOperation(Integer::sum, graph[i], nextPowers);
                currentLevelVertex.add(i);
                used[i] = true;
            }
        }

        if (currentLevelVertex.size() == 0) {
            return result;
        }

        result.add(currentLevelVertex);

        return sort(graph, applyOperation((a, b) -> a - b, powers, nextPowers), used, result);
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
