package ru.otus;

public class TreapNode extends Node {

	int priority;

	public TreapNode(int key, int priority) {
		super(key);
		this.priority = priority;
	}
}
