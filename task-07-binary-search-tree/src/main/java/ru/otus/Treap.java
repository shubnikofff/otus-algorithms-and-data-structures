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
			result.leftNode = node;
			final SplitResult rightSplit = split((TreapNode) node.right, key);
			result.leftNode.right = rightSplit.leftNode;
			result.rightNode = rightSplit.rightNode;
		} else {
			result.rightNode = node;
			final SplitResult leftSplit = split((TreapNode) node.left, key);
			result.rightNode.left = leftSplit.rightNode;
			result.leftNode = leftSplit.leftNode;
		}

		return result;
	}

	@Override
	public void insert(int value) {
		final SplitResult splitResult = split((TreapNode) root, value);
		root = merge(merge(splitResult.leftNode, nodeFactory.createTreapNode(value, random.nextInt(MAX_PRIORITY))), splitResult.rightNode);
	}

	@Override
	public void remove(int value) {
		final SplitResult leftSplit = split((TreapNode) root, value - 1);
		final SplitResult rightSplit = split(leftSplit.rightNode, value);
		root = merge(leftSplit.leftNode, rightSplit.rightNode);
	}

	private static class SplitResult {

		private TreapNode leftNode;

		private TreapNode rightNode;
	}

}
