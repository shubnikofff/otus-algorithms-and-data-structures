package ru.otus;

import static java.lang.String.format;

public class BinarySearchTree {

	private Node root;

	public void insert(int value) {
		root = insert(root, value);
	}

	private Node insert(Node node, int value) {
		if (node == null) {
			return new Node(value);
		}

		if (value == node.getValue()) {
			throw new IllegalArgumentException(format("Node with value %d already exists", value));
		}

		if (value < node.getValue()) {
			node.setLeft(insert(node.getLeft(), value));
		} else {
			node.setRight(insert(node.getRight(), value));
		}

		return node;
	}

	public void remove(int value) {

	}

	public boolean search(int value) {
		return true;
	}

	public Node getRoot() {
		return root;
	}
}
