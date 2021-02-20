package ru.otus.util;

public class List<T> {

	private static final int INITIAL_LENGTH = 10;

	private static final int DEFAULT_FACTOR = 50;

	private Object[] array = new Object[INITIAL_LENGTH];

	private final int factor;

	private int size = 0;

	public List(int factor) {
		this.factor = factor;
	}

	public List() {
		this(DEFAULT_FACTOR);
	}

	public void add(T item) {
		if (size == array.length) {
			resize();
		}

		array[size++] = item;
	}

	@SuppressWarnings("unchecked")
	public T get(int index) {
		return (T) array[index];
	}

	@SuppressWarnings("unchecked")
	public T remove(int index) {
		final T item = (T) array[index];

		System.arraycopy(array, index + 1, array, index, size - index);
		size--;

		return item;
	}

	public int size() {
		return size;
	}

	private void resize() {
		final Object[] extendedArray = new Object[array.length + array.length * factor / 100];
		System.arraycopy(array, 0, extendedArray, 0, array.length);
		array = extendedArray;
	}

}
