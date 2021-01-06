package ru.otus.factory;

import ru.otus.Node;

public class SimpleNodeFactory implements NodeFactory {

	@Override
	public Node createNode(int key) {
		return new Node(key);
	}
}
