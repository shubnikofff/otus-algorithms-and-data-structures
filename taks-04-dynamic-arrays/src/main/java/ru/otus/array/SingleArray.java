package ru.otus.array;

import java.util.Arrays;

import static java.lang.System.arraycopy;

public class SingleArray<T> implements DynamicArray<T> {

    private Object[] array = new Object[0];

    public void add(T item, int index) {
        final Object[] newArray = new Object[array.length + 1];

        arraycopy(array, 0, newArray, 0, index);
        newArray[index] = item;
        arraycopy(array, index, newArray, index + 1, array.length - index);

        array = newArray;
    }

    public T remove(int index) {
        final T result = (T) array[index];
        final Object[] newArray = new Object[array.length - 1];

        arraycopy(array, 0, newArray, 0, index);
        arraycopy(array, index + 1,  newArray, index, newArray.length - index);

        array = newArray;

        return result;
    }
}
