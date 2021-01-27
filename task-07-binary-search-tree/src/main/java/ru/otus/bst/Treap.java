package ru.otus.bst;

import java.util.Random;

public class Treap extends BinarySearchTree {

	private final Random random = new Random();

	private Node merge(Node leftNode, Node rightNode) {
		if (leftNode == null) {
			return rightNode;
		}

		if (rightNode == null) {
			return leftNode;
		}

		if(leftNode.priority > rightNode.priority) {
			leftNode.right = merge(leftNode.right, rightNode);
			return leftNode;
		} else {
			rightNode.left = merge(leftNode, rightNode.left);
			return rightNode;
		}
	}

	private SplitResult split(Node node, int key) {
		final SplitResult result = new SplitResult();

		if (node == null) {
			return result;
		}

		if(node.key <= key) {
			result.leftNode = node;
			final SplitResult rightSplit = split(node.right, key);
			result.leftNode.right = rightSplit.leftNode;
			result.rightNode = rightSplit.rightNode;
		} else {
			result.rightNode = node;
			final SplitResult leftSplit = split(node.left, key);
			result.rightNode.left = leftSplit.rightNode;
			result.leftNode = leftSplit.leftNode;
		}

		return result;
	}

	@Override
	protected Node insert(Node node, int value) {
		Node newNode = new Node(value);
		newNode.priority = random.nextInt();
		final SplitResult splitResult = split(node, value);
		return merge(merge(splitResult.leftNode, newNode), splitResult.rightNode);
	}

	@Override
	protected Node remove(Node node, int value) {
		final SplitResult leftSplit = split(node, value - 1);
		final SplitResult rightSplit = split(leftSplit.rightNode, value);
		return merge(leftSplit.leftNode, rightSplit.rightNode);
	}

	private static class SplitResult {

		private Node leftNode;

		private Node rightNode;
	}

}
