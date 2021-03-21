package ru.otus;

import ru.otus.util.graph.Edge;

import java.util.Arrays;

public class DijkstrasAlgorithm {

	private final int[][] graph;

	private final float[] distances;

	public DijkstrasAlgorithm(int[][] graph) {
		this.graph = graph;
		distances = new float[graph.length];
	}

	private void init() {
		Arrays.fill(distances, Float.POSITIVE_INFINITY);
	}

	public Edge[] findShortestPath(int u, int v) {
		distances[u] = 0f;
	}
}
