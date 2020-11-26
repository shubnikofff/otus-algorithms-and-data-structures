package ru.otus;

public interface DynamicArray<T> {

    void add(T item, int index);

    T remove(int index);
}
