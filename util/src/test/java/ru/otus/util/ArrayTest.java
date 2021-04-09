package ru.otus.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayTest {

    private Integer[] array;

    @BeforeEach
    void setUp() {
        array = new Integer[]{3, 9, 8, 7, 6, 2, 5, 4, 1};
    }

    @Test
    void sort() {
        Array.sort(array);
        final Integer[] expected = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        assertArrayEquals(expected, array);
    }

    @Test
    void reverse() {
        Array.reverse(array);
        final Integer[] expected = new Integer[]{1, 4, 5, 2, 6, 7, 8, 9, 3};

        assertArrayEquals(expected, array);
    }
}
