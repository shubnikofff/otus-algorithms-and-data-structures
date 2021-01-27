package ru.otus.bst;

public class Node {

	Node left;

	Node right;

	int key;

	int height;

	int priority;

	public Node(int key) {
		this.key = key;
		height = 0;
	}
}
