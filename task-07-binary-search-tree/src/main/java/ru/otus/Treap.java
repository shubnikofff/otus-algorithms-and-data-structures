package ru.otus;

import ru.otus.factory.NodeFactory;

import java.util.Random;

public class Treap extends BinarySearchTree {

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
			final TreapNode right = merge((TreapNode) leftNode.right, rightNode);
			final TreapNode node = nodeFactory.createTreapNode(leftNode.value, leftNode.priority);
			node.left = leftNode.left;
			node.right = right;
			return node;
		} else {
			final TreapNode left = merge(leftNode, (TreapNode) rightNode.left);
			final TreapNode node = nodeFactory.createTreapNode(rightNode.value, rightNode.priority);
			node.left = left;
			node.right = rightNode.right;
			return node;
		}
	}

	private void split(int delimiter, TreapNode root, TreapNode leftNode, TreapNode rightNode) {
		TreapNode newNode = null;
		if(root.value <= delimiter) {
			if(root.right == null) {
				rightNode = null;
			} else {
				split(delimiter, (TreapNode) root.right, newNode, rightNode);
			}

			leftNode = nodeFactory.createTreapNode(root.value, root.priority);
			leftNode.left = root.left;
			leftNode.right = newNode;
		} else {
			if(root.left == null) {
				leftNode = null;
			} else {
				split(delimiter, (TreapNode) root.left, leftNode, newNode);
			}

			rightNode = nodeFactory.createTreapNode(root.value, root.priority);
			rightNode.left = newNode;
			rightNode.right = root.right;
		}
	}

	public void insert(int value) {
		TreapNode left = null, right = null;

		split(value, (TreapNode) root, left, right);
		final TreapNode newNode = nodeFactory.createTreapNode(value, random.nextInt());
		merge(merge(left, newNode), right);
	}

	@Override
	public void remove(int value) {
		TreapNode left = null, middle = null, right = null;

		split(value - 1, (TreapNode) root, left, right);
		split(value, (TreapNode) root.right, middle, right);
		merge(left, right);
	}
}
