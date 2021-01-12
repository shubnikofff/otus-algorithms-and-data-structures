package ru.otus;

import ru.otus.factory.NodeFactory;

public class AVLTree extends BinarySearchTree {

	public AVLTree(NodeFactory nodeFactory) {
		super(nodeFactory);
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
