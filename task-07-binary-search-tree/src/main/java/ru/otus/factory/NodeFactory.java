package ru.otus.factory;

import ru.otus.Node;
import ru.otus.TreapNode;

public interface NodeFactory {

	Node createNode(int key);

	TreapNode createTreapNode(int key, int priority);

}
