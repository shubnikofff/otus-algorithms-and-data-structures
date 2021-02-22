package ru.otus;

public class DemucronsAlgorithm {

	public static int[][] sort(int[][] graph) {
		final int[] sums = getColumnSums(graph);
		return graph;
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
}
