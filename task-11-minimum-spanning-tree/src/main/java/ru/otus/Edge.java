package ru.otus;

public class Edge implements Comparable<Edge> {

	private final int src;

	private final int dst;

	private final int weight;

	public Edge(int src, int dst, int weight) {
		this.src = src;
		this.dst = dst;
		this.weight = weight;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Edge)) {
			return false;
		}

		final Edge edge = (Edge) obj;

		return edge.weight == this.weight && (
				edge.src == this.src && edge.dst == this.dst || edge.dst == this.src && edge.src == this.dst
		);
	}

	@Override
	public int compareTo(Edge o) {
		return weight - o.weight;
	}
}
