package ru.otus;

import ru.otus.list.FactorArrayList;
import ru.otus.list.List;

import java.util.EmptyStackException;

public class Stack<T> {

	private final List<T> list = new FactorArrayList<>();

	public T push(T item) {
		list.add(item);
		return item;
	}

	public T pop() {
		final int size = list.size();

		if (size == 0) {
			throw new EmptyStackException();
		}

		return list.remove(size - 1);
	}

	public boolean contains(T item) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == item) {
				return true;
			}
		}

		return false;
	}

	public boolean empty() {
		return list.size() == 0;
	}
}
