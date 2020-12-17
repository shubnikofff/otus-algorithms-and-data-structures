package ru.otus;

import org.junit.jupiter.api.DisplayName;

@DisplayName("Heap Sort")
class HeapSortTest extends AbstractSortTest {

    @Override
    void runSort(int[] array) {
        HeapSort.sort(array);
    }
}
