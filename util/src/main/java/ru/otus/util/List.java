package ru.otus.util;

import java.util.Arrays;
import java.util.Iterator;

public class List<E> implements Iterator<E> {

	private static final int INITIAL_LENGTH = 10;

	private static final int DEFAULT_FACTOR = 50;

	private Object[] array = new Object[INITIAL_LENGTH];

	private final int factor;

	private int cursor = 0;

	private int size = 0;

	public List(int factor) {
		this.factor = factor;
	}

	public List() {
		this(DEFAULT_FACTOR);
	}

	public void add(E item) {
		if (size == array.length) {
			resize();
		}

		array[size++] = item;
	}

	@SuppressWarnings("unchecked")
	public E get(int index) {
		return (E) array[index];
	}

	@SuppressWarnings("unchecked")
	public E remove(int index) {
		final E item = (E) array[index];

		System.arraycopy(array, index + 1, array, index, size - index);
		size--;

		return item;
	}

	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	public E[] toArray() {
		return (E[]) Arrays.copyOf(array, size);
	}

	private void resize() {
		final Object[] extendedArray = new Object[array.length + array.length * factor / 100];
		System.arraycopy(array, 0, extendedArray, 0, array.length);
		array = extendedArray;
	}

	@Override
	public boolean hasNext() {
		return cursor < size;
	}

	@Override
	public E next() {
		return get(cursor++);
	}
}
