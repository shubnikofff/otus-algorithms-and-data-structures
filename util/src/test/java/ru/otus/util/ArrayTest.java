package ru.otus.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayTest {

    private final Integer[] array = new Integer[]{3, 9, 8, 7, 6, 2, 5, 4, 1};

    private final Integer[] expected = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Test
    void sort() {
        Array.sort(array);
        assertArrayEquals(expected, array);
    }
}
