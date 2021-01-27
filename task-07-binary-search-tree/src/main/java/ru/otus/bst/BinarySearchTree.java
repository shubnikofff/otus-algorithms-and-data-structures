package ru.otus.bst;

public class BinarySearchTree {

	Node root;

	public void insert(int value) {
		root = insert(root, value);
	}

	protected Node insert(Node node, int key) {
		if (node == null) {
			return new Node(key);
		}

		if (key == node.key) {
			return node;
		}

		if (key < node.key) {
			node.left = insert(node.left, key);
		} else {
			node.right = insert(node.right, key);
		}

		return node;
	}

	public void remove(int key) {
		root = remove(root, key);
	}

	protected Node remove(Node node, int key) {
		if (node == null) {
			return null;
		}

		if (key == node.key) {
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

		if (key < node.key) {
			node.left = remove(node.left, key);
		} else {
			node.right = remove(node.right, key);
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
