package ru.otus;

import java.util.function.Consumer;

public class DepthFirstSearch {

	public static void search(int[][] graph, int startVertex, Consumer<Integer> visit) {
		final boolean[] visited = new boolean[graph.length];
		final Stack<Integer> stack = new Stack<>();
		stack.push(startVertex);

		while (!stack.empty()) {
			final int vertex = stack.pop();
			visit.accept(vertex);

			for (int adjacentVertex : graph[vertex]) {
				if (!visited[adjacentVertex] && !stack.contains(adjacentVertex)) {
					visited[adjacentVertex] = true;
					stack.push(adjacentVertex);
				}
			}
		}
	}
}
