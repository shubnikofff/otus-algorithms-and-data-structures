package ru.otus.factory;

import ru.otus.Node;
import ru.otus.TreapNode;

import java.util.Map;

public class RegistrableNodeFactory implements NodeFactory {

	private final Map<Integer, Node> registry;

	private final NodeFactory nodeFactory = new SimpleNodeFactory();

	public RegistrableNodeFactory(Map<Integer, Node> registry) {
		this.registry = registry;
	}

	@Override
	public Node createNode(int key) {
		final Node node = nodeFactory.createNode(key);
		registry.put(key, node);
		return node;
	}

	@Override
	public TreapNode createTreapNode(int key, int priority) {
		final TreapNode node = nodeFactory.createTreapNode(key, priority);
		registry.put(key, node);
		return node;
	}
}
