package ru.otus.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayListWrapper<T> implements DynamicArray<T> {

    private final List<T> list = new ArrayList<>();

    @Override
    public void add(T item, int index) {
        list.add(index, item);
    }

    @Override
    public T remove(int index) {
        return list.remove(index);
    }
}
