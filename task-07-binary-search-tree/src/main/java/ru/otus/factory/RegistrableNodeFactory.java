package ru.otus.factory;

import ru.otus.Node;

import java.util.Map;

public class RegistrableNodeFactory implements NodeFactory {

	private final Map<Integer, Node> registry;

	public RegistrableNodeFactory(Map<Integer, Node> registry) {
		this.registry = registry;
	}

	@Override
	public Node createNode(int key) {
		final Node node = new Node(key);
		registry.put(key, node);
		return node;
	}
}
