package ru.otus;

import ru.otus.factory.NodeFactory;

public class AVLTree extends BinarySearchTree {

	public AVLTree(NodeFactory nodeFactory) {
		super(nodeFactory);
	}

	private Node smallLeftRotation(Node y) {
		final Node x = y.right;
		final Node z = x.left;

		x.left = y;
		y.right = z;

		recalculateHeight(y);
		recalculateHeight(x);

		return x;

	}

	private Node smallRightRotation(Node y) {
		final Node x = y.left;
		final Node z = x.right;

		x.right = y;
		y.left = z;

		recalculateHeight(y);
		recalculateHeight(x);

		return x;
	}

	private Node bigLeftRotation(Node node) {
		node.right = smallRightRotation(node.right);
		return smallLeftRotation(node);
	}

	private Node bigRightRotation(Node node) {
		node.left = smallLeftRotation(node.left);
		return smallRightRotation(node);
	}

	private int getHeight(Node node) {
		return node == null ? 0 : node.height;
	}

	private int getBalance(Node node) {
		return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
	}

	private void recalculateHeight(Node node) {
		if (node != null) {
			node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		}
	}
}
