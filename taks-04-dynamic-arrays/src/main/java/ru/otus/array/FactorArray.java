package ru.otus.array;

import static java.lang.System.arraycopy;

public class FactorArray<T> implements DynamicArray<T> {

    private static final int INITIAL_LENGTH = 10;

    private static final int DEFAULT_FACTOR = 50;

    private Object[] array = new Object[INITIAL_LENGTH];

    private final int factor;

    private int size = 0;

    public FactorArray(int factor) {
        this.factor = factor;
    }

    public FactorArray() {
        this(DEFAULT_FACTOR);
    }

    @Override
    public void add(T item, int index) {
        final int newArraySize = array.length == size ? size + size * factor / 100 : array.length;
        final Object[] newArray = new Object[newArraySize];

        arraycopy(array, 0, newArray, 0, index);
        newArray[index] = item;
        arraycopy(array, index, newArray, index + 1, size - index);
        size++;

        array = newArray;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        final T result = (T) array[index];

        System.arraycopy(array, index + 1, array, index, size - index);
        size--;

        return result;
    }
}
