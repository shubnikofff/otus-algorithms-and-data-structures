package ru.otus;

import ru.otus.factory.NodeFactory;

public class AVLTree extends BinarySearchTree {

    public AVLTree(NodeFactory nodeFactory) {
        super(nodeFactory);
    }

    private int getHeight(Node node) {
        return node == null ? 0 : node.getHeight();
    }

    private int getBalance(Node node) {
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    private int recalculateHeight(Node node) {
        return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
    }
}
