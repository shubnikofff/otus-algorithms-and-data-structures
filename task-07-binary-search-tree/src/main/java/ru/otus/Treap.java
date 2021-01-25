package ru.otus;

import ru.otus.factory.NodeFactory;

import java.util.Random;

public class Treap extends BinarySearchTree {

	public static final int MAX_PRIORITY = 10_000;

	private final Random random;

	public Treap(NodeFactory nodeFactory) {
		super(nodeFactory);
		random = new Random();
	}

	private TreapNode merge(TreapNode leftNode, TreapNode rightNode) {
		if (leftNode == null) {
			return rightNode;
		}

		if (rightNode == null) {
			return leftNode;
		}

		if(leftNode.priority > rightNode.priority) {
			leftNode.right = merge((TreapNode) leftNode.right, rightNode);
			return leftNode;
		} else {
			rightNode.left = merge(leftNode, (TreapNode) rightNode.left);
			return rightNode;
		}
	}

	private SplitResult split(TreapNode node, int key) {
		final SplitResult result = new SplitResult();

		if (node == null) {
			return result;
		}

		if(node.key <= key) {
			result.left = node;
			final SplitResult rightSplit = split((TreapNode) node.right, key);
			result.left.right = rightSplit.left;
			result.right = rightSplit.right;
		} else {
			result.right = node;
			final SplitResult leftSplit = split((TreapNode) node.left, key);
			result.right.left = leftSplit.right;
			result.left = leftSplit.left;
		}

		return result;
	}

	@Override
	public void insert(int value) {
		final SplitResult splitResult = split((TreapNode) root, value);
		root = merge(merge(splitResult.left, nodeFactory.createTreapNode(value, random.nextInt(MAX_PRIORITY))), splitResult.right);
	}

	@Override
	public void remove(int value) {
		final SplitResult leftSplit = split((TreapNode) root, value);
		final SplitResult rightSplit = split((TreapNode) root, value + 1);
		root = merge(leftSplit.left, rightSplit.right);
	}

	private static class SplitResult {

		private TreapNode left;

		private TreapNode right;
	}

}
