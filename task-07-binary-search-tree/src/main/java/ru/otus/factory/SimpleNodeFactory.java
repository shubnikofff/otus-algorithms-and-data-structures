package ru.otus.factory;

import ru.otus.Node;
import ru.otus.TreapNode;

import java.util.Random;

public class SimpleNodeFactory implements NodeFactory {

	@Override
	public Node createNode(int key) {
		return new Node(key);
	}

	@Override
	public TreapNode createTreapNode(int key, int priority) {
		return new TreapNode(key, priority);
	}
}
