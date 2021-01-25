package ru.otus;

public class Node {

	Node left;

	Node right;

	int key;

	int height;

	public Node(int key) {
		this.key = key;
		height = 0;
	}
}
