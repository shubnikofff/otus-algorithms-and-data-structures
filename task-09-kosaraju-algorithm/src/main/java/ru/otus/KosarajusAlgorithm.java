package ru.otus;

import ru.otus.util.Graph;
import ru.otus.util.List;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class KosarajusAlgorithm {

	public static int[][] findStronglyConnectedComponent(int[][] graph) {

		final int[][] transposedGraph = Graph.transpose(graph);
		boolean[] used = new boolean[transposedGraph.length];
		final int[] order = new int[transposedGraph.length];
		final AtomicInteger orderIndex = new AtomicInteger(0);

		for (int i = 0; i < transposedGraph.length; i++) {
			if (!used[i]) {
				Graph.dfsRecursive(transposedGraph, i, vertex -> order[orderIndex.getAndIncrement()] = vertex);
			}

			used[i] = true;
		}

		used = new boolean[order.length];
		final List<List<Integer>> components = new List<>();
		for (int i = order.length - 1; i > 0; i--) {
			final List<Integer> component = new List<>();
			if (!used[i]) {
				Graph.dfsRecursive(graph, order[i], component::add);
			}
			used[i] = true;
			components.add(component);
		}

		return (int[][]) Arrays.stream(components.toArray()).map(List::toArray).toArray();

//		final Stack<Integer> order = new Stack<>();
//
//		for (int i = 0; i < transposedGraph.length; i++) {
//			if (!order.contains(i)) {
//				Graph.dfsRecursive(transposedGraph, i, order::push);
//			}
//		}
//
//		final List<List<Integer>> components = new List<>();
//		final boolean[] used = new boolean[order.size()];
//
//		while (!order.empty()) {
//			final Integer startVertex = order.pop();
//
//		}
//
//		return new int[1][];
	}

}
