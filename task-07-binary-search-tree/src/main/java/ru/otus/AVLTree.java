package ru.otus;

import ru.otus.factory.NodeFactory;

public class AVLTree extends BinarySearchTree {

    public AVLTree(NodeFactory nodeFactory) {
        super(nodeFactory);
    }

    @Override
    protected Node insert(Node node, int value) {
        return balance(super.insert(node, value));
    }

    @Override
    protected Node remove(Node node, int value) {
        return balance(super.remove(node, value));
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

    private Node balance(Node node) {
        recalculateHeight(node);
        final int balance = getBalance(node);

        if (balance > 1) {
            node = getHeight(node.right.left) < getHeight(node.right.right) ? smallLeftRotation(node) : bigLeftRotation(node);
        } else if (balance < -1) {
            node = getHeight(node.left.right) < getHeight(node.left.left) ? smallRightRotation(node) : bigRightRotation(node);
        }

        return node;
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
        return node == null ? 0 : getHeight(node.right) - getHeight(node.left);
    }

    private void recalculateHeight(Node node) {
        if (node != null) {
            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }
    }
}