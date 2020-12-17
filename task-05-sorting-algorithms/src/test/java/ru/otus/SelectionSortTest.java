package ru.otus;

import org.junit.jupiter.api.DisplayName;

@DisplayName("Selection Sort")
class SelectionSortTest extends AbstractSortTest {

    @Override
    void runSort(int[] array) {
        SelectionSort.sort(array);
    }
}
