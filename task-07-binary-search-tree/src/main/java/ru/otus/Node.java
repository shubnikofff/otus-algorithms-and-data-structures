package ru.otus;

public class Node {

	Node left;

	Node right;

	int value;

	int height;

	public Node(int value) {
		this.value = value;
		height = 0;
	}
}
