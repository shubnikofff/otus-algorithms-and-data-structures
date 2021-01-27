package ru.otus;

import static java.lang.String.format;

public class BinarySearchTree {

	Node root;

	public void insert(int value) {
		root = insert(root, value);
	}

	protected Node insert(Node node, int value) {
		if (node == null) {
			return new Node(value);
		}

		if (value == node.key) {
			throw new IllegalArgumentException(format("Node with value %d already exists", value));
		}

		if (value < node.key) {
			node.left = insert(node.left, value);
		} else {
			node.right = insert(node.right, value);
		}

		return node;
	}

	public void remove(int value) {
		root = remove(root, value);
	}

	protected Node remove(Node node, int value) {
		if (node == null) {
			return null;
		}

		if (value == node.key) {
			if (node.left == null && node.right == null) {
				return null;
			}

			if (node.left == null) {
				return node.right;
			}

			if (node.right == null) {
				return node.left;
			}

			final int smallestValue = findSmallestValue(node.right);
			node.key = smallestValue;
			node.right = remove(node.right, smallestValue);

			return node;
		}

		if (value < node.key) {
			node.left = remove(node.left, value);
		} else {
			node.right = remove(node.right, value);
		}

		return node;
	}

	private int findSmallestValue(Node node) {
		return node.left == null ? node.key : findSmallestValue(node.left);
	}

	public boolean search(int value) {
		return search(root, value);
	}

	private boolean search(Node node, int key) {
		if (node == null) {
			return false;
		}

		if (key == node.key) {
			return true;
		}

		return key < node.key ? search(node.left, key) : search(node.right, key);
	}
}
