package ru.otus;

import ru.otus.factory.NodeFactory;

import static java.lang.String.format;

public class BinarySearchTree {

	private Node root;

	private final NodeFactory nodeFactory;

	public BinarySearchTree(NodeFactory nodeFactory) {
		this.nodeFactory = nodeFactory;
	}

	public void insert(int value) {
		root = insert(root, value);
	}

	private Node insert(Node node, int value) {
		if (node == null) {
			return nodeFactory.createNode(value);
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
		return search(root, value);
	}

	private boolean search(Node node, int value) {
		if (node == null) {
			return false;
		}

		if (value == node.getValue()) {
			return true;
		}

		return value < node.getValue() ? search(node.getLeft(), value) : search(node.getRight(), value);
	}
}
