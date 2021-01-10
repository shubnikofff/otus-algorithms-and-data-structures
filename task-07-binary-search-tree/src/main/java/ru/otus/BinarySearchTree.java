package ru.otus;

import ru.otus.factory.NodeFactory;

import static java.lang.String.format;

public class BinarySearchTree {

    private Node root;

    private final NodeFactory nodeFactory;

    public BinarySearchTree(NodeFactory nodeFactory) {
        this.nodeFactory = nodeFactory;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return nodeFactory.createNode(value);
        }

        if (value == node.getValue()) {
            throw new IllegalArgumentException(format("Node with value %d already exists", value));
        }

        if (value < node.getValue()) {
            final Node left = insert(node.getLeft(), value);
            node.setLeft(left);
        } else {
            final Node right = insert(node.getRight(), value);
            node.setRight(right);
        }

        return node;
    }

    public void remove(int value) {
        root = remove(root, value);
    }

    private Node remove(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value == node.getValue()) {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }

            if (node.getLeft() == null) {
                return node.getRight();
            }

            if (node.getRight() == null) {
                return node.getLeft();
            }

            final int smallestValue = findSmallestValue(node.getRight());
            node.setValue(smallestValue);
            final Node right = remove(node.getRight(), smallestValue);
            node.setRight(right);
            return node;
        }

        if (value < node.getValue()) {
            final Node left = remove(node.getLeft(), value);
            node.setLeft(left);
        } else {
            final Node right = remove(node.getRight(), value);
            node.setRight(right);
        }

        return node;
    }

    private int findSmallestValue(Node node) {
        return node.getLeft() == null ? node.getValue() : findSmallestValue(node.getLeft());
    }

    public boolean search(int value) {
        return search(root, value);
    }

    private boolean search(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (value == node.getValue()) {
            return true;
        }

        return value < node.getValue() ? search(node.getLeft(), value) : search(node.getRight(), value);
    }
}
