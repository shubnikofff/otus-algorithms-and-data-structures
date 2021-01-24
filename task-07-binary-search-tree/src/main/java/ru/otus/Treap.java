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

		if(leftNode.priority < rightNode.priority) {
			leftNode.right = merge((TreapNode) leftNode.right, rightNode);
			return leftNode;
		} else {
			rightNode.left = merge(leftNode, (TreapNode) rightNode.left);
			return rightNode;
		}

//		if(leftNode.priority > rightNode.priority) {
//			final TreapNode right = merge((TreapNode) leftNode.right, rightNode);
//			final TreapNode node = nodeFactory.createTreapNode(leftNode.value, leftNode.priority);
//			node.left = leftNode.left;
//			node.right = right;
//			return node;
//		} else {
//			final TreapNode left = merge(leftNode, (TreapNode) rightNode.left);
//			final TreapNode node = nodeFactory.createTreapNode(rightNode.value, rightNode.priority);
//			node.left = left;
//			node.right = rightNode.right;
//			return node;
//		}
	}



//	private void split(int delimiter, TreapNode root, TreapNode leftNode, TreapNode rightNode) {
//		leftNode = rightNode = null;
//		if(root == null) {
//			return;
//		}
//
//		if(root.value < delimiter) {
//			split(delimiter, (TreapNode) root.right, (TreapNode) root.right, rightNode);
//			leftNode = root;
//		} else {
//			split(delimiter, (TreapNode) root.left, leftNode, (TreapNode) root.left);
//			rightNode = root;
//		}




//		TreapNode newNode = null;
//		if(root.value <= delimiter) {
//			if(root.right == null) {
//				rightNode = null;
//			} else {
//				split(delimiter, (TreapNode) root.right, newNode, rightNode);
//			}
//
//			leftNode = nodeFactory.createTreapNode(root.value, root.priority);
//			leftNode.left = root.left;
//			leftNode.right = newNode;
//		} else {
//			if(root.left == null) {
//				leftNode = null;
//			} else {
//				split(delimiter, (TreapNode) root.left, leftNode, newNode);
//			}
//
//			rightNode = nodeFactory.createTreapNode(root.value, root.priority);
//			rightNode.left = newNode;
//			rightNode.right = root.right;
//		}
//	}


	private SplitResult split(TreapNode node, int key) {
		final SplitResult result = new SplitResult();

		if (node == null) {
			return result;
		}

		if(key <= node.value) {
			final SplitResult leftSplit = split((TreapNode) node.left, key);
			result.left = leftSplit.left;
			result.right = node;
			result.left = leftSplit.right;
		} else {
			final SplitResult rightSplit = split((TreapNode) node.right, key);
			result.left = node;
			result.left.right = rightSplit.left;
			result.right  = rightSplit.right;
		}

//		if(node.value < key) {
//			final SplitResult rightResult = split((TreapNode) node.right, key);
//			rightResult.left = node;
//		}

		return result;
	}

	@Override
	public void insert(int value) {
//		TreapNode left = null, right = null;
		final SplitResult splitResult = split((TreapNode) root, value);
//		split(value, (TreapNode) root, left, right);
		root = merge(merge(splitResult.left, nodeFactory.createTreapNode(value, random.nextInt())), splitResult.right);
	}

	//	@Override
//	protected Node insert(Node node, int value) {
//		final TreapNode newNode = nodeFactory.createTreapNode(value, random.nextInt());
//		if(node == null) {
//			return newNode;
//		}
//
//		TreapNode left = null, right = null;
//		split(value, (TreapNode) node, left, right);
//		merge(merge(left, newNode), right);
//		return newNode;
//	}

	@Override
	public void remove(int value) {
//		TreapNode l = null, m = null, r = null;
//		split(value, (TreapNode) root, l, m);
//		split(value + 1, (TreapNode) root, m, r);

		final SplitResult leftSplit = split((TreapNode) root, value);
		final SplitResult rightSplit = split((TreapNode) root, value + 1);

		root = merge(leftSplit.left, rightSplit.right);
//		root = merge(l, r);
	}


//	@Override
//	public void remove(int value) {
//		TreapNode left = null, middle = null, right = null;
//
//		split(value - 1, (TreapNode) root, left, right);
//		split(value, (TreapNode) root.right, middle, right);
//		merge(left, right);
//	}

	private static class SplitResult {
		private TreapNode left;
		private TreapNode right;
	}

}
